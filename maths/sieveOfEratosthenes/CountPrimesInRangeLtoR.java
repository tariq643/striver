package dsa.striver.maths.sieveOfEratosthenes;

import java.util.ArrayList;
import java.util.Arrays;

public class CountPrimesInRangeLtoR {

    private static final int MAX_N = 100000;
    private static int[] SPF = new int[MAX_N + 1];

    private void sieve () {

        Arrays.fill(SPF, 1);

        SPF[0] = 0;
        SPF[1] = 0;

        for (int i = 2; i*i <= MAX_N; i++) {

            if (SPF[i] == 1) {
                for (int j = i * i; j <= MAX_N; j= j + i) {
                    SPF[j] = 0;
                }
            }
        }
    }

    public ArrayList<Integer> primesInRange(ArrayList<int[]> queries) {
        //your code goes here

        sieve();

        ArrayList<Integer> output = new ArrayList<>();

        int[] primeCount = new int[MAX_N + 1];

        for (int i = 2; i <= MAX_N; i++) {
            primeCount[i] = primeCount[i-1];
            if (SPF[i] == 1) {
                primeCount[i]++;
            }
        }

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            output.add(primeCount[right] - primeCount[left - 1]);
        }
        return output;
    }

    public static void main(String[] args) {
        CountPrimesInRangeLtoR countPrimesInRangeLtoR = new CountPrimesInRangeLtoR();
        countPrimesInRangeLtoR.sieve();
        for (int i = 0; i <= MAX_N; i++) {
            System.out.println(i + " " + SPF[i]);
        }
    }
}
