package dsa.striver.array.faqMedium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (integerMap.containsKey(complement)) {
                return new int[]{integerMap.get(complement), i};
            }
            integerMap.put(nums[i], i);
        }
        return new int[]{-1};
    }
}
