package com.blr19c.algorithm.dp;

/**
 * 打家劫舍
 *
 * @author blr
 * @since 2021.4.19
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 2, 1};
        System.out.println(rob(nums));
        System.out.println(robVariable(nums));
    }

    static int rob(int[] nums) {
        int n = nums.length;
        //dp[0][0]打劫 dp[0][1]跳过
        int[][] dp = new int[n + 1][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            //打劫 = 上次没偷+这次偷了
            dp[i][0] = dp[i - 1][1] + nums[i];
            //跳过 = max(上次没偷,上次偷了)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }
        //偷了或者没偷的最大值
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 同样的更改为两个变量
     */
    static int robVariable(int[] nums) {
        int rob = nums[0], skip = 0;
        for (int i = 1; i < nums.length; i++) {
            int prev = rob;
            rob = skip + nums[i];
            skip = Math.max(skip, prev);
        }
        return Math.max(rob, skip);
    }
}
