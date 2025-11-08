package dsa.striver.array;

public class FindMissingNumber {

    public int missingNumber(int[] nums) {

        int n = nums.length + 1, xor1 = 0, xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor1 = xor1 ^ nums[i];
        }
        for (int i = 1; i < n; i++) {
            xor2 = xor2 ^ i;
        }
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {

        FindMissingNumber findMissingNumber = new FindMissingNumber();
        int num[] = {0, 1, 2, 4, 5, 6};
        System.out.println(findMissingNumber.missingNumber(num));
    }
}
