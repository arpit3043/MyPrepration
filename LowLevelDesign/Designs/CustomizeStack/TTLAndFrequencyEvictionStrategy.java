package Designs.CustomizeStack;

import java.util.Deque;
import java.util.Iterator;

class TTLAndFrequencyEvictionStrategy<T> implements EvictionStrategy<T> {
    @Override
    public void evict(Deque<StackElement<T>> stack) {
        Iterator<StackElement<T>> iterator = stack.iterator();
        while (iterator.hasNext()) {
            StackElement<T> elem = iterator.next();
            if (elem.isExpired()) {
                iterator.remove();
            }
        }
    }
}
