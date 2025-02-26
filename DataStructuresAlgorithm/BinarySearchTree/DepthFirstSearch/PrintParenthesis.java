package BinarySearchTree.DepthFirstSearch;
public class PrintParenthesis {
    public static void main(String[] args) {
        int N=4;
        printParentheses(N);
    }
    private static void printParentheses(int n) {
        String s="";
        dfs(n, n, n, s);
    }
    private static void dfs(int oc, int cc, int n, String temp) {
        if(oc == 0 && cc == 0){
            System.out.println(temp);
            return;
        }
        if(oc != 0){
            dfs(oc-1, cc, n, temp+'{');
        }
        if(oc < cc){
            dfs(oc, cc-1, n, temp+'}');
        }
    }
}
