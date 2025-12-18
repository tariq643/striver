package dsa.striver.bitmanipulation.problems;

import java.util.ArrayList;
import java.util.List;

public class PowerSetBitManipulation {

    public List<List<Integer>> powerSet(int[] nums) {

        //your code goes here

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        int count = 1 << n;
        for (int val = 0; val < count; val++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((val & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            ans.add(subset);
        }
        return ans;
    }
}
