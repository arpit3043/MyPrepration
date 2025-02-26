package String;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacter {
    final static int MAX_CHAR = 26;
    public static void main(String[] args) throws Exception {
        String str = "aabc";
        System.out.println(firstUniqCharacter(str));
    }
    private static int firstUniqCharacter(String s) {
        char[] S = s.toCharArray();
        int[] freq = new int[26];
        int index = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            index = S[i]-'a';
            freq[index] += 1;
        }
        for(int i=0; i<n; i++) {
            index = S[i]-'a';
            if(freq[index] == 1) {
                return i;
            }
        }
        return -1;
    }
    private static int firstNonRepeatingCharacter(String s) {
        int N=s.length();
        Queue<Character> queue = new LinkedList<>();
        int[] temp = new int [26];
        for(int i=0; i<N; i++) {
            char ch=s.charAt(i);
            queue.add(ch);
            temp[ch-'a']++;
            while(!queue.isEmpty() && temp[queue.peek()-'a']>1) {
                queue.poll();
            }
        }
        if(queue.isEmpty()) {
            return -1;
        }
        return s.indexOf(queue.peek());
    }
}
