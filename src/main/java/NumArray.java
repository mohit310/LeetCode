/**
 * Given an integer array nums, find the sum of the elements between indices left and right inclusive, where (left <= right).
 * <p>
 * Implement the NumArray class:
 * <p>
 * NumArray(int[] nums) initializes the object with the integer array nums.
 * int sumRange(int left, int right) returns the sum of the elements of the nums array in the range [left, right] inclusive (i.e., sum(nums[left], nums[left + 1], ... , nums[right])).
 * <p>
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 * <p>
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * <p>
 * Approach #2 (Caching) [Accepted]
 * <p>
 * Imagine that sumRange is called one thousand times with the exact same arguments. How could we speed that up?
 * <p>
 * We could trade in extra space for speed. By pre-computing all range sum possibilities and store its results in a hash table, we can speed up the query to constant time.
 */
public class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sum(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray n = new NumArray(nums);
        System.out.println(n.sum(0, 2));
        System.out.println(n.sum(2, 5));
        System.out.println(n.sum(0, 5));
    }
}
