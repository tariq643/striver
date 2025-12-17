package dsa.striver.binarysearch.faq;

public class MinimizeTheMaxDistanceToGasStations {

    private int checkNumberOfGasStationsRequired(int[] arr, double distance) {

        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int diff = (int) ((int)(arr[i + 1] - arr[i]) / distance);
            count = count + diff;
        }
        return count;
    }

    public double minimiseMaxDistance(int[] arr, int k) {

        int n = arr.length;
        double low = 0, high = arr[n - 1] - arr[0];
        double diff = 1e-6;
        while (high - low >= diff) {
            double mid = low + (high - low) / 2;
            int count = this.checkNumberOfGasStationsRequired(arr, mid);
            if (count > k) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        return high;
    }
}
