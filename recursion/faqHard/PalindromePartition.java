package dsa.striver.recursion.faqHard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public List<List<String>> partition(String s) {
        //your code goes here

        List<List<String>> allPalindromePartitions = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        dfsHelper(0, s, partition, allPalindromePartitions);
        return allPalindromePartitions;
    }

    private void dfsHelper (int index, String s, List<String> partition, List<List<String>> allPalindromePartitions) {

        if (index == s.length()) {
            allPalindromePartitions.add(new ArrayList<>(partition));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {
                partition.add(s.substring(index ,i + 1));
                dfsHelper(i + 1,s, partition, allPalindromePartitions);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        // Check if the substring s[start..end] is a palindrome
        while (start <= end) {
            // If characters do not match, it's not a palindrome
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
