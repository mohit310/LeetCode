import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 */
public class DuplicateNoArray {

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> dups = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) dups.add(idx + 1);
            nums[idx] = -nums[idx];
        }
        return dups;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        DuplicateNoArray duplicateNoArray = new DuplicateNoArray();
        System.out.println(duplicateNoArray.findDuplicates(nums));
    }
}
