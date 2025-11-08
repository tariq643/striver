package dsa.striver.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    private void helper (TreeNode root, List<Integer> inOrder) {

        if (root == null) {
            return;
        }
        helper(root.left, inOrder);
        inOrder.add(root.data);
        helper(root.right, inOrder);
    }
    

    public List<Integer> inorder(TreeNode root) {
        //your code goes here
        List<Integer> inOrder = new ArrayList<>();
        helper(root, inOrder);
        return inOrder;
    }
}


class TreeNode {

  int data;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) { data = val; left = null; right = null; }
}

