package dsa.striver.basicStrings;

public class RotateString {

    public boolean rotateString(String s, String goal) {
        //your code goes here

        if (s.length() != goal.length()) {
            return false;
        }
        String doubledString = s + s;
        return s.contains(goal);
    }
}
