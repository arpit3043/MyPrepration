package DataStructuresAlgorithm.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
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
        
        System.out.println("Pre-order Traversal using Stack: " + preOrderTraversalStack(root));
        // System.out.println("Pre-order Traversal using Queue: " + preOrderTraversalQueue(root)); // Queue can not be used for pre-order traversal.
        System.out.println("Pre-order Traversal using Recursion: " + preOrderTraversalRecursive(root, new ArrayList<>()));
    }

    public static List<Integer> preOrderTraversalStack(TreeNode root) {
        // DLR: Visit the root, then traverse the left subtree, and finally traverse the right subtree.
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            result.add(currentNode.val);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        return result;
    }

    public static List<Integer> preOrderTraversalRecursive(TreeNode node, List<Integer> result) {
        // DLR: Visit the root, then traverse the left subtree, and finally traverse the right subtree.
        if (node == null) {
            return result;
        }
        result.add(node.val);
        preOrderTraversalRecursive(node.left, result);
        preOrderTraversalRecursive(node.right, result);
        return result;
    }
}
