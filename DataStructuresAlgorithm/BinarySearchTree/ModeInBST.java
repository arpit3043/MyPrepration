package BinarySearchTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ModeInBST {
    private int currentVal;
    private int currentCount;
    private int maxCount;
    private List<Integer> modes;

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        ModeInBST modeInBST = new ModeInBST();
        int[] modes = modeInBST.findMode(root);
        System.out.println("The mode(s) in the BST are:");
        System.out.println(Arrays.toString(modes));
    }

    public int[] findMode(TreeNode root) {
        currentVal = 0;
        currentCount = 0;
        maxCount = 0;
        modes = new ArrayList<>();
        inOrderTraversal(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (node.val == currentVal) {
            currentCount++;
        } else {
            currentCount = 1;
        }
        if (currentCount == maxCount) {
            modes.add(node.val);
        } else if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        }
        currentVal = node.val;
        inOrderTraversal(node.right);
    }
}