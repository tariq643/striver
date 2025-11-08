package dsa.striver.slidingwindowtwopointer.longestandsmallestwindowproblem;

import java.util.HashSet;
import java.util.Set;

public class FruitsIntoBasketsBruteForce {

    public int totalFruits(int[] fruits) {
        //your code goes here

        int n = fruits.length, maxLen = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> integerSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                integerSet.add(fruits[j]);
                if (integerSet.size() <= 2) {
                    maxLen = Math.max(maxLen, j- i + 1);
                }
                else {
                    break;
                }
            }
        }
        return maxLen;
    }
}
