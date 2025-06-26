package HighLevelDesign.implementations.VectorClock;

interface IVectorClock {
    void increment(int index);
    void merge(int[] receivedClock);
    int[] getClock();
    String toString();
}
