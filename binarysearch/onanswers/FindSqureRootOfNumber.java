package dsa.striver.binarysearch.onanswers;

public class FindSqureRootOfNumber {

    public long floorSqrt(long n) {

        long start = 0 , end = n;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long squared = mid * mid;
            if (squared == n) {
                return mid;
            }
            else if (squared < n) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        FindSqureRootOfNumber findSqureRootOfNumber = new FindSqureRootOfNumber();
        System.out.println(findSqureRootOfNumber.floorSqrt(35));
    }
}
