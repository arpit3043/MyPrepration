package DataStructuresAlgorithm.Tree;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class levelOrderTraversal {
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
        System.out.println("Level-order Traversal: " + levelOrderTraversal(root));
    }

    private static List<Integer> levelOrderTraversal(TreeNode root) {
        // DLR: Traverse root and save left and right nodes in queue, FIFO, whatever goes in comes out first.
        // BFS: Traverse the root, then traverse the left and right subtrees.
        // DFS: Traverse the left subtree, then traverse the right subtree.
        // Pre-order, In-order, post-order are all DFS.
        // Level-order is BFS.
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();

        if (root == null) {
            return result;
        }
        queue.add(root);
        queue.add(null); // Add a null marker to indicate the end of the current level
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode == null) {
                System.out.println();
                // End of the current level
                if (!queue.isEmpty()) {
                    queue.offer(null); // Add a null marker for the next level
                } else {
                    break; // No more nodes to process
                }
            } else {
                result.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
}