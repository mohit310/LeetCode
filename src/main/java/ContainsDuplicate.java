import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> nonDups = new HashSet<>(nums.length);
        for (int num : nums) {
            nonDups.add(num);
        }
        return nonDups.size() != nums.length;
    }

    public static void main(String[] args) {
        ContainsDuplicate c = new ContainsDuplicate();
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(c.containsDuplicate(nums));
        nums = new int[]{1, 2, 3, 4};
        System.out.println(c.containsDuplicate(nums));
        nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(c.containsDuplicate(nums));
    }
}
