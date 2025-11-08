package dsa.striver.binarySearchTree.medium;

public class InsertAGivenNodeInBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        //your code goes here

        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode current = root;

        while (true) {

            // left sub-tree
            if (val < current.data) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                }
                else {
                    current = current.left;
                }
            }
            else {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                }
                else {
                    current = current.right;
                }
            }
        }
        return root;
    }
}


class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}