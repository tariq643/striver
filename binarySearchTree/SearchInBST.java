package dsa.striver.binarySearchTree;

public class SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {
        //your code goes here
        if (root == null) {
            return null;
        }
        if (root.data == val) {
            return root;
        }
        if (val < root.data) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}


class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
      TreeNode(int val) { data = val; left = null; right = null; }
}