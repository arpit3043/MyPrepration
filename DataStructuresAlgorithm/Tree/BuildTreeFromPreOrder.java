package DataStructuresAlgorithm.Tree;

public class BuildTreeFromPreOrder {
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
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode root = BinaryTree.buildTree(nodes);
        System.out.println("Root: " + root.val);
        System.out.println("Left Child of Root: " + root.left.val);
        System.out.println("Right Child of Root: " + root.right.val);
    }

    static class BinaryTree {
        static int idx=-1;
        public static TreeNode buildTree(int[] nodes) {
            ++idx;
            if(nodes[idx] == -1) {
                return null;
            }

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
}