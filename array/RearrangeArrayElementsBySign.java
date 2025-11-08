package dsa.striver.array;

import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {

        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= 0) {
                positiveNumbers.add(nums[i]);
            }
            else {
                negativeNumbers.add(nums[i]);
            }
        }

        int index = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            nums[index++] = positiveNumbers.get(i);
            nums[index++] = negativeNumbers.get(i);
        }
        return nums;
    }
}
