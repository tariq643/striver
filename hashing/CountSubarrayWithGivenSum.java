package dsa.striver.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithGivenSum {

    public int subarraySum(int[] nums, int k) {

        int numberOfSubArrays = 0, sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        for (int num : nums) {

            sum += num; // prefix sum
            if (sumMap.containsKey(sum - k)) {
                numberOfSubArrays += sumMap.get(sum - k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0 ) + 1);
        }
        return numberOfSubArrays;
    }
}
