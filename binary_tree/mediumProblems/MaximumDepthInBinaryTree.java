package dsa.striver.binary_tree.mediumProblems;

public class MaximumDepthInBinaryTree {

    public int maxDepth(TreeNode root) {
        //your code goes here
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left) , maxDepth(root.right));
    }
}

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}

