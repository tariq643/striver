package dsa.striver.bitmanipulation;

public class SingleNumberI {

    public int singleNumber(int[] nums) {
        //your code goes here
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
