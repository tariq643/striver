package dsa.striver.greedyalgorithms;

import java.util.Arrays;

public class NonOverlappingInterval {

    public static int comp(int[] val1, int[] val2) {
        return Integer.compare(val1[1],val2[1]);
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, NonOverlappingInterval::comp);
        int n = intervals.length;

        int lastEndTime = intervals[0][1];
        int count = 0;
        for (int i = 1; i < n; i++) {

            if (intervals[i][0] >= lastEndTime) {
                count++;
                lastEndTime = intervals[i][1];
            }
        }

        return n - count;
    }
}
