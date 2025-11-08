package dsa.striver.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {

    private void helper (TreeNode root, List<Integer> preorder) {
        if (root == null) {
            return;
        }
        preorder.add(root.data);
        helper(root.left, preorder);
        helper(root.right, preorder);
    }


    public List<Integer> preorder(TreeNode root) {
        //your code goes here
        List<Integer> preorder = new ArrayList<>();
        helper(root, preorder);
        return preorder;
    }
}
