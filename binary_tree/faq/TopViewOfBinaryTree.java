package dsa.striver.binary_tree.faq;

import java.util.*;

public class TopViewOfBinaryTree {

    public List<Integer> topView(TreeNode root) {
        //your code goes here
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue<CustomNode> queue = new LinkedList<>();
        queue.offer(new CustomNode(root, 0));
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        while (!queue.isEmpty()) {
            CustomNode customNode = queue.poll();
            TreeNode treeNode = customNode.treeNode;
            int column = customNode.column;
            if (!treeMap.containsKey(column)) {
                treeMap.put(column, treeNode.data);
            }
            if (treeNode.left != null) {
                queue.offer(new CustomNode(treeNode.left, column - 1));
            }
            if (treeNode.right != null) {
                queue.offer(new CustomNode(treeNode.right, column + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}

class CustomNode {

    TreeNode treeNode;
    int column;

    public CustomNode(TreeNode treeNode, int column) {
        this.treeNode = treeNode;
        this.column = column;
    }
}
