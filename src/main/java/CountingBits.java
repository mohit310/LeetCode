import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 105
 */
public class CountingBits {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = convertToBinaryAndCount(i);
        }
        return ans;
    }

    private int convertToBinaryAndCount(int num) {
        Stack<Integer> s = new Stack();
        for (int i = num; i > 0; i = i / 2) {
            s.push(i % 2);
        }
        int sum = 0;
        while (!s.empty()) {
            sum += s.pop();
        }
        return sum;
    }


    public static void main(String[] args) {
        CountingBits c = new CountingBits();
        long now = System.nanoTime();
        printArray(c.countBits(32));
        long end = System.nanoTime();
        System.out.println(end - now);
        now = System.nanoTime();
        printArray(c.countBits1(32));
        end = System.nanoTime();
        System.out.println(end - now);
    }

    private static void printArray(int[] countBits) {
        System.out.println(Arrays.stream(countBits).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(",", "[", "]")));
    }
}
