package BinarySearchTree.BreathFirstSearch;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.String;
import java.lang.Integer;
public class LevelOrderTraversalLevelByLevel {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        levelOrderTraversal(root);
    }
    private static void preOrder(TreeNode root, int level, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.val);
        preOrder(root.left, level + 1, map);
        preOrder(root.right, level + 1, map);
    }
    private static void levelOrderTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        preOrder(root, 1, map);
        for (int i = 1; i <= map.size(); i++) {
            System.out.println("Level " + i + ": " + map.get(i));
        }
    }
}