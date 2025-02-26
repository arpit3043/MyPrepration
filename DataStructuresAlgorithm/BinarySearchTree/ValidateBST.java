package BinarySearchTree;
import java.util.Stack;
public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("Is the tree a valid BST? " + (
                (!isValidBST(root)) ? "No" : "Yes")
        );
        System.out.println("Is the tree a valid BST? " + (
                (!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) ? "No" : "Yes")
        );
    }

    // Using Recursion & Recursive Stack
    private static boolean isBST(TreeNode root, int min, int max) {
        if(root==null) {
            return true;
        }
        if(root.val>min && root.val<max) {
            boolean left = isBST(root.left, min, root.val);
            boolean right = isBST(root.right, root.val, max);
            return (left && right);
        }
        return false;
    }
    // Using Stack
    private static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return true;
        }
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}