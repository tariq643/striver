package dsa.striver.array.faqHard;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

    private void merge (int[] nums, int low, int mid, int high) {

        List<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            }
            else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) {
            temp.add(nums[left++]);
        }
        while (right <= high) {
            temp.add(nums[right++]);
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    private int mergeSort (int nums[], int low, int high) {

        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count = count + mergeSort(nums, low, mid);
            count = count + mergeSort(nums, mid + 1, high);
            count = count + countPairs(nums, low, mid, high);
            merge(nums, low, mid, high);
        }
        return count;
    }

    private int countPairs (int[] nums, int low, int mid, int high) {

        int countPairs = 0, right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }
            countPairs = countPairs + right - (mid + 1);
        }
        return countPairs;
    }

    public int reversePairs(int[] nums) {

        int n = nums.length;
        return mergeSort (nums, 0, n - 1);
    }
}
