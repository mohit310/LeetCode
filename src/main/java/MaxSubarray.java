/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Kadanes Algorithm
 * <p>
 * Some properties of this problem are:
 * <p>
 * If the array contains all non-negative numbers, then the problem is trivial; a maximum subarray is the entire array.
 * If the array contains all non-positive numbers, then a solution is any subarray of size 1 containing the maximal value of the array (or the empty subarray, if it is permitted).
 * Several different sub-arrays may have the same maximum sum.
 * <p>
 * [−2, 1, −3, 4, −1, 2, 1, −5, 4],
 */
public class MaxSubarray {
    public int maxSubArray(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        MaxSubarray m = new MaxSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(m.maxSubArray(nums));
    }
}
