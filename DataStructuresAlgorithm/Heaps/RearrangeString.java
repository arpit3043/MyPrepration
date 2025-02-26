package Heaps;
import java.util.PriorityQueue;
import java.lang.StringBuilder;
import java.lang.String;
public class RearrangeString {
    public static void main(String[] args) throws Exception {
        String str = "aac";
        System.out.println(rearrangeString(str));
    }
    private static String rearrangeString(String str) {
        int[] count = new int[26];
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
                (a, b) -> count[b - 'a'] - count[a - 'a']
        );
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.offer((char) (i + 'a'));
            }
        }
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            if (result.isEmpty() || result.charAt(result.length() - 1) != current) {
                result.append(current);
                count[current - 'a']--;
                if (count[current - 'a'] > 0) {
                    maxHeap.offer(current);
                }
            } else {
                if (!maxHeap.isEmpty()) {
                    char next = maxHeap.poll();
                    result.append(next);
                    count[next - 'a']--;
                    if (count[next - 'a'] > 0) {
                        maxHeap.offer(next);
                    }
                    maxHeap.offer(current);
                } else {
                    return "NO SOLUTION";
                }
            }
        }
        return result.toString();
    }
}