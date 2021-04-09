package com.blr19c.algorithm.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 皇后问题
 * 一个 n*n的棋盘每一行放置n个皇后 皇后之间彼此不能互相攻击
 * 列出所有摆放方式
 *
 * @author blr
 * @since 2021.4.9
 */
public class Queens {

    public static void main(String[] args) {
        solveQueens(4);
        res.clear();
        System.out.println("==========================");
        solveQueens(8);
    }

    static List<char[][]> res = new LinkedList<>();

    static void solveQueens(int n) {
        //初始化棋盘 皇后用 "Q" 表示,棋盘用 "." 表示
        char[][] checkerboard = new char[n][n];
        for (char[] chars : checkerboard)
            Arrays.fill(chars, '.');
        backtrack(checkerboard, 0);
        for (char[][] l : res) {
            Arrays.asList(l).forEach(System.out::println);
            System.out.println("--------------------------");
        }
    }

    static void backtrack(char[][] checkerboard, int index) {
        //下标 index == size 已经放置完最后一个皇后 保存并返回
        if (checkerboard.length == index) {
            //二维数组拷贝
            res.add(Arrays.stream(checkerboard).map(char[]::clone).toArray(char[][]::new));
            return;
        }
        //遍历棋盘index行的整列
        int n = checkerboard[index].length;
        for (int i = 0; i < n; i++) {
            //有冲突的皇后跳过
            if (!isValid(checkerboard, index, i))
                continue;
            //选择 得出结果(进入下层树) 撤销
            checkerboard[index][i] = 'Q';
            backtrack(checkerboard, index + 1);
            checkerboard[index][i] = '.';
        }
    }

    /**
     * 返回false时说明 在该位置放置皇后会被攻击
     * 事实上只需要检测 当前位置的 上方/左上方/右上方
     * 因为此时下方均未放置任何皇后而同一排仅能放置一个皇后
     *
     * @param row    当前行
     * @param column 当前列
     */
    static boolean isValid(char[][] checkerboard, int row, int column) {
        //检查当前列有无皇后
        for (int i = 0; i < row; i++) {
            if (checkerboard[i][column] == 'Q')
                return false;
        }
        //检查左上方有无皇后
        for (int i = column - 1, j = row - 1; i >= 0 && j >= 0; i--, j--) {
            if (checkerboard[j][i] == 'Q')
                return false;
        }
        //检查右上方有无皇后
        for (int i = column + 1, j = row - 1, size = checkerboard.length; i < size && j >= 0; i++, j--) {
            if (checkerboard[j][i] == 'Q')
                return false;
        }
        return true;
    }
}
