package dsa.striver.slidingwindowtwopointer.longestandsmallestwindowproblem;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostKDistinctCharacters {

    public int kDistinctChar(String s, int k) {
        //your code goes here

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, l = 0, r = 0, n = s.length();

        while (r < n) {
            char rChar = s.charAt(r);

            map.put(rChar, map.getOrDefault(rChar, 0) + 1);

            if (map.size() > k) {
                char lChar = s.charAt(l);
                map.put(lChar, map.get(lChar) - 1);
                if (map.get(lChar) == 0) {
                    map.remove(lChar);
                }
                l++;
            }
            else {
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r++;
        }
        return maxLength;
    }

    public static void main(String[] args) {

        LongestSubstringWithAtmostKDistinctCharacters obj = new LongestSubstringWithAtmostKDistinctCharacters();
        System.out.println(obj.kDistinctChar("abcddefg",3));
    }
}
