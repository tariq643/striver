package dsa.striver.maths.sieveOfEratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorizationOfN {

    private static final int MAX_N = 100000;
    private int[] SPF = new int[MAX_N];

    public PrimeFactorizationOfN () {
        Arrays.fill(SPF, 1);
    }

    private void sieve () {

        for (int i = 2; i*i <= MAX_N; i++) {
            if (SPF[i] == 1) {
                for (int j = i; j <= MAX_N; j++) {
                    if (SPF[j] == 1) {
                        SPF[j] = i;
                    }
                }
            }
        }
    }

    private List<Integer> primeFactor (int n) {

        List<Integer> result = new ArrayList<>();
        while (n != 1) {
            result.add(SPF[n]);
            n = n / SPF[n];
        }
        return result;
    }
    
    public List<List<Integer>> primeFactors(int[] queries) {
        //your code goes here
        List<List<Integer>> output = new ArrayList<>();

        for (int query : queries) {
            output.add(new ArrayList<>(this.primeFactor(query)));
        }
        return output;
    }
}
