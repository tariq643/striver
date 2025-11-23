package dsa.striver.binarysearch.logicbuilding;

public class FloorAndCeilInSortedArray {

    public int[] getFloorAndCeil(int[] nums, int x) {

        int floor = -1, ceil = -1;
        int low = 0, high = nums.length - 1;
        // floor
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= x) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // ceil
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= x) {
                ceil = nums[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        FloorAndCeilInSortedArray obj = new FloorAndCeilInSortedArray();
        int arr[] = {3, 4, 4, 7, 8, 10};
        System.out.println(obj.getFloorAndCeil(arr,5));
    }
}
