package com.blr19c.algorithm.dp;

/**
 * 买卖股票的最佳时机
 * 你只能选择某一天买入这只股票,并选择在未来的某一个不同的日子卖出该股票
 * 计算最佳收益
 *
 * @author blr
 * @since 2021.4.16
 */
public class BestTiming {

    public static void main(String[] args) {
        int[] prices = {0, 1, 2, 3, 7, 0};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitVariable(prices));

    }

    static int maxProfit(int[] prices) {
        // 0 卖出 1 买入
        int[][] dp = new int[prices.length][2];
        //第一天的 卖出一定是0
        dp[0][0] = 0;
        //第一天买入 就是花掉了 prices第一天
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //卖出计算 max(留着,卖出 买入花销+卖出所得)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //买入计算 max(之前最便宜的买入,当前买入)
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        //最后卖出
        return dp[dp.length - 1][0];
    }

    /**
     * 上面的dp数组只用到了 两个值 i-1[0] i-1[1]
     * 所以可以直接转为两个变量
     */
    static int maxProfitVariable(int[] prices) {
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        return sell;
    }
}
