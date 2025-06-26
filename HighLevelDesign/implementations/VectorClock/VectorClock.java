package HighLevelDesign.implementations.VectorClock;

import java.util.Arrays;

class VectorClock implements IVectorClock {
    private final int[] clock;

    public VectorClock(int totalNodes) {
        this.clock = new int[totalNodes];
    }

    @Override
    public void increment(int index) {
        clock[index]++;
    }

    @Override
    public void merge(int[] receivedClock) {
        for (int i = 0; i < clock.length; i++) {
            clock[i] = Math.max(clock[i], receivedClock[i]);
        }
    }

    @Override
    public int[] getClock() {
        return Arrays.copyOf(clock, clock.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(clock);
    }
}
