package Designs.CustomizeStack;
import java.util.*;
class FreqStack {
    Map<Integer, Integer> map;
    PriorityQueue<int[]> q;
    int id;
    public FreqStack() {
        map = new HashMap<>();
        id = 0;
        q = new PriorityQueue<>((a, b) -> {
            if(b[1] != a[1]) return b[1] - a[1];    
            else return b[2] - a[2];
        });
    }
    public void push(int val) {
        int freq = map.getOrDefault(val, 0) + 1;
        map.put(val, freq);
        id++;
        q.add(new int[]{val, freq, id});
    }
    public int pop() {
        int[] max = q.poll();
        map.put(max[0], max[1]-1);
        return max[0];
    }
}
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
public class FrequencyStackDesign {
    public static void main(String[] args) {
        FreqStack obj = new FreqStack();
        obj.push(5);
        obj.push(7);
        obj.push(5);
        obj.push(7);
        obj.push(4);
        obj.push(5);
        System.out.println(obj.pop()); // Output: 5
        System.out.println(obj.pop()); // Output: 7
        System.out.println(obj.pop()); // Output: 5
        System.out.println(obj.pop()); // Output: 4
    }
}