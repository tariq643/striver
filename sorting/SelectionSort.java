package dsa.striver.sorting;

public class SelectionSort {

    public int[] selectionSort(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int smallest = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[smallest]) {
                    smallest = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[smallest];
            nums[smallest] = temp;
        }
        return nums;
    }
}
