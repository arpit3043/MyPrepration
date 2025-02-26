package Stacks;
import java.util.Stack;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Character;
public class CompareStrings {
    public static void main(String[] args) throws Exception {
        String s = "ab##";
        String t = "c#d#";
        System.out.println(backspaceCompare(s,t));
    }
    private static boolean backspaceCompare(String s, String t) {
        int N=s.length();
        int M=t.length();
        String res1 = "";
        StringBuilder res2 = new StringBuilder();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '#'){
                if(!s1.isEmpty())
                    s1.pop();
                continue;
            }
            s1.push(ch);
        }
        for(char ch : t.toCharArray()){
            if(ch == '#'){
                if(!s2.isEmpty())
                    s2.pop();
                continue;
            }
            s2.push(ch);
        }
        while(!s1.isEmpty()) {
            res1 = res1+s1.pop();
        }
        while(!s2.isEmpty()) {
            res2.append(s2.pop());
        }
        return res1.contentEquals(res2);
    }
}