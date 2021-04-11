package com.blr19c.algorithm.dp;

/**
 * 斐波那契数列
 * 计算为n时数列的大小
 *
 * @author blr
 * @since 2021.4.11
 */
public class FibonacciSequence {

    public static void main(String[] args) {
        System.out.println(fib(15));
        System.out.println(fibMemo(15));
        System.out.println(fibDp(15));
    }

    /**
     * 最简单的计算方式 直接计算 n-1 + n-2 的值
     */
    static int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 上面最简单的计算方式会有非常多的重叠问题
     * 例如: n = 10 fib(9)+fib(8) fib(9) = fib(8)+fib(7)
     * 使用备忘录记录已经计算过的值
     */
    static int fibMemo(int n) {
        return memoHelp(n, new int[n + 1]);
    }

    static int memoHelp(int n, int[] memo) {
        if (n == 0 || n == 1)
            return n;
        //如果已经计算过了
        if (memo[n] != 0)
            return memo[n];
        return memo[n] = memoHelp(n - 1, memo) + memoHelp(n - 2, memo);
    }

    /**
     * 上面已经消除了重叠子问题 但是还是存在递归和 O(n+1)的空间占用
     * 我们可以由原本的自顶向下改为自底向上
     * 并且我们只需要知道 n-1 和 n-2就可以推断出 n
     * 可以将dp数据缩减为只有两个标志
     */
    static int fibDp(int n) {
        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {// i = 1 prev = i
            //上一轮当前的 和上上轮当前的 n-1 n-2
            int sum = curr + prev;
            //上上轮变为上轮
            prev = curr;
            //上轮变为当前轮
            curr = sum;

        }
        return curr;
    }
}
