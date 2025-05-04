package DataStructuresAlgorithm.BinarySearchTree;
public class SearchNodeBST {
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
        System.out.println("Searching Node=4 in BST: " + searchNodeInBST(root, 4)); // true
    }

    // Searching a node works in O(h) time complexity where h is the height of the tree.
    // In the case of a balanced BST, the time complexity is O(log n) where n is the number of nodes in the tree.
    private static boolean searchNodeInBST(TreeNode root, int x) {
        if(root == null) {
            return false;
        }

        while(root!=null) {
            if(root.data==x){
                return true;
            } else if(root.data<x){
                root=root.right;
            } else {
                root=root.left;
            }
        }
        return false;
    }
}