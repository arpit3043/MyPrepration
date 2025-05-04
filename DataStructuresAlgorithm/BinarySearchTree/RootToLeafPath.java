package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(11);
        root.right.right.right = new TreeNode(14);

        System.out.println("Root to Leaf Paths:");
        printRootToLeafPaths(root, "");
        System.out.println("Root to Leaf Paths with List:");
        printRootToLeafPathsWithList(root, new ArrayList<>());
    }

    // Kind of pre-order traversal
    // Print all paths from root to leaf nodes
    /*
     * Steps:
     * Root(add)
     * Left Subtree
     * Right Subtree
     * Remove the root from the path
    */
    private static void printRootToLeafPaths(TreeNode root, String path) {
        if (root == null) {
            return;
        }

        path += root.data + " ";

        // If it's a leaf node, print the path
        if (root.left == null && root.right == null) {
            System.out.println(path.trim());
        } else {
            // Recur for left and right subtrees
            printRootToLeafPaths(root.left, path);
            printRootToLeafPaths(root.right, path);
        }
    }

    // Method with ArrayList instead of String
    private static void printRootToLeafPathsWithList(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        // If it's a leaf node, print the path
        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            // Recur for left and right subtrees
            printRootToLeafPathsWithList(root.left, path);
            printRootToLeafPathsWithList(root.right, path);
        }

        // Backtrack to remove the current node from the path
        path.remove(path.size() - 1);
    }
}
