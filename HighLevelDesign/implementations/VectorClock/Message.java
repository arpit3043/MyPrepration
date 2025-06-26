package HighLevelDesign.implementations.VectorClock;

import java.util.Arrays;

class Message implements IMessage {
    private final String text;
    private final int[] vectorClock;

    public Message(String text, int[] vectorClock) {
        this.text = text;
        this.vectorClock = Arrays.copyOf(vectorClock, vectorClock.length);
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public int[] getVectorClock() {
        return vectorClock;
    }
}
