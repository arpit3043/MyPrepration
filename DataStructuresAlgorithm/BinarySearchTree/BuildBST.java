package DataStructuresAlgorithm.BinarySearchTree;

public class BuildBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for(int i=0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();
    }
    
    private static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if(root.data > data) {
            root.left = insert(root.left, data);
        }
        
        // root.data < data
        else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    private static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
