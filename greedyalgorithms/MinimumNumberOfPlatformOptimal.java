package dsa.striver.greedyalgorithms;

import java.util.Arrays;

public class MinimumNumberOfPlatformOptimal {

    public int findPlatform(int[] Arrival, int[] Departure) {

        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int n = Arrival.length;

        int i = 0, j = 0, count = 0, max = 0;
        while (i < n && j < n) {
            if (Arrival[i] <= Departure[j]) {
                count++;
                i++;
            }
            else {
                count--;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
