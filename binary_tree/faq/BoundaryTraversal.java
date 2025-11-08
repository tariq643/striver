package dsa.striver.binary_tree.faq;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    private void traversalLeft(TreeNode root, List<Integer> result) {

        TreeNode current = root.left;
        while (current != null) {
            if (!isLeaf(current)) {
                result.add(current.data);
            }
            if (current.left != null) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
    }

    private void traversalRight(TreeNode root, List<Integer> result) {

        TreeNode current = root.right;
        List<Integer> temp = new ArrayList<>();
        while (current != null) {
            if (!isLeaf(current)) {
                temp.add(current.data);
            }
            if (current.right != null) {
                current = current.right;
            }
            else {
                current = current.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; --i) {
            result.add(temp.get(i));
        }
    }

    private void traversalLeaves(TreeNode root, List<Integer> result) {

        if (isLeaf(root)) {
            result.add(root.data);
            return;
        }
        if (root.left != null) {
            traversalLeaves(root.left, result);
        }
        if (root.right != null) {
            traversalLeaves(root.right, result);
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public List<Integer> boundary(TreeNode root) {
        //your code goes here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (!isLeaf(root)) {
            result.add(root.data);
        }
        traversalLeft(root, result);
        traversalLeaves(root, result);
        traversalRight(root, result);
        return result;
    }
}

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { data = val; left = null; right = null; }
}
