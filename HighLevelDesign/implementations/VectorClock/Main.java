package HighLevelDesign.implementations.VectorClock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    // Initialize the distributed system with 3 nodes
        DistributedSystem system = new DistributedSystem(3);
        system.simulate();
    }
}
