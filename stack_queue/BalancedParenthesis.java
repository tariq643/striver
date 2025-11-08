package dsa.striver.stack_queue;

import java.util.Stack;

public class BalancedParenthesis {

    public boolean isValid(String str) {

        if (str.length() == 0) {
            return true;
        }

        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                characterStack.push(ch);
            }
            else {

                if (characterStack.isEmpty()) {
                    return false;
                }

                if (ch == ')') {
                    if (characterStack.peek() != '(') {
                        return false;
                    }
                }

                if (ch == '}') {
                    if (characterStack.peek() != '{') {
                        return false;
                    }
                }

                if (ch == ']') {
                    if (characterStack.peek() != '[') {
                        return false;
                    }
                }

                characterStack.pop();
            }
        }
        if (characterStack.isEmpty()) {
            return true;
        }
        return false;
    }
}
