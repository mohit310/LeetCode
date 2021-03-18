import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 */
public class SingleNumber {

    public int find(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int setSum = 0;
        int total = 0;
        for (int num : nums) {
            if (!unique.contains(num)) {
                unique.add(num);
                setSum += num;
            }
            total += num;
        }
        return 2 * setSum - total;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber.find(nums));
        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber.find(nums));
        nums = new int[]{1};
        System.out.println(singleNumber.find(nums));
    }
}
