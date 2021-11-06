public class MaxProfitWithFee {

    public int maxProfit(int[] prices, int fee) {
        return dp(prices, fee, 0, false);
    }

    public int maxProfitMemoization(int[] prices, int fee) {
        int[][] dp = new int[1][2];
        for (int i = prices.length - 1; i >= 0; i--) {
            int[][] oldDp = dp;
            dp = new int[1][2];
            int bought = 1;
            while (bought >= 0) {
                int maxProfit = 0;
                if (bought == 1) {
                    maxProfit = Math.max(maxProfit, oldDp[0][0] - prices[i] - fee);
                } else {
                    maxProfit = Math.max(maxProfit, oldDp[0][1] + prices[i]);
                }
                maxProfit = Math.max(maxProfit, oldDp[0][bought]);

                dp[0][bought] = maxProfit;
                bought--;
            }
        }
        return dp[0][1];
    }

    private int dp(int[] prices, int fee, int pos, boolean isBought) {
        if (pos == prices.length) return 0;
        int maxProfit = 0;
        int position = pos + 1;
        if (!isBought) {
            maxProfit = Math.max(maxProfit, dp(prices, fee, position, true) - prices[pos] - fee);
        } else {
            maxProfit = Math.max(maxProfit, dp(prices, fee, position, false) + prices[pos]);
        }
        maxProfit = Math.max(maxProfit, dp(prices, fee, position, isBought));
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfitWithFee m = new MaxProfitWithFee();
//        System.out.println(m.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
//        System.out.println(m.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
        System.out.println(m.maxProfitMemoization(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
