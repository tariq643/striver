package dsa.striver.binary_tree.faq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightLeftViewOfBT {

    private List<List<Integer>> levelOrderTrversal (TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelOrder = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                levelOrder.add(current.data);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(levelOrder);
        }
        return result;
    }

    public List<Integer> rightSideView(TreeNode root) {
        //your code goes here
        List<List<Integer>> levelOrderTraversal = this.levelOrderTrversal(root);
        List<Integer> result = new ArrayList<>();
        for (List<Integer> levelOrder : levelOrderTraversal) {
            result.add(levelOrder.get(levelOrder.size() - 1));
        }
        return result;
    }
}
