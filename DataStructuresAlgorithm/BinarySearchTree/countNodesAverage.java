package BinarySearchTree;
public class countNodesAverage {
    private int count;
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws Exception {
        countNodesAverage solution = new countNodesAverage();
        countNodesAverage.TreeNode root = solution.new TreeNode(4);
        root.left = solution.new TreeNode(8);
        root.right = solution.new TreeNode(5);
        root.left.left = solution.new TreeNode(0);
        root.left.right = solution.new TreeNode(1);
        root.right.right = solution.new TreeNode(6);
        int result = solution.averageOfSubtree(root);
        System.out.println("Output: " + result);
    }
    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        preOrder(root);
        return count;
    }
    private int[] preOrder(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = preOrder(root.left);
        int[] right = preOrder(root.right);
        int sum = left[0] + right[0] + root.val;
        int n = left[1] + right[1] + 1;
        int total = sum / n;
        if (total == root.val) {
            count++;
        }
        return new int[]{sum, n};
    }
}