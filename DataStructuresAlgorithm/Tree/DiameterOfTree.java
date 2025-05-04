package DataStructuresAlgorithm.Tree;

public class DiameterOfTree {
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

    static class TreeInfo {
        int height;
        int diameter;
        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
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
        System.out.println("Diameter of the tree Via Root: " + diameterOfTreeViaRoot(root)); // Output: 4
        System.out.println("Diameter of the tree Root: " + diameterOfTreeRoot(root).diameter); // Output: 4
    }

    // Diameter of a tree is the Number of nodes in the longest path between any two nodes in a tree.
    // there might be two cases: 1. the longest path goes through the root, 2. the longest path does not go through the root.
    // The longest path through the root is the sum of the heights of the left and right subtrees + 1 (for the root node).
    // The longest path not through the root is the maximum of the longest paths in the left and right subtrees.
    // The diameter of the tree is the maximum of these two values.
    private static int diameterOfTreeViaRoot(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1; // +1 for the root node
    }

    private static TreeInfo diameterOfTreeRoot(TreeNode root) {
        if(root == null) {
            return new TreeInfo(0, 0); // height and diameter are both 0 for null node
        }
        TreeInfo left = diameterOfTreeRoot(root.left);
        TreeInfo right = diameterOfTreeRoot(root.right);
        int myHeight = Math.max(left.height, right.height) + 1; // height of the current node is max of left and right subtree + 1 for the root node

        int diameter1 = left.diameter; // diameter of the left subtree
        int diameter2 = right.diameter; // diameter of the right subtree
        int diameter3 = left.height + right.height + 1; // diameter of the current node is the sum of the heights of the left and right subtrees + 1 for the root node
        int myDiameter = Math.max(diameter1, Math.max(diameter2, diameter3)); // diameter of the current node is the max of the three diameters

        return new TreeInfo(myHeight, myDiameter);
    }

    private static int heightOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1; // +1 for the root node
    }
}