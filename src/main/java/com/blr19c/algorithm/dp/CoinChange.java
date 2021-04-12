package com.blr19c.algorithm.dp;

import java.util.Arrays;

/**
 * 零钱兑换问题
 * 给出一个零钱数组和需要兑换的面额求出最少的零钱个数
 *
 * @author blr
 * @since 2021.4.12
 */
public class CoinChange {

    public static void main(String[] args) {
        //System.out.println(change(new int[]{1, 3, 5, 10}, 15));
        System.out.println(changeDp(new int[]{1, 3, 5, 10}, 100));
    }

    static int change(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //拿到当前零钱剩余金额的子问题
            int subChange = change(coins, amount - coin);
            if (subChange == -1)
                continue;
            res = Math.min(res, subChange + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 还是使用备忘录消除重叠子问题
     */
    static int changeMemo(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        //因为0和-1都是有效值
        Arrays.fill(memo, Integer.MIN_VALUE);
        return memoHelp(coins, amount, memo);
    }

    static int memoHelp(int[] coins, int amount, int[] memo) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (memo[amount] != Integer.MIN_VALUE)
            return memo[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //拿到当前零钱剩余金额的子问题
            int subChange = change(coins, amount - coin);
            if (subChange == -1)
                continue;
            res = Math.min(res, subChange + 1);
        }
        return memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 将自顶向下改为自底向上迭代
     */
    static int changeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //coin面额最小为1,也就是amount最多只需要amount个 不可能出现 amount+1个
        Arrays.fill(dp, amount + 1);
        //base case 相当于 if(amount == 0) return 0
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    continue;
                //dp[i]当前问题  dp[i - coin]子问题+1代表多一步
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
