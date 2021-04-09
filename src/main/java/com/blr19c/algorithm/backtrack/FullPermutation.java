package com.blr19c.algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列问题
 * 给定一组数据列出所有排列方式
 *
 * @author blr
 * @since 2021.4.9
 */
public class FullPermutation {

    public static void main(String[] args) {
        permutation(new int[]{1, 2, 3});
    }

    static List<List<Integer>> res = new LinkedList<>();

    static void permutation(int[] arr) {
        backtrack(arr, new LinkedList<>());
        res.forEach(System.out::println);
    }

    static void backtrack(int[] arr, LinkedList<Integer> track) {
        if (arr.length == track.size()) {
            //已经到了最子路径 添加结果并返回
            res.add(new ArrayList<>(track));
            return;
        }
        for (int value : arr) {
            //如果已经使用过则跳过
            if (track.contains(value))
                continue;
            //选择 得出结果(进入下层树) 撤销
            track.add(value);
            backtrack(arr, track);
            track.removeLast();
        }
    }
}
