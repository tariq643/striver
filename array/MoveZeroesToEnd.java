package dsa.striver.array;

import java.util.Arrays;

public class MoveZeroesToEnd {

    public void moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }

    public static void main(String[] args) {

        MoveZeroesToEnd moveZeroesToEnd = new MoveZeroesToEnd();
        int nums[] = {0, 20, 0, -20, 0, 20};
        moveZeroesToEnd.moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
