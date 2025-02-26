package Stacks;
import java.util.Stack;
import java.lang.Character;
public class MaxSubString01 {
    public static void main(String[] args) {
        String S = "0111100010";
        System.out.println(maxSubString01(S));
    }
    /**
     * The Time complexity of the code is O(N+N) & Space Complexity is O(N)
     * */
    private static int maxSubString01(String str) {
        int n=str.length();
        int count=0;
        Stack<Character>stack = new Stack();
        for(int i=0; i<n; ++i) {
            if(!stack.isEmpty()) {
                if(stack.peek()!=str.charAt(i)) {
                    stack.pop();
                    if(stack.isEmpty()) {
                        count++;
                    }
                } else {
                    stack.push(str.charAt(i));
                }
            } else {
                stack.push(str.charAt(i));
            }
        }
        if(stack.size()==0) {
            return count;
        }
        return -1;
    }
}