package dsa.striver.graphs.minimumSpanningTree;


/*


    There are n cities and m edges connected by some number of flights.
Given an array of flights where flights[i] = [ fromi, toi, pricei]
indicates that there is a flight from city fromi to city
toi with cost pricei.
Given three integers src, dst, and k, and return the
cheapest price from src to dst with at most k stops.
If there is no such route, return -1.

 */

import java.util.Arrays;

public class CheapestFlightsWithinKStops {

    // bellmand ford algorithm
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {

        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;
        for (int i = 0; i < K + 1; i++) {
            int[] temp = Arrays.copyOf(price, n);
            for (int[] flight : flights) {
                int u = flight[0]; // src
                int v = flight[1]; // dest
                int weight = flight[2]; //weight
                if (price[u] != Integer.MAX_VALUE && price[u] + weight < temp[v]) {
                    temp[v] = price[u] + weight;
                }
            }
            price = temp;
        }
        return (price[dst] == Integer.MAX_VALUE ? -1 : price[dst]);
    }
}
