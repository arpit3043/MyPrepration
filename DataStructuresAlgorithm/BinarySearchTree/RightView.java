package BinarySearchTree;
import java.util.*;

public class RightView {
    private static class TreeNode1 {
        int val;
        TreeNode1 left;
        TreeNode1 right;
        TreeNode1(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception {
        /*
            Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
        TreeNode1 root = new TreeNode1(1);
        root.left = new TreeNode1(2);
        root.right = new TreeNode1(3);
        root.left.left = new TreeNode1(4);
        root.right.left = new TreeNode1(5);
        root.right.right = new TreeNode1(6);
        root.right.left.left = new TreeNode1(7);
        root.right.left.right = new TreeNode1(8);
        System.out.println(rightSideView(root));
    }
    private static List<Integer> rightSideView(TreeNode1 root) {
        List<Integer> ans = new ArrayList<>();
        levelOrderTraversal(root, ans);
        return ans;
    }

    private static void levelOrderTraversal(TreeNode1 root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode1 curr = queue.poll();
                if (i == size - 1) {
                    ans.add(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
    }
}