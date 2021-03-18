/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class StairsClimb {

    public long findNumberOfCombinations(int n) {
        if (n == 1) return 1;
        long first = 1;
        long second = 2;
        for (int i = 3; i <= n; i++) {
            long third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    public long findStairCombos(int n) {
        //TODO: Add memoization
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return findStairCombos(n - 1) + findStairCombos(n - 2);
    }

    public static void main(String[] args) {
        StairsClimb c = new StairsClimb();
        for (int i = 1; i <= 50; i++) {
            //System.out.println(c.findNumberOfCombinations(i));
            System.out.println(c.findStairCombos(i));
        }
    }
}
