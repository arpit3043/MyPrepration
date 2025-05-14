package BinarySearchTree;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    static class TreeNode1 {
        int val;
        TreeNode1 left;
        TreeNode1 right;
        TreeNode1() {}
        TreeNode1(int val) {
            this.val = val;
        }
        TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String[] args) {
        TreeNode1 p = new TreeNode1(1);
        p.left = new TreeNode1(2);
        p.right = new TreeNode1(3);
        TreeNode1 q = new TreeNode1(1);
        q.left = new TreeNode1(2);
        q.right = new TreeNode1(3);
        boolean result = SameTree.isSameTree(p, q);
        System.out.println("Are the trees the same? " + result);
        System.out.println("Are the trees the same? " + SameTree.isSameTreeRecursive(p, q));
    }

    private static boolean isSameTreeRecursive(TreeNode1 p, TreeNode1 q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
        }
        return false;
    }

    private static boolean isSameTree(TreeNode1 p, TreeNode1 q) {
        Queue<TreeNode1> queue1 = new LinkedList<>();
        Queue<TreeNode1> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode1 node1 = queue1.poll();
            TreeNode1 node2 = queue2.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue1.offer(node1.left);
            queue1.offer(node1.right);
            queue2.offer(node2.left);
            queue2.offer(node2.right);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}