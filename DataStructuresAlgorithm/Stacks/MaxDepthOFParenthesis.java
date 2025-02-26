package Stacks;
public class MaxDepthOFParenthesis {
    public static void main(String[] args) {
        String s="(3*(4*(5*(6))))";
        System.out.println(maximumDepthOfParenthesis(s));
    }
    private static int maximumDepthOfParenthesis(String s) {
        int p=0;
        int open=0;
        int depth=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                open++;
            else if(s.charAt(i)==')'){
                depth=Math.max(depth, open);
                open--;
            }
        }
        return depth;
    }
}
