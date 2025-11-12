package dsa.striver.binarysearch.onanswers;

public class KokoEatingBananas {

    public int minimumRateToEatBananas(int[] piles, int h) {

        int start = 1;
        int end = Integer.MIN_VALUE; // for finding the largest values in piles
        int ans = -1;

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > end) {
                end = piles[i];
            }
        }

        // apply binary search on the possible values of k -> (1, max(piles))
        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (isEatingSppedValid(piles, mid, h)) {
                end = mid - 1;
                ans = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean isEatingSppedValid (int[] piles, int eatingSpeed , int hours) {

        int hoursSpent = 0;
        for (int i = 0; i < piles.length; i++) {
            hoursSpent = hoursSpent + piles[i] / eatingSpeed;
            if (piles[i]%eatingSpeed != 0) {
                hoursSpent++;
            }
            if (hoursSpent > hours) {
                return false;
            }
        }
        return true;
    }
}
