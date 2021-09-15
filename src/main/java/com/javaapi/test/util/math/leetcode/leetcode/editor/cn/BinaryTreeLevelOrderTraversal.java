package com.javaapi.test.util.math.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * * //给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * //
 * //
 * //
 * // 示例：
 * //二叉树：[3,9,20,null,null,15,7],
 * //
 * //
 * //    3
 * //   / \
 * //  9  20
 * //    /  \
 * //   15   7
 * //
 * //
 * // 返回其层序遍历结果：
 * //
 * //
 * //[
 * //  [3],
 * //  [9,20],
 * //  [15,7]
 * //]
 * //
 * // Related Topics 树 广度优先搜索 二叉树
 * // 👍 1012 👎 0
 * <p>
 * * 二叉树的层序遍历
 **/
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            //[,76,5,4,3,2,1]
            if (root == null) {
                return result;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    levelList.add(treeNode.val);

                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                result.add(levelList);
            }
            return result;
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
//leetcode submit region end(Prohibit modification and deletion)

}