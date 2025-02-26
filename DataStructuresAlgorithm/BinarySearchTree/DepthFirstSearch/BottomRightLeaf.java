package BinarySearchTree.DepthFirstSearch;
import java.util.LinkedList;
import java.util.Queue;
public class BottomRightLeaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        System.out.println("Right Value of Tree - " + findBottomRightValue(root));
    }

    private static int findBottomRightValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode rightmost = null;
        while (!q.isEmpty()) {
            rightmost = q.poll();
            if (rightmost.left != null) {
                q.offer(rightmost.left);
            }
            if (rightmost.right != null) {
                q.offer(rightmost.right);
            }
        }
        return rightmost.val;
    }
}