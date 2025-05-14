package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Is the tree balanced: " + isBalanced(root));
        System.out.println("Is the tree balanced: " + isBalancedTreeDFSIterative(root));
        System.out.println("Is the tree balanced: " + isBalancedTreeDFS(root));
    }

    // Iterative Function to check if a binary tree is balanced
    // using DFS with stack
    // Time complexity: O(n) where n is the number of nodes in the tree
    private static boolean isBalancedTreeDFSIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer>depths = new HashMap<>();

        TreeNode node = root;
        TreeNode last = null;

        while(!stack.isEmpty() || node!=null) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if(node.right == null || last == node.right) {
                    stack.pop();

                    if(Math.abs(
                        depths.getOrDefault(node.left, 0) - depths.getOrDefault(node.right, 0)
                        ) > 1) {
                        return false;
                    }
                    depths.put(node, 1+ Math.max(depths.getOrDefault(node.left, 0), depths.getOrDefault(node.right, 0)));
                    last = node;
                    node = null;
                } else {
                    node =  node.right;
                }
            }
        }
        return true;
    }

    // DFS approach to check if the tree is balanced
    // Time complexity: O(n) where n is the number of nodes in the tree
    private static boolean isBalancedTreeDFS(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = (left[0] == 1 && right[0] == 1) && 
                            (Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);

        return new int[]{balanced ? 1 : 0, height};
    }

    // Brute force approach to check if the tree is balanced
    // Time complexity: O(n^2) where n is the number of nodes in the tree
    private static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        if(Math.abs(leftHeight - rightHeight)>1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int heightOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
