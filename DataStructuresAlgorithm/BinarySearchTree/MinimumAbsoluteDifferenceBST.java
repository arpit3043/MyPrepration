package BinarySearchTree;
public class MinimumAbsoluteDifferenceBST {
    public static void main(String[] args) throws Exception {
        try {
            MinimumAbsoluteDifferenceBST solution = new MinimumAbsoluteDifferenceBST();
            TreeNode root = solution.new TreeNode(1);
            root.left = solution.new TreeNode(0);
            root.right = solution.new TreeNode(48);
            root.right.left = solution.new TreeNode(12);
            root.right.right = solution.new TreeNode(49);
            // Calculate the minimum absolute difference
            int minDiff = solution.getMinimumDifference(root);
            // Print the result
            System.out.println("Minimum Absolute Difference: " + minDiff);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private Integer prev;
    private int minDiff;

    private int getMinimumDifference(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        inorderTraversal(node.right);
    }
}