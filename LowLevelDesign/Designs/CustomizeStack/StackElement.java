package Designs.CustomizeStack;

import java.util.concurrent.atomic.AtomicInteger;

class StackElement<T> {
    private final T value;
    private final long expiryTime;
    private final AtomicInteger frequency = new AtomicInteger(0);

    public StackElement(T value, long ttlMillis) {
        this.value = value;
        this.expiryTime = System.currentTimeMillis() + ttlMillis;
    }

    public T getValue() {
        frequency.incrementAndGet();
        return value;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }

    public int getFrequency() {
        return frequency.get();
    }
}

