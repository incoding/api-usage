package com.javaapi.test.util.number.number;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by user on 18/4/19
 */
public class NumberUtil {

    /**
     * 从 0 到 n 之间选 k 个不重复的数组成一个序列
     */
    public static Set<Integer> noRepeat(int n, int k){
        Set<Integer> noRepeat = new HashSet<>();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = i;
        }
//开始随机 k 个不重复数出来
        for (int i = 0; i < k; i++) {
            Random random = new Random();
            // t : i 至 n 的随机数
            // 目的：不再随机出已置换出去 的数 的下标
            int t = random.nextInt(n - i) + i;
            // 交换x[i]，x[t]的值
            swap(x, i, t);
            noRepeat.add(x[i]);
        }
        return noRepeat;
    }

    /**
     *  从指定keys里获取num个不重复数字
     * @param keys
     * @param num
     * @return
     */
    public static Set<String> getNoRepetString(Set<String> keys, int num) {
        if (CollectionUtils.isEmpty(keys)) {
            return keys;
        }
        int size = keys.size();
        if (size <= num) {
            return keys;
        }
        Set<Integer> integers = noRepeat(size, num);
        List<String> result = Lists.newArrayList(keys);
        Set<String> noRepeatSet = Sets.newHashSet();
        for (Integer noRepeatNum : integers) {
            noRepeatSet.add(result.get(noRepeatNum));
        }
        return noRepeatSet;
    }

    private static void swap(int[] x, int i, int t) {
        int temp = x[i];
        x[i] = x[t];
        x[t] = temp;
    }
}
