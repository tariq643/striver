package dsa.striver.array.faqHard;

public class CountInversions {

    private long merge (int[] nums, int low, int mid, int high) {

        int temp[] = new int[high - low + 1];
        int left = low, right = mid + 1, index = 0;
        long countInversions = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            }
            else {
                temp[index++] = nums[right++];
                countInversions = countInversions + mid - left + 1;
            }
        }
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= high) {
            temp[index++] = nums[right++];
        }

        for (int i = low; i <= high ; i++) {
            nums[i] = temp[i - low];
        }

        return countInversions;
    }

    private long mergeSort(int[] nums, int low, int high) {

        long count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count = count + mergeSort(nums, low, mid);
            count = count + mergeSort(nums, mid + 1, high);
            count = count + merge(nums, low, mid, high);
        }
        return count;
    }

    public long numberOfInversions(int[] nums) {

        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        CountInversions countInversions = new CountInversions();
        int arr[] = {-10, -5, 6, 11, 15, 17};
        System.out.println(countInversions.numberOfInversions(arr));
    }
}
