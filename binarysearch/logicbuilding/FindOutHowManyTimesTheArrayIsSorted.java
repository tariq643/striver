package dsa.striver.binarysearch.logicbuilding;

import java.util.ArrayList;

public class FindOutHowManyTimesTheArrayIsSorted {

    public int findKRotation(ArrayList<Integer> nums) {

        int result = 0;
        int low = 0, high = nums.size() - 1;
        // base case
        if (nums.size() == 1 || nums.get(0) < nums.get(1)) {
            return 0;
        }
        if (nums.get(high - 1) > nums.get(high)) {
            return high + 1;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) < nums.get(mid - 1)) {
                return nums.size() - mid;
            }
            else if (nums.get(mid) >= nums.get(mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return result;
    }
}
