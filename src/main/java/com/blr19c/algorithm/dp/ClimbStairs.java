package com.blr19c.algorithm.dp;

/**
 * 爬楼梯 每次可以爬一节或者两节 给出楼梯数求一共有多少种爬法
 *
 * @author blr
 * @since 2021.4.13
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    /**
     * 当 n 为 1 时: 有1种跳法 1
     * 当 n 为 2 时: 有2种跳法 [1 1][2]
     * 当 n 为 3 时: 有3种跳法 [1 1 1][2 1][1 2]
     * 当 n 为 4 时: 有5种跳法 [1 1 1 1][2 1 1][1 1 2][1 2 1][2 2]
     * .........
     * 当n为n时 有(n-1)+(n-2)种跳法
     */
    static int climbStairs(int n) {
        int prev = 0, curr = 1;
        for (int i = 0; i < n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
