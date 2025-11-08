package dsa.striver.recursion.faqMedium;

import java.util.ArrayList;
import java.util.List;

public class Subsets1 {

    private void recursiveSubset (int index, int sum,int[] nums, List<Integer> result) {

        if (index == nums.length) {
            result.add(sum);
            return;
        }
        // inclusion
        recursiveSubset(index + 1, sum + nums[index], nums, result);
        // exclusion
        recursiveSubset(index + 1, sum, nums, result);
    }

    public List<Integer> subsetSums(int[] nums) {
        //your code goes here
        List<Integer> result = new ArrayList<>();
        recursiveSubset(0, 0, nums, result);
        return result;
    }
}
