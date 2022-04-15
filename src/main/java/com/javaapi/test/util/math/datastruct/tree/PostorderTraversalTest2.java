package com.javaapi.test.util.math.datastruct.tree;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 参考 https://www.cnblogs.com/toone/p/8529264.html
 * <p>
 * 后续遍历要考虑2种场景,一种是右节点是null,另一种是右节点已经被访问过了
 */
public class PostorderTraversalTest2 {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode init = solution.init();
        List<Integer> integers = solution.method1(init);
        System.out.println("integers = " + integers);
        Assert.assertArrayEquals(integers.toArray(new Integer[integers.size()]), new Integer[]{1, 3, 2, 5, 7, 6, 4});
    }


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


        public List<Integer> method1(TreeNode root) {
            List<Integer> ans = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode prev = null;
            //主要思想：
            //由于在某颗子树访问完成以后，接着就要回溯到其父节点去
            //因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，上一个访问的节点是否为右子树
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                //从栈中弹出的元素，左子树一定是访问完了的
                root = stack.pop();
                //现在需要确定的是是否有右子树，或者右子树是否访问过
                //如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
                //说明可以访问当前节点
                if (root.right == null || prev == root.right) {
                    ans.add(root.val);
                    //更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                    prev = root;
                    root = null;
                } else {
                    //如果右子树没有被访问，那么将当前节点压栈，访问右子树
                    stack.push(root);
                    root = root.right;
                }
            }
            return ans;
        }

        public TreeNode init() {
            TreeNode treeNode1 = new TreeNode(1);
            TreeNode treeNode3 = new TreeNode(3);
            TreeNode treeNode5 = new TreeNode(5);
            TreeNode treeNode7 = new TreeNode(7);
            TreeNode treeNode6 = new TreeNode(6, treeNode5, treeNode7);
            TreeNode treeNode2 = new TreeNode(2, treeNode1, treeNode3);
            TreeNode treeNode4 = new TreeNode(4, treeNode2, treeNode6);
            return treeNode4;
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
