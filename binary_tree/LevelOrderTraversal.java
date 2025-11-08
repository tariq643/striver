package dsa.striver.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // TC:O(n) and SC:O(n)
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            while (size > 0) {
                TreeNode tmp = queue.poll();
                currLevel.add(tmp.data);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                size--;
            }
            traversal.add(currLevel);
        }
        return traversal;
    }
}
