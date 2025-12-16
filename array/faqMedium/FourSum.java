package dsa.striver.array.faqMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i + 1; j < n;) {

                int p = j + 1;
                int q = n - 1;

                while (p < q) {
                    long sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum == target) {
                        output.add(Arrays.asList(nums[i],nums[j],nums[p],nums[q]));
                        p++;
                        q--;
                        while (p < q && nums[p] == nums[p-1]) {
                            p++;
                        }
                    } else if (sum < target) {
                        p++;
                    }
                    else {
                        q--;
                    }
                }

                j++;
                while (j < n && nums[j] == nums[j-1]) {
                    j++;
                }
            }
        }
        return output;
    }
}
