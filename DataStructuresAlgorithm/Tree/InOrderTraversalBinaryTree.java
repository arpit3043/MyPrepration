package DataStructuresAlgorithm.Tree;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class InOrderTraversalBinaryTree {
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
                 |      |     |   |
                 4      5     6   7
        */
        System.out.println("In-order Traversal using Recursion: " + inOrderTraversalRecursive(root, new ArrayList<>()));
        System.out.println("In-order Traversal using Stack: " + inOrderTraversalStack(root));
        // System.out.println("In-order Traversal using Queue: " + inOrderTraversalQueue(root)); // Queue can not be used for in-order traversal.
        // Note: Queue is not typically used for in-order traversal, but it can be used to store nodes in a level-order fashion.
        // Queue will always give me the sorted answer of a binary tree
    }

    private static List<Integer> inOrderTraversalRecursive(TreeNode root, List<Integer> result) {
        // LDR: Traverse the left subtree, visit the root, and finally traverse the right subtree.
        if (root == null) {
            return result;
        }
        inOrderTraversalRecursive(root.left, result);
        result.add(root.val);
        inOrderTraversalRecursive(root.right, result);
        return result;
    }

    private static List<Integer> inOrderTraversalStack(TreeNode root) {
        // LDR: Traverse the left subtree, visit the root, and finally traverse the right subtree.
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }
}
