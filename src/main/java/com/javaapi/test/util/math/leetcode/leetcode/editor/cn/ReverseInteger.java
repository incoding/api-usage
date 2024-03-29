package com.javaapi.test.util.math.leetcode.leetcode.editor.cn;
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 3116 👎 0

/**
 * * 整数反转
 **/
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println("solution = " + solution.reverse(53421));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int reverse = 0;
            while (x != 0) {
                if (reverse < Integer.MIN_VALUE / 10 || reverse > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int tail = x % 10;
                x = x / 10;
                reverse = reverse * 10 + tail;
            }
            return reverse;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}