import java.util.Arrays;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * <p>
 * Example 2:
 * <p>
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        StringBuilder n1 = new StringBuilder(num1);
        StringBuilder n2 = new StringBuilder(num2);
        char[] result = new char[num1.length() + num2.length()];
        Arrays.fill(result, '0');
        n1.reverse();
        n2.reverse();
        for (int i = 0; i < n2.length(); i++) {
            int n2d = n2.charAt(i) - '0';
            for (int j = 0; j < n1.length(); j++) {
                int n1d = n1.charAt(j) - '0';
                int carry = result[i + j] - '0';
                int multiply = (n1d * n2d) + carry;
                result[i + j] = (char) (multiply % 10 + '0');
                int value = (result[i + j + 1] - '0') + multiply / 10;
                result[i + j + 1] = (char) (value + '0');
            }
        }
        return new StringBuilder(String.valueOf(result)).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(MultiplyStrings.multiply("12", "34"));
    }
}
