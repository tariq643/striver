package dsa.striver.binary_tree.faq;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToNodePathInBT {

    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        //your code goes here

        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, currentPath, allPaths);
        return allPaths;
    }

    private void dfs (TreeNode root, List<Integer> current, List<List<Integer>> allPaths) {

        if (root == null) {
            return;
        }
        current.add(root.data);
        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(current));
        }
        else {
            dfs(root.left, current, allPaths);
            dfs(root.right, current, allPaths);
        }
        current.remove(current.size() - 1);
    }
}
