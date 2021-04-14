package com.blr19c.algorithm.dp;

import java.util.Arrays;

/**
 * 给出一个数组返回能不能分割出等和子集
 *
 * @author blr
 * @since 2021.4.13
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{2}));
    }

    /**
     * 题目可以转为背包问题:
     * 给一个可装载重量为sum/2的背包和N个物品
     * 每个物品的重量为nums[i]
     * 现在让你装物品,是否存在一种装法能够恰好将背包装满
     */
    static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        //不能被2整除
        if ((sum & 1) == 1)
            return false;
        int n = sum / 2;
        boolean[] dp = new boolean[n + 1];
        //base case 因为 nums 列表添加多少个为0的元素都不影响最后结果
        dp[0] = true;
        for (int num : nums) {
            for (int i = n; i >= num; i--) {
                //i为sum/2的当前值 dp[i] = true 说明n可以转下为i的物品
                //i-num 是除了num的重量 背包能不能装下 如果当前背包能装下 i-num的重量 那它一定可以装下 num (前提:重量一定是非负数 i>=num)
                dp[i] |= dp[i - num];
            }
        }
        return dp[n];
    }
}
