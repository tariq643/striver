package dsa.striver.greedyalgorithms;

import java.util.Arrays;

public class ShortestJobFirst {

    public long solve(int[] bt) {
        //your code goes here
        Arrays.sort(bt);

        long wt = 0, t = 0;
        for (int i = 0; i < bt.length; i++) {
            wt+=t;
            t+=bt[i];
        }
        return wt/bt.length;
    }

    public static void main(String[] args) {

    }
}
