package BinarySearchTree;
class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int x) {
        val = x;
    }
}
public class DiameterOfBST { 
    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(1);
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(3);
        root.left.left = new TreeNode2(4);
        root.left.right = new TreeNode2(5);
        root.right.right = new TreeNode2(6);
        root.right.right.left = new TreeNode2(7);
        root.right.right.right = new TreeNode2(8);
        int diameter = diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree is: " + diameter);
    }
    private static int diameterOfBinaryTree(TreeNode2 root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = heightOfBST(root.left);
        int rightHeight = heightOfBST(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }
    private static int heightOfBST(TreeNode2 root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfBST(root.left), heightOfBST(root.right));
    }
}