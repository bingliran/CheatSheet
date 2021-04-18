package com.blr19c.algorithm.dp;

import java.util.Arrays;

/**
 * 给出一个数组 计算最大子序和
 *
 * @author blr
 * @since 2021.4.18
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayVariable(nums));
    }

    static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        //历史最大值
        int hisMax = nums[0];
        dp[0] = hisMax;
        for (int i = 1; i < n; i++) {
            //如果上一轮相加都是负数了 则改为0重新开始
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            hisMax = Math.max(dp[i], hisMax);
        }
        return hisMax;
    }

    /**
     * 其实只需要使用 dp[i-1] 和 hisMax就可以了
     */
    static int maxSubArrayVariable(int[] nums) {
        int n = nums.length;
        int dp = nums[0], hisMax = dp;
        for (int i = 1; i < n; i++) {
            dp = Math.max(dp, 0) + nums[i];
            hisMax = Math.max(dp, hisMax);
        }
        return hisMax;
    }
}
