/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * Tip: Starts with 0 and not 1.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int total = (nums.length * (nums.length + 1)) / 2;
        for (int n : nums) {
            total -= n;
        }
        return total;
    }

    //Formula (n(n+1))/2
    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing Number:" + m.missingNumber(nums));
        nums = new int[]{0};
        System.out.println("Missing Number:" + m.missingNumber(nums));
        nums = new int[]{0, 1};
        System.out.println("Missing Number:" + m.missingNumber(nums));
    }
}
