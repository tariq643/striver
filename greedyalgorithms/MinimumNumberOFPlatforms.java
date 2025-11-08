package dsa.striver.greedyalgorithms;

public class MinimumNumberOFPlatforms {

    public int findPlatform(int[] Arrival, int[] Departure) {
        //your code goes here

        int minPlatform = 0;
        int n = Arrival.length;

        for (int i = 0; i < n; i++) {

            int count = 1;
            for (int j = 0; j < n; j++) {
                if (i != j ) {
                    if (Arrival[i] >= Arrival[j] && Departure[i] <= Departure[j]) {
                        count++;
                    }
                }
            }
            minPlatform = Math.max(minPlatform, count);
        }
        return minPlatform;
    }
}
