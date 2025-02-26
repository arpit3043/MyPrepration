package Tree;
public class SearchNodeBST {
    private class Node {
        int data;
        Node left;
        Node right;
        private Node(int item) {
            data = item;
            left = right = null;
        }
    }
    public static void main(String[] args) throws Exception {
        SearchNodeBST tree = new SearchNodeBST();
        Node root = tree.new Node(2);
        root.right = tree.new Node(81);
        root.right.left = tree.new Node(42);
        root.right.right = tree.new Node(87);
        root.right.right.right = tree.new Node(90);
        root.right.left.right = tree.new Node(66);
        root.right.left.right.left = tree.new Node(45);
        int x = 87;
        boolean result = searchNodeInBST(root, x);
        if (result) {
            System.out.println("Node " + x + " found in the BST.");
        } else {
            System.out.println("Node " + x + " not found in the BST.");
        }
    }
    private static boolean searchNodeInBST(Node root, int x) {
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