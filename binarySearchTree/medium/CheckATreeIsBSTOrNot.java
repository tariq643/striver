package dsa.striver.binarySearchTree.medium;

public class CheckATreeIsBSTOrNot {

    private boolean helper (TreeNode root, int min, int max) {

        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        boolean leftValidTree = helper(root.left, min, root.data);
        boolean rightValidTree = helper(root.right, root.data, max);

        return leftValidTree && rightValidTree;
    }

    public boolean isBST(TreeNode root) {
        //your code goes here
        if (root == null) {
            return true;
        }
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
