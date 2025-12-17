package dsa.striver.binarysearch.faq;

public class SplitArrayLargestSum {

    private int countPartitions(int maxSum, int[] a) {

        int n = a.length;
        int subArraySum = 0;
        int partitions = 1;

        for (int i = 0; i < n; i++) {
            if (subArraySum + a[i] <= maxSum) {
                subArraySum = subArraySum + a[i];
            }
            else {
                subArraySum = a[i];
                partitions = partitions + 1;
            }
        }
        return partitions;
    }

    public int largestSubarraySumMinimized(int[] a, int k) {

        int low = a[0], high = Integer.MIN_VALUE, sum = 0;
        for (int num : a) {
            low = Math.max(low, num);
            sum = sum + num;
        }
        high =sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int partitions = this.countPartitions(mid, a);
            if (partitions > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }
}
