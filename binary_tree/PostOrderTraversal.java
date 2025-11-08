package dsa.striver.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    private void helper (TreeNode root, List<Integer> postorder) {
        if (root == null) {
            return;
        }
        helper(root.left, postorder);
        helper(root.right, postorder);
        postorder.add(root.data);
    }


    public List<Integer> postorder(TreeNode root) {
        //your code goes here
        List<Integer> postorder = new ArrayList<>();
        helper(root, postorder);
        return postorder;
    }
}
