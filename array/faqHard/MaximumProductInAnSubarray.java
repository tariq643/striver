package dsa.striver.array.faqHard;

public class MaximumProductInAnSubarray {

    public int maxProduct(int[] nums) {

        int maxProduct = 0, product = 1;

        for (int i = 0; i < nums.length; i++) {
            product = product*nums[i];
            maxProduct = Math.max(product, maxProduct);
        }
        return maxProduct;
    }

    public static void main(String[] args) {

        MaximumProductInAnSubarray maximumProductInAnSubarray = new MaximumProductInAnSubarray();
        int nums[] = {1, -2, 3, 4, -4, -3};
        System.out.println(maximumProductInAnSubarray.maxProduct(nums));
    }
}
