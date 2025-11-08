package dsa.striver.recursion.faqMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    private void recursiveCombinationSum (int index, int sum, int[] candidates, List<Integer> current, List<List<Integer>> result) {

        if (sum == 0) {
            if (!result.contains(current)) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        if (index == candidates.length || sum < 0) {
            return;
        }
        current.add(candidates[index]);
        recursiveCombinationSum(index + 1, sum - candidates[index], candidates, current, result);
        current.remove(current.size() - 1);
        for (int i = index + 1; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                recursiveCombinationSum(index + 1, sum, candidates, current, result);
                break;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //your code goes here
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        recursiveCombinationSum(0, target, candidates, current, result);
        return result;
    }
}
