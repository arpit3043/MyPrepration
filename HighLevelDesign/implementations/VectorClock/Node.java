package HighLevelDesign.implementations.VectorClock;

class Node implements IMessageHandler {
    private final int nodeId;
    private final IVectorClock vectorClock;

    public Node(int nodeId, int totalNodes) {
        this.nodeId = nodeId;
        this.vectorClock = new VectorClock(totalNodes);
    }

    public void sendMessage(Node receiver, String messageText) {
        vectorClock.increment(nodeId);
        IMessage message = new Message(messageText, vectorClock.getClock());
        receiver.handleMessage(message);
    }

    @Override
    public void handleMessage(IMessage message) {
        vectorClock.merge(message.getVectorClock());
        vectorClock.increment(nodeId);
        System.out.println("Node " + nodeId + " received message: " + message.getText());
        System.out.println("Updated vector clock: " + vectorClock);
    }

    @Override
    public String toString() {
        return "Node " + nodeId + " - Vector Clock: " + vectorClock;
    }
}
