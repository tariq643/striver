package dsa.striver.stack_queue.faq;

public class TrappingRainwaterOptimal {

    public int trap(int[] height) {

        int n = height.length;
        int l = 0, r = n -1;

        int lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;

        int totalWater = 0;

        while (l < r) {

            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);

            if (lMax < rMax) {
                totalWater = totalWater + lMax - height[l];
                l++;
            }
            else {
                totalWater = totalWater + rMax - height[r];
                r--;
            }
        }
        return totalWater;
    }
}
