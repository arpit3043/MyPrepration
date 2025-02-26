package Stacks;
import java.util.Stack;
import java.lang.Integer;
import java.lang.String;
public class PassingGame {
    public static void main(String[] args) {
        int A = 10;
        int B = 23;
        int[] C = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};
        System.out.println(passingFootBallGame(A,B,C));
    }

    private static int passingFootBallGame(int A, int B, int[] C) {
        Stack<Integer>stack = new Stack<>();
        stack.push(B);
        int i=0;
        if(C.length==1 && A==1) {
            return C[0];
        }
        while(i<A) {
            if(C[i]==0) {
                stack.pop();
            } else {
                stack.push(C[i]);
            }
            i++;
        }
        return stack.peek();
    }
}