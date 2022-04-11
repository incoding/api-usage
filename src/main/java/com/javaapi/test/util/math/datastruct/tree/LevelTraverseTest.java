package com.javaapi.test.util.math.datastruct.tree;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 参考 https://www.cnblogs.com/toone/p/8529264.html
 */
public class LevelTraverseTest {

    @Test
    public void testLevelTraverse() {


    }

    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "  ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
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
