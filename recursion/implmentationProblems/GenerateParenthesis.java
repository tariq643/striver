package dsa.striver.recursion.implmentationProblems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    private void generate (int open, int close, int n, String current, List<String> allPairs) {

        if (open == close && open + close == 2 * n) {
            allPairs.add(current);
            return;
        }
        if (open < n) {
            generate(open + 1, close, n, current.concat("("), allPairs);
        }
        if (close < open) {
            generate(open, close + 1, n, current.concat(")"), allPairs);
        }
    }

    public List<String> generateParenthesis(int n) {
        //your code goes here

        List<String> allPairs = new ArrayList<>();
        generate(0,0, n,"", allPairs);
        return allPairs;
    }

    public static void main(String[] args) {
        GenerateParenthesis sol = new GenerateParenthesis();
        int n = 2; // Example input
        List<String> result = sol.generateParenthesis(n);

        System.out.println("All combinations of balanced parentheses for n = " + n + " are:");
        for (String combination : result) {
            System.out.println(combination);
        }
    }
}
