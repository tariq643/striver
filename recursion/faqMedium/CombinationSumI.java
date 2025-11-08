package dsa.striver.recursion.faqMedium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    private void recursiveHelper (int index, int n, int[] candidates,List<Integer> current, List<List<Integer>> allCombinations, int sum) {

        if (sum == 0) {

            if (!allCombinations.contains(current)) {
                allCombinations.add(new ArrayList<>(current));
            }
            return;
        }

        if (index == n || sum < 0) {
            return;
        }

        current.add(candidates[index]);

        recursiveHelper(index + 1, n, candidates, current, allCombinations, sum - candidates[index]);
        recursiveHelper(index, n, candidates, current, allCombinations, sum - candidates[index]);

        current.remove(current.size() - 1);

        // exclusion condition
        recursiveHelper(index + 1, n ,candidates, current, allCombinations, sum);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //your code goes here

        List<Integer> current = new ArrayList<>();
        List<List<Integer>> allCombinations = new ArrayList<>();
        int n = candidates.length;

        recursiveHelper (0, n, candidates, current, allCombinations, target);

        return allCombinations;
    }
}
