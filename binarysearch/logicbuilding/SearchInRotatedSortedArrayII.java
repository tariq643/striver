package dsa.striver.binarysearch.logicbuilding;

public class SearchInRotatedSortedArrayII {

    public int search(int[] nums, int k) {

        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == k) {
                return mid;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start = start + 1;
                end = end - 1;
                continue;
            }

            // left array is sorted
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= k && k <= nums[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else  {
                if (nums[mid] <= k && k <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
