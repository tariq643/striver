package dsa.striver.array;

import java.util.Set;
import java.util.TreeSet;

public class UnionOfTwoSortedArrays {

    public int[] unionArray(int[] nums1, int[] nums2) {

        Set<Integer> integerSet = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++) {
            integerSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            integerSet.add(nums2[i]);
        }
        int output[] = new int[integerSet.size()];
        int index = 0;
        for (int num : integerSet) {
            output[index++] = num;
        }
        return output;
    }
}
