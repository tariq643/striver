package dsa.striver.array.faqHard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElementTwo(int[] nums) {

        List<Integer> output = new ArrayList<>();

        int element1 = 0, element2 = 0, count1 = 0, count2 = 0, n = nums.length;

        for (int i = 0; i < n; i++) {

            if (count1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                count1++;
            }
            else if (count2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                count2++;
            }
            else if (nums[i] == element1) {
                count1++;
            }
            else if (nums[i] == element2) {
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (element1 == nums[i]) {
                count1++;
            }
            if (element2 == nums[i]) {
                count2++;
            }
        }

        int min = n / 3 + 1;

        if (count1 >= min) {
            output.add(element1);
        }

        if (count2 >= min) {
            output.add(element2);
        }
        return output;
    }
}
