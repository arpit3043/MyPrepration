package BinarySearchTree.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class RightViewOfTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> result = rightSideViewDfs(root);
        System.out.println(result);
    }

    private static List<Integer> rightSideViewDfs(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, 0, ans);
        return ans;
    }

    private static void preOrder(TreeNode root, int level, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if(ans.size() == level) {
            ans.add(root.val);
        }
        preOrder(root.right, level + 1, ans);
        preOrder(root.left, level + 1, ans);
    }
}
