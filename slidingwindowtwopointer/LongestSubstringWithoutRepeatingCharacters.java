package dsa.striver.slidingwindowtwopointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int longestNonRepeatingSubstring(String s) {
        //your code goes here
        
        int maxLen = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            if (!map.containsKey(ch)) {
                map.put(ch, right);
            }
            else {
                left = Math.max(left, map.get(ch) + 1);
                map.put(ch, right);
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
