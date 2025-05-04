package DataStructuresAlgorithm.Tree;

public class SubTreeOfAnotherTree {
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
        TreeNode subTree = new TreeNode(2);
        subTree.left = new TreeNode(4);
        subTree.right = new TreeNode(5);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subTree) {
        if (root == null) {
            return false;
        }

        if (subTree == null) {
            return true;
        }

        if(root.val == subTree.val) {
            if (isSameTree(root, subTree)) {
                return true;
            }
        }
        // Check if the left or right subtree is the same as subTree
        return isSubtree(root.left, subTree) 
        || isSubtree(root.right, subTree);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if(p.val == q.val) {
            return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
        }
        return false;
    }
}
