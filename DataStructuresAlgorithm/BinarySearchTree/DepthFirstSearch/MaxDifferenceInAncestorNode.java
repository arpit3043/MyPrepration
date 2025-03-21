package BinarySearchTree.DepthFirstSearch;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxDifferenceInAncestorNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8,
                new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))),
                new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
        int result = maxAncestorDiff(root);
        System.out.println("Maximum Ancestor Difference: " + result);
    }
    private static int maxAncestorDiff(TreeNode root) {
        int[] m = {0};
        dfs(root, m);
        return m[0];
    }
    private static int[] dfs(TreeNode root, int[] m) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = dfs(root.left, m);
        int[] right = dfs(root.right, m);
        int minVal = Math.min(root.val, Math.min(left[0], right[0]));
        int maxVal = Math.max(root.val, Math.max(left[1], right[1]));
        m[0] = Math.max(m[0], Math.max(Math.abs(minVal - root.val), Math.abs(maxVal - root.val)));
        return new int[]{minVal, maxVal};
    }
}