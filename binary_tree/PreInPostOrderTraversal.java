package dsa.striver.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class PreInPostOrderTraversal {


    private void helperInOrder (TreeNode root, List<Integer> inOrder) {

        if (root == null) {
            return;
        }
        helperInOrder(root.left, inOrder);
        inOrder.add(root.data);
        helperInOrder(root.right, inOrder);
    }

    public List<Integer> inorder(TreeNode root) {
        //your code goes here
        List<Integer> inOrder = new ArrayList<>();
        helperInOrder(root, inOrder);
        return inOrder;
    }

    private void helperPreOrder (TreeNode root, List<Integer> preorder) {
        if (root == null) {
            return;
        }
        preorder.add(root.data);
        helperPreOrder(root.left, preorder);
        helperPreOrder(root.right, preorder);
    }


    public List<Integer> preorder(TreeNode root) {
        //your code goes here
        List<Integer> preorder = new ArrayList<>();
        helperPreOrder(root, preorder);
        return preorder;
    }

    List<List<Integer>> treeTraversal(TreeNode root) {
        //your code goes here
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }
}
