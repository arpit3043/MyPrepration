package Designs.CustomizeStack;

import java.util.Deque;

interface EvictionStrategy<T> {
    void evict(Deque<StackElement<T>> stack);
}
