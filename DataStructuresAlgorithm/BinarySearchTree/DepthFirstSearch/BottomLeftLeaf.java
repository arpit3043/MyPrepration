package BinarySearchTree.DepthFirstSearch;
import java.util.LinkedList;
import java.util.Queue;
public class BottomLeftLeaf {
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
        System.out.println("Left Value of Tree - " + findBottomLeftValue(root));
    }
    private static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode leftmost = null;
        while (!q.isEmpty()) {
            leftmost = q.poll();
            if (leftmost.right != null) {
                q.offer(leftmost.right);
            }
            if (leftmost.left != null) {
                q.offer(leftmost.left);
            }
        }
        return leftmost.val;
    }
}