package dsa.striver.slidingwindowtwopointer.longestandsmallestwindowproblem;

public class LongestRepeatingCharacterReplacementBruteForce {

    public int characterReplacement(String s, int k) {
        //your code goes here

        /* Variable to store the maximum
        length of substring found*/
        int maxLen = 0;

       /* Variable to track the maximum frequency
        of any single character in the current window*/
        int maxFreq = 0;

        // Iterate through each starting point of the substring
        for (int i = 0; i < s.length(); ++i) {

            // Initialize hash array for character frequencies
            int[] hash = new int[26];

            for (int j = i; j < s.length(); ++j) {

                /* Update frequency of current
                character in the hash array*/
                hash[s.charAt(j) - 'A']++;

                // Update max frequency encountered
                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);

                // Calculate number of changes needed to make
                int changes = (j - i + 1) - maxFreq;

                /* If the number of changes is less than
                or equal to k, the current window is valid*/
                if (changes <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        /* Return the maximum length of substring
        with at most k characters replaced*/
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "ABA";
        int k = 1;

        // Create an instance of Solution class
        LongestRepeatingCharacterReplacementBruteForce sol = new LongestRepeatingCharacterReplacementBruteForce();

        int length = sol.characterReplacement(s, k);

        // Print the result
        System.out.println("Maximum length of substring with at most " + k + " characters replaced: " + length);
    }
}
