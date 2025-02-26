package BinarySearchTree.DepthFirstSearch;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
public class DiagonalSum {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8);
        root.left = new BinaryTreeNode<>(3);
        root.right = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(1);
        root.left.right = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(14);
        root.right.right.left = new BinaryTreeNode<>(13);
        root.left.right.left = new BinaryTreeNode<>(4);
        root.left.right.right = new BinaryTreeNode<>(7);
        System.out.println("Diagonal Sums: " + diagonalSum(root));
    }

    private static ArrayList<Long>diagonalSum(BinaryTreeNode<Integer>root) {
        ArrayList<Long> ans = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>>queue = new LinkedList<>();
        long sum=0;
        long count=0;
        long last=0;
        while(root != null){
            if(root.left != null){
                queue.offer(root.left);
                count++;
            }
            sum = sum + root.data;
            root = root.right;
            if(root == null){
                if(!queue.isEmpty()){
                    root = queue.poll();
                }
                if(last == 0){
                    ans.add(sum);
                    sum = 0;
                    last = count;
                    count = 0;
                }
                --last;
            }
        }
        return ans;
    }
}