package Stack;

public class StackImplementation {
    static class Stack {
        private int capacity = 0;
        private int top;
        private int[] arr;
        Stack(int capacity) {
            // Write your code here.
            this.capacity = capacity;
            this.arr = new int[capacity];
            this.top = -1;
        }
        
        public void push(int num) {
            // Write your code here.
            if(isFull() == 1) {
                return ;
            }
            top++;
            arr[top] = num;
        }
        
        public int pop() {
            // Write your code here.
            if(isEmpty() == 1) {
                return -1;
            }
            return arr[top--];
        }
        
        public int top() {
            // Write your code here.
            if(isEmpty() == 1) {
                return -1;
            }
            return arr[top];
        }
        
        public int isEmpty() {
            // Write your code here.
            if(top == -1) {
                return 1;
            }
            return 0;
        }
        
        public int isFull() {
            // Write your code here.
            if(top == capacity-1) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        // Example usage
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop()); // 20
        System.out.println(stack.top()); // 10
        System.out.println(stack.isEmpty()); // 0 (not empty)
        System.out.println(stack.isFull()); // 0 (not full)
    }
}