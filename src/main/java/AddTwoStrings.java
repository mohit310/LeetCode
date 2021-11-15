/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 * <p>
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * <p>
 * Example 2:
 * <p>
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * <p>
 * Example 3:
 * <p>
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 */
public class AddTwoStrings {

    public static String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int carry = 0;
        StringBuilder b = new StringBuilder();
        while (n1 >= 0 || n2 >= 0 || carry == 1) {
            int n1d = 0, n2d = 0;
            if (n1 >= 0) n1d = num1.charAt(n1) - '0';
            if (n2 >= 0) n2d = num2.charAt(n2) - '0';
            int addition = n1d + n2d + carry;
            carry = addition / 10;
            int digit = addition % 10;
            b.append(digit);
            n1--;
            n2--;
        }
        return b.reverse().toString();
    }

    public static void main(String[] args) {
        //System.out.println(AddTwoStrings.addStrings("123", "456"));
        System.out.println(AddTwoStrings.addStrings("999", "101"));

    }

}

