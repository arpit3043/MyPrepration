package DataStructuresAlgorithm.Tree;

public class SumOfNodes {
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
        System.out.println("Sum of all nodes in the tree: " + sumOfNodes(root)); // Output: 28
    }

    private static int sumOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = sumOfNodes(root.left); // Sum of left subtree
        int rightSum = sumOfNodes(root.right); // Sum of right subtree
        return root.val + leftSum + rightSum; // Sum of current node + left subtree + right subtree
    }
}