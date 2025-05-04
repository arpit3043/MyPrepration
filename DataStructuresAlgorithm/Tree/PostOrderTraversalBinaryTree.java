package DataStructuresAlgorithm.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        /*
                          1
                    |           |
                    2           3
                  |     |     |   |
                  4     5     6   7
        */
        System.out.println("Post-order Traversal using Recursion: " + postOrderTraversalRecursive(root, new ArrayList<>()));
        System.out.println("Post-order Traversal using Stack: " + postOrderTraversalStack(root));
    }

    private static List<Integer> postOrderTraversalRecursive(TreeNode root, List<Integer> result) {
        // LRD: Traverse the left subtree, traverse the right subtree, and finally visit the root.
        if (root == null) {
            return result;
        }
        postOrderTraversalRecursive(root.left, result);
        postOrderTraversalRecursive(root.right, result);
        result.add(root.val);
        return result;
    }

    private static List<Integer> postOrderTraversalStack(TreeNode root) {
        // LRD: Traverse the left subtree, traverse the right subtree, and finally visit the root.
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            result.add(0, currentNode.val); // Add to the beginning of the list to reverse the order
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
        return result;
    }
}