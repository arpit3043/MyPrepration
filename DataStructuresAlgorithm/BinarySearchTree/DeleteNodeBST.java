package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DeleteNodeBST {
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
    
        /*
        The tree looks like this:
                5
               /  \
              3    7
             / \  / \
            2  4  6  8
        */
        List<Integer> result = inorderTraversal(root);
        System.out.println("Before deletion: " + result);
        root = deleteNode(root, 5);
        List<Integer> result2 = inorderTraversal(root);
        System.out.println("After deletion: " + result2);
    }

    private static List<Integer>inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.data);
            current = current.right;
        }
        return result;
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        // Base case: If the tree is empty
        if (root == null) {
            return null;
        }

        if (root.data == key && root.left == null && root.right == null) {
            return null;
        }

        
        if (root.data > key) {
            root.left = deleteNode(root.left, key);
        }

        else if (root.data < key) {
            root.right = deleteNode(root.right, key);
        }

        else { // root.data == data
            // Case 1: No Children (leaf node)
            // Go to the leaf node, return null and add null to the parent node
            if(root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One Child (left or right child)
            // Go to the leaf node, return the child node and add it to the parent node
            if (root.left == null) {
                return root.right;
            }
            
            else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two Children
            // Go to the leaf node, find the minimum value in the right subtree, replace the node with the inorder successor value and delete the node from the tree
            // InOrder successor is the left most value in the right subtree
            TreeNode successor = inOrderSuccessor(root.right); // Find the left most value in the right subtree and replace the root with the left most value
            root.data = successor.data; // Replace the root with the left most value
            root.right = deleteNode(root.right, successor.data); // Delete the left most value from the right subtree
        }
        return root;
    }

    private static TreeNode inOrderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
