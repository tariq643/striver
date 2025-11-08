package dsa.striver.basicStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortCharactersByFrequency {

    public List<Character> frequencySort(String s) {
        // Your code goes here

        Pair[] freq = new Pair[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char)(i + 'a'));
        }
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'].freq++;
        }
        Arrays.sort(freq, (ch1, ch2) -> {
            if (ch1.freq == ch2.freq) {
                return ch1.ch - ch2.ch;
            }
            return ch2.freq - ch1.freq;
        });
        List<Character> characterList = new ArrayList<>();
        for (Pair pair : freq) {
            if (pair.freq > 0) {
                characterList.add(pair.ch);
            }
        }
        return characterList;
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sol = new SortCharactersByFrequency();
        String s = "tree";
        List<Character> result = sol.frequencySort(s);
        System.out.println(result);
    }
}

class Pair {

    int freq;
    char ch;

    public Pair(int freq, char ch) {
        this.freq = freq;
        this.ch = ch;
    }
}
