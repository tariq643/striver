package dsa.striver.slidingwindowtwopointer.longestandsmallestwindowproblem;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasketsOptimal {

    public int totalFruits(int[] fruits) {

        //your code goes here
        // Length of the input array
        int n = fruits.length;

        /* Variable to store the
        maximum length of substring */
        int maxLen = 0;

        /* Map to track the count of each
        fruit type in the current window */
        Map<Integer, Integer> mpp = new HashMap<>();

        // Pointers for the sliding window approach
        int l = 0, r = 0;
        while (r < n) {
            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);

            /* If number of different fruits exceeds
             2 shrink the window from the left */
            if (mpp.size() > 2) {
                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
                if (mpp.get(fruits[l]) == 0) {
                    mpp.remove(fruits[l]);
                }
                l++;
            }
            /* If number of different fruits
            is at most 2, update maxLen */
            else {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        // Return the maximum fruit
        return maxLen;
    }
}
