package dsa.striver.string_advancedAlgo;

public class ReverseEveryWordInString {

    public String reverseWords(String s) {

        String reverseWord = "", temp = "";

        s = " " + s;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);
            if (ch == ' ') {
                reverseWord = reverseWord + temp + " ";
                temp = "";
            }
            else {
                temp = ch + temp;
            }
        }
        return reverseWord.replaceAll("\\s+"," ").trim();
    }

    public static void main(String[] args) {
        ReverseEveryWordInString reverseEveryWordInString = new ReverseEveryWordInString();
        System.out.println(reverseEveryWordInString.reverseWords("welcome to the jungle"));
    }
}
