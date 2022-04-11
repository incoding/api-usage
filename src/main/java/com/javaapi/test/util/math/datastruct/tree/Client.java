package com.javaapi.test.util.math.datastruct.tree;

import org.junit.Test;

public class Client {
    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        System.out.println("before = " + treeNode.left.val + " " + treeNode.right.val);
        revert(treeNode.left, treeNode.right);
        System.out.println("after = " + treeNode.left.val + " " + treeNode.right.val);
    }

    /**
     * 正确
     */
    @Test
    public void test2() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        System.out.println("before2 = " + treeNode.left.val + " " + treeNode.right.val);
        revert2(treeNode);
        System.out.println("after2 = " + treeNode.left.val + " " + treeNode.right.val);
    }


    public void revert(TreeNode left, TreeNode right) {
        TreeNode node = left;
        left = right;
        right = node;
    }

    public void revert2(TreeNode root) {
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
