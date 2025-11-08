package dsa.striver.maths.sieveOfEratosthenes;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintAllPrimeTillN {

    public ArrayList<Integer> primeTillN(int n) {
        //your code goes here
        boolean isPrime[] = new boolean[n + 1];

        Arrays.fill(isPrime, true);

        ArrayList<Integer> output = new ArrayList<>();

        for (long i = 2; i <= n; i++) {

            if (isPrime[(int) i]) {
                output.add((int) i);
                for (long val = i * i; val <= n; val = val + i) {
                    isPrime[(int) val] = false;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int n = 100;

        /* Creating an instance of
        Solution class */
        PrintAllPrimeTillN sol = new PrintAllPrimeTillN();

        // Function call to get all primes till N
        ArrayList<Integer> ans = sol.primeTillN(n);

        System.out.println("All primes till N are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
