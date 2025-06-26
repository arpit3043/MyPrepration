package HighLevelDesign.implementations.VectorClock;

class DistributedSystem {
    private final Node[] nodes;

    public DistributedSystem(int numNodes) {
        nodes = new Node[numNodes];
        for (int i = 0; i < numNodes; i++) {
            nodes[i] = new Node(i, numNodes);
        }
    }

    public void simulate() {
        nodes[0].sendMessage(nodes[1], "Hello from Node 0");
        nodes[1].sendMessage(nodes[2], "Hello from Node 1");
        nodes[2].sendMessage(nodes[0], "Hello from Node 2");

        printNodeStates();
    }

    private void printNodeStates() {
        for (Node node : nodes) {
            System.out.println(node);
        }
    }
}
