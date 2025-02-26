package BinarySearchTree.BreathFirstSearch;
import java.util.*;
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class LeftSumBST {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);
        long result = leftSum(root);
        System.out.println("Left sum: " + result);
    }
    private static long leftSum(BinaryTreeNode<Integer> root) {
        long sum = 0;
        if (root == null) {
            return sum;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            long size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> front = queue.poll();
                assert front != null;
                if (front.left != null) {
                    sum += front.left.data;
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }
            }
        }
        return sum;
    }
}
