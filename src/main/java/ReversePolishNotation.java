import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 * <p>
 * Note that division between two integers should truncate toward zero.
 * <p>
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * <p>
 * Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * <p>
 * Example 3:
 * <p>
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();
        int first, second;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    first = Integer.valueOf(s.pop());
                    second = Integer.valueOf(s.pop());
                    s.add(first + second);
                    break;
                case "*":
                    first = Integer.valueOf(s.pop());
                    second = Integer.valueOf(s.pop());
                    s.add(first * second);
                    break;
                case "-":
                    first = Integer.valueOf(s.pop());
                    second = Integer.valueOf(s.pop());
                    s.add(second - first);
                    break;
                case "/":
                    first = Integer.valueOf(s.pop());
                    second = Integer.valueOf(s.pop());
                    s.add(second / first);
                    break;
                default:
                    s.add(Integer.parseInt(token));
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotation polishNotation = new ReversePolishNotation();
        System.out.println(polishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(polishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(polishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
