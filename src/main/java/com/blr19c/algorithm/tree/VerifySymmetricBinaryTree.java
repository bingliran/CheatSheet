package com.blr19c.algorithm.tree;

/**
 * 验证一个二叉树是不是镜像对称二叉树
 *
 * @author blr
 * @since 2021.5.17
 */
public class VerifySymmetricBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        System.out.println(isSymmetric(root.left, root.right));
    }

    static boolean isSymmetric(TreeNode left, TreeNode right) {
        //如果是叶子节点
        if (left == null && right == null)
            return true;
        //如果其中一个为null或者不对称 其中一个为null一定不对称
        if (left == null || right == null || left.val != right.val)
            return false;
        //对比子节点是否对称
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
