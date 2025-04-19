package Designs.CustomizeStack;

interface StackStorage<T> {
    void push(T value);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
}
