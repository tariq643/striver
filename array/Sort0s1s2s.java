package dsa.striver.array;

public class Sort0s1s2s {

    public void sortZeroOneTwo(int[] nums) {

        int left = 0,mid = 0,right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(left, mid, nums);
                left++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                swap(mid, right, nums);
                right--;
            }
        }
    }

    private void swap(int pos1,int pos2,int[] nums) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }
}
