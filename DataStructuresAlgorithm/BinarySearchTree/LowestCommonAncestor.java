package DataStructuresAlgorithm.BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);

        TreeNode p = root.left.right;
        TreeNode q = root.right.left;
        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val);
        TreeNode lcaIter = lowestCommonAncestorIterations(root, p, q);
        System.out.println("Lowest Common Ancestor Iterations: " + lcaIter.val);
    }

    // Function to find the lowest common ancestor of two nodes in a binary tree - bruteForce
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }

        if(root == p || root == q) {
            return root;
        }

        if(root.val == p.val || root.val == q.val) {
            return root;
        }
   
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
           
        if(leftLCA!=null && rightLCA!=null){
            return root;
        }
   
        if(leftLCA == null) {
            return rightLCA;
        }
        return leftLCA;
    }

    // Function to find the lowest common ancestor of two nodes in a binary search tree - iterations
    // Time complexity: O(h) where h is the height of the tree, O(log n) where n is the number of nodes in the tree
    private static TreeNode lowestCommonAncestorIterations(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }
}
