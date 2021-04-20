package com.blr19c.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的最大深度
 *
 * @author blr
 * @since 2021.4.20
 */
public class MaximumDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new TreeNode(new TreeNode(), new TreeNode()), new TreeNode());
        System.out.println(maxDepth(treeNode));
        System.out.println(maxDepthWhile(treeNode));
        System.out.println(maxDepthDFS(treeNode));
    }

    /**
     * BFS广度优先
     */
    static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }

    /**
     * 也可以改为循环
     */
    static int maxDepthWhile(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null)
                    continue;
                if (poll.left != null)
                    queue.add(poll.left);
                if (poll.right != null)
                    queue.add(poll.right);
            }
            count++;
        }
        return count;
    }

    /**
     * DFS深度优先
     */
    static int maxDepthDFS(TreeNode root) {
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            Integer tmp = level.pop();
            max = Math.max(tmp, max);
            if (pop.left != null) {
                stack.push(pop.left);
                level.push(tmp + 1);
            }
            if (pop.left != null) {
                stack.push(pop.right);
                level.push(tmp + 1);
            }
        }
        return max;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        TreeNode(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
}
