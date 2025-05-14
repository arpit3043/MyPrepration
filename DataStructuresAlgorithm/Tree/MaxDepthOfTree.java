package DataStructuresAlgorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthOfTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Max depth of the tree: " + maxDepthLevelOrderTraversal(root));
        System.out.println("Max depth of the tree: " + maxDepthRecursive(root));
        System.out.println("Max depth of the tree: " + maxDepthDFSwithStack(root));
    }

    // Function to find the maximum depth of a binary tree
    // using level order traversal
    private static int maxDepthLevelOrderTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

    // Function to find the maximum depth of a binary tree
    // using recursion and its DFS as well
    private static int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right)) + 1;
    }

    // Function to find the maximum depth of a binary tree
    // using depth-first search (DFS) with stack
    private static int maxDepthDFSwithStack(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int res = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int depth = current.getValue();

            if (node != null) {
                res = Math.max(res, depth);
                stack.push(new Pair<>(node.left, depth + 1));
                stack.push(new Pair<>(node.right, depth + 1));
            }
        }
        return res;
    }
}
