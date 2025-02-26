package BinarySearchTree.BreathFirstSearch;
class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class IsSubTreeOrNot {
    public static void main(String[] args) {
        TreeNode2 T = new TreeNode2(3);
        T.left = new TreeNode2(4);
        T.right = new TreeNode2(5);
        T.left.left = new TreeNode2(1);
        T.left.right = new TreeNode2(2);
        TreeNode2 S = new TreeNode2(4);
        S.left = new TreeNode2(1);
        S.right = new TreeNode2(2);
        boolean result = isSubtree(T, S);
        System.out.println("Is S a subtree of T? " + result);
    }

    private static boolean isSubtree(TreeNode2 T, TreeNode2 S) {
        return checkSubtree(T, S);
    }

    private static boolean match(TreeNode2 root, TreeNode2 subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        if (root != null && subroot == null) {
            return false;
        }
        if (subroot != null && root == null) {
            return false;
        }
        if (root.val != subroot.val) {
            return false;
        }
        return match(root.left, subroot.left) && match(root.right, subroot.right);
    }
    private static boolean checkSubtree(TreeNode2 root, TreeNode2 subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        if (root == null || subroot == null) {
            return false;
        }
        if (root.val == subroot.val) {
            if (match(root, subroot)) {
                return true;
            }
        }
        boolean left = checkSubtree(root.left, subroot);
        boolean right = checkSubtree(root.right, subroot);
        return left || right;
    }
}