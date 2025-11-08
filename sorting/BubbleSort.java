package dsa.striver.sorting;

public class BubbleSort {

    public int[] bubbleSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i]= nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
