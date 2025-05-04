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

        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();
        TreeNode p = root.left.right;
        TreeNode q = root.right.left;
        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lca.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }
        
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
   
        TreeNode leftLCA = lowestCommonAncestor(root.left, i, j);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
           
        if(leftLCA!=null && rightLCA!=null){
            return root;
        }
   
        if(leftLCA == null) {
            return rightLCA;
        }
        return leftLCA;
    }
}