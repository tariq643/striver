package dsa.striver.binarysearch.logicbuilding;

import java.util.ArrayList;

public class FindOutHowManyTimesTheArrayIsSorted {

    public int findKRotation(ArrayList<Integer> nums) {

        int ans = Integer.MAX_VALUE;
        int index = -1;
        int low = 0, high =nums.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < ans) {
                    index = low;
                    ans = nums.get(low);
                    break;
                }
            }
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < ans) {
                    index = low;
                    ans = nums.get(low);
                }
                // Eliminate left half
                low = mid + 1;
            } else {
                /* update the ans if it
                   is less than nums.get(mid) */
                if (nums.get(mid) < ans) {
                    index = mid;
                    ans = nums.get(mid);
                }
                // Eliminate right half
                high = mid - 1;
            }
        }
        return index;
    }
}
