package dsa.striver.slidingwindowtwopointer.countingsubarray_substring_problem;

public class NumberOfSubstringContainingAllThreeCharactersOptimal {

    public int numberOfSubstrings(String s) {
        //your code goes here
        int n = s.length(), numberOfSubstrings = 0;
        int hash[] = {-1, -1, -1};
        for (int i = 0; i < n; i++) {

            hash[s.charAt(i) - 'a'] = i;
            if (hash[0] != -1 && hash[1] != -1 && hash[2] != -1) {
                numberOfSubstrings = numberOfSubstrings + 1 + Math.min(Math.min(hash[0],hash[1]),hash[2]);
            }
        }
        return numberOfSubstrings;
    }

    public static void main(String[] args) {

    }
}
