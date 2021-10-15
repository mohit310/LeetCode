import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * <p>
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class ProductOfArrayMinusSelf {

    public int[] mulArrayNSquared(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                product *= nums[j];
            }
            result[i] = product;
        }
        return result;
    }

    public int[] mulArray(int[] nums) {
        int[] result = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ProductOfArrayMinusSelf p = new ProductOfArrayMinusSelf();
        System.out.println(Arrays.stream(p.mulArray(nums)).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println();
        nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.stream(p.mulArray(nums)).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println();
    }
}
