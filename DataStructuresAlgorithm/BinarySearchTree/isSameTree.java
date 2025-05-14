package BinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To determine whether the three traversals (A = preorder, B = inorder, C = postorder) belong to the same binary tree, 
 * you can:
 * 1. Reconstruct the binary tree using preorder (A) and inorder (B).
 * 2. Generate the postorder traversal from the constructed tree.
 * 3. Compare the generated postorder with the given array C.
*/
public class isSameTree {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 4, 5, 3, 6, 7}; // preorder
        int[] B = {4, 2, 5, 1, 6, 3, 7}; // inorder
        int[] C = {4, 5, 2, 6, 7, 3, 1}; // postorder

        System.out.println(checkTreeTraversal(A, B, C));
    }

    private static int checkTreeTraversal(int[] preorder, int[] inorder, int[] postorder) {
        if (preorder.length != inorder.length || inorder.length != postorder.length) {
            return 0;
        }

        // Build tree from preorder and inorder
        TreeNode root = buildTree(preorder, inorder);

        // Generate postorder from the built tree
        List<Integer> postList = new ArrayList<>();
        generatePostorder(root, postList);

        // Compare generated postorder with given postorder
        for (int i = 0; i < postorder.length; i++) {
            if (postList.get(i) != postorder[i]) return 0;
        }
        return 1;
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode build(int[] pre, int preStart, int preEnd, 
                                int[] in, int inStart, int inEnd, 
                                Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(pre, preStart + 1, preStart + numsLeft, in, inStart, inRoot - 1, inMap);
        root.right = build(pre, preStart + numsLeft + 1, preEnd, in, inRoot + 1, inEnd, inMap);

        return root;
    }

    private static void generatePostorder(TreeNode node, List<Integer> postList) {
        if (node == null) {
            return;
        }
        generatePostorder(node.left, postList);
        generatePostorder(node.right, postList);
        postList.add(node.val);
    }
}
