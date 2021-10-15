import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 * Implement the RandomizedSet class:
 * <p>
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * <p>
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 * <p>
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2
 */
public class RandomizedSet {

    private final ArrayList<Integer> nums;
    private final HashMap<Integer, Integer> numToIndex;
    private final Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        numToIndex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int num) {
        if (numToIndex.containsKey(num)) return false;
        nums.add(num);
        numToIndex.put(num, nums.size() - 1);
        return true;
    }

    public boolean remove(int num) {
        if (!numToIndex.containsKey(num)) return false;
        int arrayIndex = numToIndex.get(num);
        int lastIndex = nums.size() - 1;
        if (arrayIndex == lastIndex) {
            nums.remove(arrayIndex);
            numToIndex.remove(num);
        } else {
            int tmp = nums.get(lastIndex);
            int toRemoveNum = nums.get(arrayIndex);
            nums.set(lastIndex, toRemoveNum);
            nums.set(arrayIndex, tmp);
            nums.remove(lastIndex);
            numToIndex.replace(tmp, arrayIndex);
            numToIndex.remove(num);
        }
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        RandomizedSet s = new RandomizedSet();
        System.out.println(s.insert(1));
        System.out.println(s.remove(2));
        System.out.println(s.insert(2));
        System.out.println(s.getRandom());
        System.out.println(s.remove(1));
        System.out.println(s.insert(2));
        System.out.println(s.getRandom());
    }
}
