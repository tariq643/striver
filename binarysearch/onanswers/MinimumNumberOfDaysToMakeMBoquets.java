package dsa.striver.binarysearch.onanswers;

public class MinimumNumberOfDaysToMakeMBoquets {

    private int[] findRange(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return new int[]{min, max};
    }

    private boolean possible(int n, int[] nums, int k, int m, int mid) {

        int total = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= mid) {
                count++;
            }
            else {
                count = 0;
            }
            if (count == k) {
                total++;
                count = 0;
            }
            if (total >= m) {
                return true;
            }
        }
        return false;
    }

    public int roseGarden(int[] nums, int k, int m) {

        int n = nums.length;
        int[] range = this.findRange(nums);
        int start = range[0];
        int end = range[1];
        long value = (long) k * m;
        if (value > n) {
            return -1;
        }
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (possible(n, nums, k, m, mid)) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static void main() {
        MinimumNumberOfDaysToMakeMBoquets obj = new MinimumNumberOfDaysToMakeMBoquets();
        // n = 8, nums = [7, 7, 7, 7, 13, 11, 12, 7], m = 2, k = 3
        System.out.println(obj.roseGarden(new int[]{7, 7, 7, 7, 13, 11, 12, 7},3,2));
    }
}
