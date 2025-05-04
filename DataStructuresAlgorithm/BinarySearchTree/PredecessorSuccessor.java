package DataStructuresAlgorithm.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class PredecessorSuccessor {
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

        int key = 5;
        predecessorSuccessor(root, key);
    }

    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        List<Integer>ans = new ArrayList<>();

        Integer predecessor = -1;
        Integer successor = -1;

        TreeNode current = root;
        while(current!=null) {
            if(current.data == key) {
                if(current.left != null) {
                    predecessor = predecessor(current.left);
                }
                if(current.right != null) {
                    successor = successor(current.right);
                }
                break;
            } else if(current.data > key) {
                successor = current.data;
                current = current.left;
            } else if( current.data < key) {
                predecessor = current.data;
                current = current.right;
            }
        }
        ans.add(predecessor);
        ans.add(successor);
        return ans;
    }

    private static int predecessor(TreeNode root) {
        if(root ==  null) {
            return -1;
        }

        while(root.right!=null) {
            root = root.right;
        }
        return root.data;
    }

    private static int successor(TreeNode root) {
        if(root ==  null) {
            return -1;
        }

        while(root.left!=null) {
            root = root.left;
        }
        return root.data;
    }
}