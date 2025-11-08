package dsa.striver.sorting;

public class InsertionSort {

    public int[] insertionSort(int[] nums) {

        int n = nums.length;
        int j;
        for (int i = 0; i < n; i++) {

            j = i;
            while (j > 0 && nums[j] < nums[j-1]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        }
        return nums;
    }
}
