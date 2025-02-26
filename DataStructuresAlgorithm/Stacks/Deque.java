package Stacks;
class LinkedListNode{
    int data;
    LinkedListNode next;
    LinkedListNode prev;
    LinkedListNode(int data) {
        this.data=data;
        next=null;
        prev=null;
    }
}
public class Deque {
    LinkedListNode start;
    LinkedListNode tail;
    int Maxsize;
    int size;

    public Deque(int n) {
        start = new LinkedListNode(-1);
        tail = new LinkedListNode(-1);
        start.next = tail;
        tail.prev = start;
        size = 0;
        Maxsize = n;
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushFront(int x) {
        if (size == Maxsize) {
            return false;
        }
        LinkedListNode temp = new LinkedListNode(x);
        LinkedListNode startnext = start.next;
        start.next = temp;
        temp.prev = start;
        temp.next = startnext;
        startnext.prev = temp;
        size++;
        return true;
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushRear(int x) {
        if (size == Maxsize) {
            return false;
        }
        LinkedListNode temp = new LinkedListNode(x);
        LinkedListNode tailprev = tail.prev;
        tail.prev = temp;
        temp.next = tail;
        temp.prev = tailprev;
        tailprev.next = temp;
        size++;
        return true;
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        int nodeData = start.next.data;
        LinkedListNode temp = start.next;
        start.next = temp.next;
        temp.next.prev = start;
        size--;
        return nodeData;
    }

    public int popRear() {
        if (size == 0) {
            return -1;
        }
        int nodeData = tail.prev.data;
        LinkedListNode temp = tail.prev;
        temp.prev.next = tail;
        tail.prev = temp.prev;
        size--;
        return nodeData;
    }

    public int getFront() {
        if (size == 0) {
            return -1;
        }
        int nodeData = start.next.data;
        return nodeData;
    }

    public int getRear() {
        if (size == 0) {
            return -1;
        }
        int nodeData = tail.prev.data;
        return nodeData;
    }

    // Returns true if the deque is empty. Otherwise returns false.
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    // Returns true if the deque is full. Otherwise returns false.
    public boolean isFull() {
        if (size == Maxsize) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Creating a deque with a maximum size of 5
        Deque deque = new Deque(5);
        deque.pushFront(1);
        deque.pushRear(2);
        deque.pushFront(3);
        deque.pushRear(4);
        // Displaying the contents of the deque
        System.out.println("Deque after pushing elements: ");
        displayDeque(deque);

        // Testing popFront and popRear
        int poppedFront = deque.popFront();
        int poppedRear = deque.popRear();

        // Displaying the contents of the deque after popping elements
        System.out.println("\nDeque after popping elements: ");
        displayDeque(deque);

        // Testing getFront, getRear, isEmpty, and isFull
        System.out.println("\nFront element: " + deque.getFront());
        System.out.println("Rear element: " + deque.getRear());
        System.out.println("Is the deque empty? " + deque.isEmpty());
        System.out.println("Is the deque full? " + deque.isFull());
    }

    private static void displayDeque(Deque deque) {
        while (!deque.isEmpty()) {
            System.out.print(deque.popFront() + " ");
        }
        System.out.println();
    }
}