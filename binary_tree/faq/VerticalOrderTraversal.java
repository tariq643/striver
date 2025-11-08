package dsa.striver.binary_tree.faq;

import java.util.*;

public class VerticalOrderTraversal {

    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //your code goes here

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // col -> [level -> [ list ]]
        // dfs/ bfs
        dfs (root ,0, 0);

        for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> entry : map.entrySet()) {
            TreeMap<Integer, ArrayList<Integer>> levelMap = entry.getValue();
            ArrayList<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, ArrayList<Integer>> subEntry : levelMap.entrySet()) {
                ArrayList<Integer> subList = subEntry.getValue();
                Collections.sort(subList);
                list.addAll(subList);
            }
            result.add(list);
        }
        return result;
    }

    private void dfs (TreeNode root, int column, int level) {

        if (root == null) {
            return;
        }
        if (!map.containsKey(column)) {
            map.put(column , new TreeMap<>());
        }
        if (!map.get(column).containsKey(level)) {
            map.get(column).put(level, new ArrayList<>());
        }
        map.get(column).get(level).add(root.data);
        dfs(root.left, column - 1, level + 1);
        dfs(root.right, column + 1, level + 1);
    }
}
