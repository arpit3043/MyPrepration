package Stacks;
public class TowerOfHanoiUsingStack {
    public static void main(String[] args) throws Exception {
        int num_of_disks = 3;
        TowerOfHanoiUsingStack toh = new TowerOfHanoiUsingStack();
        Stack src, dest, aux;
        // Create three stacks of size 'num_of_disks'
        // to hold the disks
        src = toh.createStack(num_of_disks);
        dest = toh.createStack(num_of_disks);
        aux = toh.createStack(num_of_disks);
        toh.tohIterative(num_of_disks, src, aux, dest);
    }
    // A structure to represent a stack
    class Stack {
        int capacity;
        int top;
        int[] array;
    }
    Stack createStack(int capacity) {
        Stack stack = new Stack();
        stack.capacity = capacity;
        stack.top = -1;
        stack.array = new int[capacity];
        return stack;
    }
    private static boolean isFull(Stack stack) {
        return (stack.top == stack.capacity - 1);
    }
    // Stack is empty when top is equal to -1
    private static boolean isEmpty(Stack stack) {
        return (stack.top == -1);
    }
    // Function to add an item to stack. It increases top by 1
    private static void push(Stack stack, int item) {
        if (isFull(stack)) {
            return;
        }
        stack.array[++stack.top] = item;
    }
    // Function to remove an item from stack. It decreases top by 1
    private static int pop(Stack stack) {
        if (isEmpty(stack)) {
            return Integer.MIN_VALUE;
        }
        return stack.array[stack.top--];
    }

    // Function to implement legal movement between two poles
    private static void moveDisksBetweenTwoPoles(Stack src, Stack dest, char s, char d) {
        int pole1TopDisk = pop(src);
        int pole2TopDisk = pop(dest);
        // When pole 1 is empty
        if (pole1TopDisk == Integer.MIN_VALUE) {
            push(src, pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        } else if (pole2TopDisk == Integer.MIN_VALUE) {
            // When pole2 pole is empty
            push(dest, pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        } else if (pole1TopDisk > pole2TopDisk) {
            // When top disk of pole1 > top disk of pole2
            push(src, pole1TopDisk);
            push(src, pole2TopDisk);
            moveDisk(d, s, pole2TopDisk);
        } else {
            // When top disk of pole1 < top disk of pole2
            push(dest, pole2TopDisk);
            push(dest, pole1TopDisk);
            moveDisk(s, d, pole1TopDisk);
        }
    }
    // Function to show the movement of disks
    private static void moveDisk(char fromPeg, char toPeg, int disk) {
        System.out.println("Move the disk " + disk +
                " from " + fromPeg +
                " to " + toPeg);
    }
    // Function to implement TOH puzzle
    private static void tohIterative(int num_of_disks, Stack src, Stack aux, Stack dest) {
        int i, total_num_of_moves;
        char s = 'S';
        char d = 'D';
        char a = 'A';
        // If number of disks is even,
        // then interchange destination pole and auxiliary pole
        if (num_of_disks % 2 == 0) {
            char temp = d;
            d = a;
            a = temp;
        }
        total_num_of_moves = (int)(Math.pow(
                2, num_of_disks) - 1);
        for(i = num_of_disks; i >= 1; i--) {
            push(src, i);
        }
        for(i = 1; i <= total_num_of_moves; i++) {
            if (i % 3 == 1) {
                moveDisksBetweenTwoPoles(src, dest, s, d);
            } else if (i % 3 == 2) {
                moveDisksBetweenTwoPoles(src, aux, s, a);
            } else if (i % 3 == 0) {
                moveDisksBetweenTwoPoles(aux, dest, a, d);
            }
        }
    }
}