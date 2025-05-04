package DataStructuresAlgorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfNodesAtKthLevel {
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
        int k = 2; // Level to sum
        System.out.println("Sum of nodes at level " + k + ": " + sumOfNodesAtKthLevelRecursive(root, k)); // Output: 22
        System.out.println("Sum of nodes at level " + k + ": " + sumOfNodesAtKthLevelIterative(root, k)); // Output: 22
    }

    private static int sumOfNodesAtKthLevelRecursive(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 0) {
            return root.val; // Return the value of the node at level k
        }
        // Sum of left and right subtrees at level k-1
        return sumOfNodesAtKthLevelRecursive(root.left, k - 1) + sumOfNodesAtKthLevelRecursive(root.right, k - 1);
    }

    private static int sumOfNodesAtKthLevelIterative(TreeNode root, int k) {
        if (root == null || k < 0) {
            return 0;
        }
        int sum = 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val; // Sum the values at level k
                }
                break; // No need to go deeper
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return sum;
    }
}