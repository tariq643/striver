package dsa.striver.array;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {

    public int[] intersectionArray(int[] nums1, int[] nums2) {

        List<Integer> output = new ArrayList<>();
        int i = 0,j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                output.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        int out[] = new int[output.size()];
        for (int k = 0; k < output.size(); k++) {
            out[k] = output.get(k);
        }
        return out;
    }

    public static void main(String[] args) {

        IntersectionOfTwoSortedArrays intersectionOfTwoSortedArrays = new IntersectionOfTwoSortedArrays();
        int arr1[] = {1, 2, 2, 3, 5};
        int arr2[] = {1,2,7};
        System.out.println(intersectionOfTwoSortedArrays.intersectionArray(arr1, arr2));
    }


}
