package dsa.striver.binarySearchTree.faq;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode current = stack.pop();
        pushAll(current.right);
        return current.data;
    }

    private void pushAll (TreeNode node) {

        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
