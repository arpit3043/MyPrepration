package BinarySearchTree.DepthFirstSearch;
import java.util.ArrayList;
import java.util.List;
class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    TreeNode4(int val) {
        this.val = val;
    }
}
public class BinaryTreePath {
    private static final List<String> paths = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode4 root = new TreeNode4(1);
        root.left = new TreeNode4(2);
        root.right = new TreeNode4(3);
        root.left.right = new TreeNode4(5);
        List<String> result = binaryTreePaths(root);
        System.out.println(result);
    }
    private static List<String> binaryTreePaths(TreeNode4 root) {
        if (root != null) {
            dfsFindLeafsAndAddToResult(root, new StringBuilder());
        }
        return paths;
    }

    private static void dfsFindLeafsAndAddToResult(TreeNode4 root, StringBuilder sb) {
        checkRootIsNotNullAndAddValueToPath(root, sb);
        if (root.left != null && root.right != null) {
            splitPathIntoTwoPaths(root, sb);
        } else {
            if (root.left != null) {
                dfsFindLeafsAndAddToResult(root.left, sb.append("->"));
            } else {
                if (root.right != null) {
                    dfsFindLeafsAndAddToResult(root.right, sb.append("->"));
                } else {
                    paths.add(sb.toString());
                }
            }
        }
    }

    private static void checkRootIsNotNullAndAddValueToPath(TreeNode4 root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.val);
        }
    }

    private static void splitPathIntoTwoPaths(TreeNode4 root, StringBuilder sb) {
        sb.append("->");
        dfsFindLeafsAndAddToResult(root.left, new StringBuilder(sb.toString()));
        dfsFindLeafsAndAddToResult(root.right, new StringBuilder(sb.toString()));
    }
}