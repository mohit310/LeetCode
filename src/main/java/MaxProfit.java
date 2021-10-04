/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class MaxProfit {

    public int calcMaxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProfit p = new MaxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4,};
        System.out.println(p.calcMaxProfit(prices));
        System.out.println(p.maxProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(p.calcMaxProfit(prices));
        System.out.println(p.maxProfit(prices));
    }
}
