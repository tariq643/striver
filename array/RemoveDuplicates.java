package dsa.striver.array;

import java.util.Arrays;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int j = 0, i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[j++] = nums[i];
            }
        }
        nums[j++] = nums[i];
//        for (int k = j; k < nums.length; k++) {
//            nums[k] = 0;
//        }
        return j;
    }

    public static void main(String[] args) {

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int nums[] = {0, 0, 3, 3, 5, 5, 5, 6, 6, 7};
        System.out.println(removeDuplicates.removeDuplicates(nums));
        Arrays.stream(nums).forEach(System.out::print);
    }

}
