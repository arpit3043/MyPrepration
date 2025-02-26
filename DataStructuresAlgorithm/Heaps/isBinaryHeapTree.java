package Heaps;
public class isBinaryHeapTree {
    static int count;
    class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        isBinaryHeapTree isHeapTree = new isBinaryHeapTree();
        BinaryTreeNode root = isHeapTree.createBinaryTree();
        System.out.println(isBinaryHeapTree(root));
    }

    private BinaryTreeNode createBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(9);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(5);
        root.left.left.left = new BinaryTreeNode(1);
        root.left.left.right = new BinaryTreeNode(2);
        return root;
    }

    private static String isBinaryHeapTree(BinaryTreeNode root) {
        count=0;
        countNodes(root);
        int index=0;
        if(isCBT(root,index) && isMaxHeap(root)) {
            return "True";
        }
        return "False";
    }

    static boolean isMaxHeap(BinaryTreeNode root) {
        if(root.left==null && root.right==null){
            return true;
        }
        if(root.right==null) {
            return (root.data > root.left.data);
        } else {
            boolean left=isMaxHeap(root.left);
            boolean right=isMaxHeap(root.right);
            if(left && right && root.data >= root.right.data && root.data >= root.left.data){
                return true;
            }
            return false;
        }
    }

    private static boolean isCBT(BinaryTreeNode root,int index){
        if(root==null) {
            return true;
        }
        if(index>=count) {
            return false;
        }
        return isCBT(root.left,2*index+1) && isCBT(root.right,2*index+2);
    }

    private static void countNodes(BinaryTreeNode root) {
        if(root==null){
            return;
        }
        countNodes(root.left);
        count++;
        countNodes(root.right);
    }
}