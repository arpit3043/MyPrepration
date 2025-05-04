package DataStructuresAlgorithm.BinarySearchTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class ValidateBST {
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
        System.out.println("Is the tree a BST? " + isBST(root)); // false
        System.out.println("Is the tree a BST? " + isBSTIterative(root));
        System.out.println("Is the tree a BST? " + isBSTRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        // The above tree is a BST because for every node, the left child is less than the node and the right child is greater than the node.
        // The above tree is not a BST because 2 is not less than 1 and 3 is not greater than 1.
    }

    // Using Inorder Traversal
    // Inorder traversal of a BST gives sorted order of elements.
    private static boolean isBST(TreeNode root) {
        // your code goes here
        List<Integer>inOrder = inOrderTraversal(root);

        for(int i=1; i<inOrder.size(); ++i) {
            if(inOrder.get(i-1) >= inOrder.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer>inOrderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        Stack<TreeNode>stack = new Stack<>();
        
        if(root == null) {
            return result;
        }

        TreeNode currentNode = root;
        while(currentNode!=null || !stack.isEmpty()) {
            while(currentNode!=null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }

    // Using Recursion & Recursive Stack
    private static boolean isBSTRecursive(TreeNode root, int min, int max) {
        if(root==null) {
            return true;
        }
        if(root.val>min && root.val<max) {
            boolean left = isBSTRecursive(root.left, min, root.val);
            boolean right = isBSTRecursive(root.right, root.val, max);
            return (left && right);
        }
        return false;
    }
    // Using Stack
    private static boolean isBSTIterative(TreeNode root) {
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
}