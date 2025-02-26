package BinarySearchTree.BreathFirstSearch;
import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 2;
        int result = KthSmallestElementInBST.kthSmallestElementInBST(root, k);
        System.out.println("The " + k + "th smallest element in the BST is: " + result);
    }

    private static int kthSmallestElementInBST(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>() ;
        TreeNode currentNode = root;
        int m = 0;
        while (true) {
            if(currentNode == null) {
                currentNode = s.pop();
                m++;
                if(m == k) {
                    return currentNode.val;
                }
                currentNode = currentNode.right;
            } else {
                s.push(currentNode);
                currentNode = currentNode.left;
            }
        }
    }
}