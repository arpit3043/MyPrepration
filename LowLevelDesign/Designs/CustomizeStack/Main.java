package Designs.CustomizeStack;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TTLStack<String> stack = new TTLStack<>(new TTLAndFrequencyEvictionStrategy<>());
        TTLStack.setGlobalTTLSeconds(3); // TTL = 3s

        stack.push("Hello");
        Thread.sleep(2000);
        stack.push("World");

        System.out.println("Peek: " + stack.peek()); // World
        Thread.sleep(2000);

        System.out.println("Pop: " + stack.pop()); // World
        System.out.println("Pop: " + stack.pop()); // null (Hello expired)
    }
}
