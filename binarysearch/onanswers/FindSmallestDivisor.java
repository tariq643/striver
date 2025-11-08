package dsa.striver.binarysearch.onanswers;

public class FindSmallestDivisor {

    private int sumByDivisor (int[] nums,int limit) {
        int n = nums.length;

        // Find the summation of division values
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)nums[i] / (double)limit);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int limit) {

        int max = Integer.MIN_VALUE;
        int n = nums.length;
        if (n > limit) return -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        int low = 1, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumByDivisor(nums, mid) <= limit) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;

    }
}
