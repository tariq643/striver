package dsa.striver.array.faqMedium;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        // Your code goes here

        int pivot = -1, n = nums.length;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            reverse(0, n -1, nums);
            return;
        }

    }

    private void reverse(int a, int b, int[] nums) {
        while (a <= b) {
            swap(a++, b-- ,nums);
        }
    }

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
