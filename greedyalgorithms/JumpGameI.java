package dsa.striver.greedyalgorithms;

public class JumpGameI {

    public boolean canJump(int[] nums) {
        //your code goes here
        int reachable = 0;

        for (int i = 0; i < nums.length && i <= reachable; i++) {

            reachable = Math.max(reachable, i+nums[i]);
            if (reachable >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
