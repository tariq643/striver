package dsa.striver.binarysearch.logicbuilding;

import java.util.ArrayList;

public class FindMinimumInRotatedSortedArray {

    public int findMin(ArrayList<Integer> arr) {

        int low = 0, high = arr.size() - 1, ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(low) <= arr.get(mid)) {
                ans = Math.min(ans, arr.get(low));
                low = mid + 1;
            }
            else {
                high = mid - 1;
                ans = Math.min(ans, arr.get(mid));
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        findMinimumInRotatedSortedArray.findMin(integerList);
    }
}
