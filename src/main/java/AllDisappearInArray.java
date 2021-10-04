import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class AllDisappearInArray {

    public List<Integer> findMissingNumbers(int[] nums) {
        List<Integer> missingNos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0)
                nums[idx] = -nums[idx];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) missingNos.add(i + 1);
        }
        return missingNos;
    }

    public List<Integer> findDisappeared(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) res.add(i + 1);
        }
        return res;
    }

    public List<Integer> findMissingNumbersUsingInplaceSort(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (i != nums[i - 1]) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        AllDisappearInArray f = new AllDisappearInArray();
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        //System.out.println(f.findMissingNumbers(nums));
        //System.out.println(f.findDisappeared(nums));
        System.out.println(f.findMissingNumbersUsingInplaceSort(nums));
    }
}
