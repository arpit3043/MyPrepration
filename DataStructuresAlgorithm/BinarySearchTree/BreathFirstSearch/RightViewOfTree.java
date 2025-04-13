package BinarySearchTree.BreathFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

// Given the root of a binary tree, return the values of the nodes you can see ordered from top to bottom when looking from the right side.
public class RightViewOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> result = rightSideView(root);
        System.out.println(result);
    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        Queue<TreeNode>queue = new LinkedList<>();

        if(root == null) {
            return ans;
        }
        queue.add(root);

        while(!queue.isEmpty()) {
            int n = queue.size();
            TreeNode node = null;

            for(int i=0; i<n; i++) {
                node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            
            if (node != null) {
                ans.add(node.val);
            }
        }
        return ans;
    }
}
