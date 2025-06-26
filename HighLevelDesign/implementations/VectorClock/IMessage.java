package HighLevelDesign.implementations.VectorClock;

interface IMessage {
    String getText();
    int[] getVectorClock();
}
