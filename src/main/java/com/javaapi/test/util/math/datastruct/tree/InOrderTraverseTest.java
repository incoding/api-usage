package com.javaapi.test.util.math.datastruct.tree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 参考 https://www.cnblogs.com/toone/p/8529264.html
 */
public class InOrderTraverseTest {


    @Test
    public void testInTravelsal() {

    }

    /**
     * 二叉树
     * 中序遍历
     * 递归实现
     *
     * @param root
     */
    public void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            inOrderTraverse1(root.left);
            System.out.print(root.val + "  ");
            inOrderTraverse1(root.right);
        }
    }


    /**
     * 二叉树
     * 中序遍历
     * 非递归实现
     *
     * @param root
     */
    public void inOrderTraverse2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()  
                TreeNode node = stack.pop();
                System.out.print(node.val + "  ");
                pNode = node.right;
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
