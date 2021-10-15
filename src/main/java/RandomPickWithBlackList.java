import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * You are given an integer n and an array of unique integers blacklist. Design an algorithm to pick a random integer in the range [0, n - 1] that is not in blacklist. Any integer that is in the mentioned range and not in blacklist should be equally likely to be returned.
 * <p>
 * Optimize your algorithm such that it minimizes the number of calls to the built-in random function of your language.
 * <p>
 * Implement the Solution class:
 * <p>
 * Solution(int n, int[] blacklist) Initializes the object with the integer n and the blacklisted integers blacklist.
 * int pick() Returns a random integer in the range [0, n - 1] and not in blacklist.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * Output
 * [null, 0, 4, 1, 6, 1, 0, 4]
 * <p>
 * Explanation
 * Solution solution = new Solution(7, [2, 3, 5]);
 * solution.pick(); // return 0, any integer from [0,1,4,6] should be ok. Note that for every call of pick,
 * // 0, 1, 4, and 6 must be equally likely to be returned (i.e., with probability 1/4).
 * solution.pick(); // return 4
 * solution.pick(); // return 1
 * solution.pick(); // return 6
 * solution.pick(); // return 1
 * solution.pick(); // return 0
 * solution.pick(); // return 4
 */
public class RandomPickWithBlackList {

    int whitelistedCount;
    Random r;
    Map<Integer, Integer> blRemap;

    public RandomPickWithBlackList(int N, int[] blacklist) {
        blRemap = Arrays.stream(blacklist).mapToObj(Integer::valueOf).collect(Collectors.toMap(i -> i, i -> -1));
        whitelistedCount = N - blRemap.size();

        for (int b : blacklist) { // O(B)
            if (b < whitelistedCount) { // re-mapping
                while (blRemap.containsKey(N - 1))
                    N--;
                blRemap.put(b, N - 1);
                N--;
            }
        }

        r = new Random();
    }


    public int pick() {
        int p = r.nextInt(whitelistedCount);
        if (blRemap.containsKey(p))
            return blRemap.get(p);
        return p;
    }

    public static void main(String[] args) {
        //N=10, blacklist=[3, 5, 8, 9]
//        RandomPickWithBlackList r = new RandomPickWithBlackList(10, new int[]{3, 5, 8, 9});
//        System.out.println(r.pick());
//        System.out.println(r.pick());
//        System.out.println(r.pick());
//        System.out.println(r.pick());
//        System.out.println(r.pick());
        //N=7, blacklist=[2, 3, 5]
        RandomPickWithBlackList r = new RandomPickWithBlackList(7, new int[]{2, 3, 5});
        System.out.println(r.pick());
        System.out.println(r.pick());
        System.out.println(r.pick());
        System.out.println(r.pick());
        System.out.println(r.pick());
    }
}
