package dsa.striver.bitmanipulation.problems;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        //your code goes here
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum = sum + 1;
                }
            }
            sum = sum % 3;
            if (sum != 0) {
                ans = ans | sum << i;
            }
        }
        return ans;
    }
}
