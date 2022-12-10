package com.javaapi.test.util.math.leetcode.leetcode.editor.cn;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2332 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * * 全排列
 **/
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Permutations().new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> lists = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            int n = nums.length;
            List<Integer> list = new ArrayList<>(n);
            boolean[] used = new boolean[n];
            int count = 0;
            backtrace(list, used, count, nums);
            return lists;
        }

        public void backtrace(List<Integer> list, boolean[] used, int count, int[] nums) {
            if (count == nums.length) {
                lists.add(new ArrayList(list));
                return;
            }
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    list.add(nums[i]);
                    used[i] = true;
                    backtrace(list, used, count + 1, nums);
                    list.remove(list.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}