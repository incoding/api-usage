package com.javaapi.test.util.math.datastruct.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 参考 https://www.cnblogs.com/toone/p/8529264.html
 */
public class PostorderTraversalTest {


    /**
     * 二叉树
     * 后序遍历
     * 递归实现
     *
     * @param root
     * @return
     */
    public void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.print(root.val + "  ");
        }
    }


    public class Solution {

        /**
         * 二叉树
         * 后序遍历
         * 非递归实现
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> list = new LinkedList<>();
            TreeNode lastVisited = null;
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    TreeNode node = stack.peek();
                    if (node.right != null && lastVisited != node.right) {
                        root = node.right;
                    } else {
                        list.add(node.val);
                        lastVisited = stack.pop();
                    }
                }
            }
            return list;
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
