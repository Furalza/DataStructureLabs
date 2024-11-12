import java.util.Deque;
import java.util.LinkedList;

public class Lab3 {

    // Main method to test the functionality
    public static void main(String[] args) {
        // Test cases
        String[] expressions = {
                "( a + b * ( c / ( d – e ) ) ) + ( d / e )", // true
                "( a + b * { c / ( d – e )} ) + [ d / e]", // true
                "(2+[5+7]+1)", // true
                "(a + b) * [c + {d + e}] / (f - g)", // true
                "(a + b] * (c + d)", // false
                "((a + b) * (c + d)", // false
                "((a + b) * (c + d))]", // false
                "no parentheses at all!" // true
        };

        for (String expression : expressions) {
            System.out.println("Expression: \"" + expression + "\" is balanced: " + isBalanced(expression));
        }
    }

    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new LinkedList<>();
        boolean balanced = true;
        int index = 0;

        while (balanced && index < expression.length()) {
            char ch = expression.charAt(index);

            if (isOpen(ch)) {
                stack.push(ch);
            } else if (isClose(ch)) {
                if (stack.isEmpty()) {
                    balanced = false;
                } else {
                    char topChar = stack.pop();
                    if (!areMatching(topChar, ch)) {
                        balanced = false;
                    }
                }
            }
            index++;
        }

        return balanced && stack.isEmpty();
    }

    private static boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[' || ch == '<';
    }

    private static boolean isClose(char ch) {
        return ch == ')' || ch == '}' || ch == ']' || ch == '>';
    }

    private static boolean areMatching(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
                (c1 == '{' && c2 == '}') ||
                (c1 == '[' && c2 == ']') ||
                (c1 == '<' && c2 == '>');
    }
}
