package Designs.CustomizeStack;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TTLStack<T> implements StackStorage<T> {
    private static long TTL_MILLIS = 60000;
    private final Deque<StackElement<T>> stack = new ConcurrentLinkedDeque<>();
    private final EvictionStrategy<T> evictionStrategy;

    public TTLStack(EvictionStrategy<T> strategy) {
        this.evictionStrategy = strategy;
        startEvictionTask();
    }

    public static void setGlobalTTLSeconds(long ttlSeconds) {
        TTL_MILLIS = ttlSeconds * 1000;
    }

    @Override
    public void push(T value) {
        stack.push(new StackElement<>(value, TTL_MILLIS));
    }

    @Override
    public T pop() {
        evictExpired();
        StackElement<T> top = stack.poll();
        return top != null ? top.getValue() : null;
    }

    @Override
    public T peek() {
        evictExpired();
        StackElement<T> top = stack.peek();
        return top != null ? top.getValue() : null;
    }

    @Override
    public int size() {
        evictExpired();
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        evictExpired();
        return stack.isEmpty();
    }

    private void evictExpired() {
        evictionStrategy.evict(stack);
    }

    private void startEvictionTask() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(this::evictExpired, TTL_MILLIS, TTL_MILLIS, TimeUnit.MILLISECONDS);
    }
}
