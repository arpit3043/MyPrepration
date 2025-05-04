package BinarySearchTree;

public class PrintInRange {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int low = 6;
        int high = 10;
        System.out.println("Nodes in range [" + low + ", " + high + "]:");
        printInRange(root, low, high);
    }

    private static void printInRange(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        // case 1: low <= root and root <= high: -> go to left and right
        if(root.data >= low && root.data <= high) {
            printInRange(root.left, low, high);
            System.out.print(root.data + " ");
            printInRange(root.right, low, high);
        }

        // case 2: low > root: -> go to right
        
        // case 3: high <= root: -> go to left
        else if(root.data >= high) {
            printInRange(root.left, low, high);
        }
        
        // case 4: root is in range: -> go to left and right
        // case 5: root is less than low: -> go to right
        else if (root.data < low) {
            printInRange(root.right, low, high);
        }
        
        // case 6: root is greater than high: -> go to left
        // case 7: root is equal to low: -> go to left and right
        // case 8: root is equal to high: -> go to left and right
        else {
            printInRange(root.right, low, high);
        }
    }
}
