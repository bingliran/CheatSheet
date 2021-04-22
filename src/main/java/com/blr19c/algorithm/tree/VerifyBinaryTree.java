package com.blr19c.algorithm.tree;

/**
 * 验证二叉搜索树
 *
 * @author blr
 * @since 2021.4.22
 */
public class VerifyBinaryTree {

    public static void main(String[] args) {
        System.out.println(isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                Long.MIN_VALUE, Long.MAX_VALUE));
    }

    /**
     * 递归遍历二叉树
     * 每个节点一定的左节点(如果存在)一定比当前节点小
     * 每个节点一定的右节点(如果存在)一定比当前节点大
     * 左子树的最大值一定小于当前节点
     * 右子树的最小值一定大于当前节点
     */
    static boolean isValidBST(TreeNode p, long min, long max) {
        if (p == null)
            return true;
        if (p.val <= min || p.val >= max)
            return false;
        return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
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
