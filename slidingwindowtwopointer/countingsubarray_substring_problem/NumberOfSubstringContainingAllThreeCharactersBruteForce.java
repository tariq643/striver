package dsa.striver.slidingwindowtwopointer.countingsubarray_substring_problem;

public class NumberOfSubstringContainingAllThreeCharactersBruteForce {

    public int numberOfSubstrings(String s) {
        //your code goes here

        int numberOfSubstrings = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int hash[] = new int[3];
            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'a']++;
                if (hash[0] == 1 && hash[1] == 1 && hash[2] == 1) {
                    numberOfSubstrings++;
                }
            }
        }
        return numberOfSubstrings;
    }

    public static void main(String[] args) {

    }
}
