package dsa.striver.binary_tree.mediumProblems;

public class CheckIfBinaryTreeIsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        //your code goes here
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.data != right.data) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
