package String;
import java.util.Stack;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Integer;
public class DecodeString {
    public static void main(String[] args) throws Exception {
        String str = "3[a]2[bc]";
        System.out.println(decodeString(str));
    }
    private static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (isDigit(c)) {
                k = (k * 10) + (c - '0');
                continue;
            }
            if (c == '[') {
                numStack.push(k);
                k = 0;
                stringStack.push(String.valueOf(c));
                continue;
            }
            if (c != ']') {
                stringStack.push(String.valueOf(c));
                continue;
            }
            StringBuilder temp = new StringBuilder();
            while (!stringStack.peek().equals("[")){
                temp.insert(0, stringStack.pop());
            }
            stringStack.pop();
            StringBuilder replacement = new StringBuilder();
            int count = numStack.pop();
            for (int i = 0; i < count; i++) {
                replacement.append(temp);
            }
            stringStack.push(replacement.toString());
        }
        while (!stringStack.empty()) {
            result.insert(0, stringStack.pop());
        }
        return result.toString();
    }
    private static boolean isDigit(char c) {
        if(c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}