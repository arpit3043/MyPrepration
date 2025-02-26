package Stacks;
public class MaxNextDepth {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepthInStr(s));
    }
    private static int maxDepthInStr(String s) {
        int curDepth = 0;
        int maxDepth = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                curDepth++;
                if(maxDepth < curDepth) {
                    maxDepth = curDepth;
                }
            }
            else if(ch == ')') {
                curDepth--;
            }
        }
        return maxDepth;
    }
}