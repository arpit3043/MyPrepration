package BinarySearchTree;
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
public class MaximumElementInPath {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(5);
        root.right = new BinaryTreeNode<>(15);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(7);
        root.right.left = new BinaryTreeNode<>(12);
        root.right.right = new BinaryTreeNode<>(20);
        int node1 = 7;
        int node2 = 20;
        int result = findMaxElement(root, node1, node2);
        if (result != -1) {
            System.out.println("Maximum element between " + node1 + " and " + node2 + ": " + result);
        } else {
            System.out.println("One or both nodes not found in the tree.");
        }
    }

    private static int findMaxElement(BinaryTreeNode<Integer> root, int node1, int node2) {
        int maxElement = -1;
        if (!searchElement(root, node1) || !searchElement(root, node2)) {
            return -1;
        }
        BinaryTreeNode<Integer> LCA = findLCA(root, node1, node2);
        BinaryTreeNode<Integer> temp = LCA;
        while (temp.data != node1) {
            if (temp.data != node2) {
                maxElement = Math.max(maxElement, temp.data);
            }
            if (temp.data < node1) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        temp = LCA;
        while (temp.data != node2) {
            if (temp.data != node1) {
                maxElement = Math.max(maxElement, temp.data);
            }
            if (temp.data < node2) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return maxElement;
    }

    private static boolean searchElement(BinaryTreeNode<Integer> root, int val) {
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        } else if (root.data < val) {
            return searchElement(root.right, val);
        }
        return searchElement(root.left, val);
    }

    private static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> root, int node1, int node2) {
        if (root == null) {
            return null;
        }
        if (root.data == node1 || root.data == node2) {
            return root;
        }
        if (root.data > node1 && root.data > node2) {
            return findLCA(root.left, node1, node2);
        }
        if (root.data < node1 && root.data < node2) {
            return findLCA(root.right, node1, node2);
        }
        return root;
    }
}
