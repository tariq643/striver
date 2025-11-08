package dsa.striver.recursion.implmentationProblems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> allSubsets) {

        if (index == nums.length) {
            allSubsets.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, allSubsets);

        current.remove(current.size() - 1);
        generateSubsets(index + 1, nums, current, allSubsets);

    }

    public List<List<Integer>> powerSet(int[] nums) {
        //your code goes here
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generateSubsets(0, nums, current, allSubsets);
        return allSubsets;
    }

    public static void main(String[] args) {
        PowerSet sol = new PowerSet();
        int[] nums = {1, 2};
        List<List<Integer>> result = sol.powerSet(nums);

        // Print the result
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
