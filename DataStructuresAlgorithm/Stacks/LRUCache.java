package Stacks;
import java.util.HashMap;
import java.util.Map;
class LRUCacheClass {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    Map<Integer, Node> m = new HashMap<>();
    public LRUCacheClass(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    private void addNode(Node newnode) {
        Node temp = head.next;
        newnode.next = temp;
        newnode.prev = head;
        head.next = newnode;
        temp.prev = newnode;
    }
    private void deleteNode(Node delnode) {
        Node prevv = delnode.prev;
        Node nextt = delnode.next;
        prevv.next = nextt;
        nextt.prev = prevv;
    }
    public int get(int key) {
        if (m.containsKey(key)) {
            Node resNode = m.get(key);
            int ans = resNode.val;
            m.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            m.put(key, head.next);
            return ans;
        }
        return -1;
    }
    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node curr = m.get(key);
            m.remove(key);
            deleteNode(curr);
        }
        if (m.size() == cap) {
            m.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        addNode(new Node(key, value));
        m.put(key, head.next);
    }
}

public class LRUCache {
    public static void main(String[] args) {
        LRUCacheClass lruCache = new LRUCacheClass(2);
        System.out.println("Output:");
        System.out.print("[");
        System.out.print("null, ");
        lruCache.put(1, 1);
        System.out.print("null, ");
        lruCache.put(2, 2);
        System.out.print("null, ");
        System.out.print(lruCache.get(1) + ", ");
        lruCache.put(3, 3); // Calling put(3, 3)
        System.out.print("null, "); // Output for put(3, 3)
        System.out.print(lruCache.get(2) + ", "); // Output for get(2)
        lruCache.put(4, 4); // Calling put(4, 4)
        System.out.print("null, "); // Output for put(4, 4)
        System.out.print(lruCache.get(1) + ", "); // Output for get(1)
        System.out.print(lruCache.get(3) + ", "); // Output for get(3)
        System.out.print(lruCache.get(4)); // Output for get(4)
        System.out.println("]");
    }
}