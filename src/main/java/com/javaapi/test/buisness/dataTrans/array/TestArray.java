package com.javaapi.test.buisness.dataTrans.array;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * http://www.cnblogs.com/chenssy/p/3466092.html
 * 不错
 * 所以在性能要求较高的场景中请优先考虑数组。</br>
 * java 中把数组也当做对象来用
 */
public class TestArray {


    @Test
    public void test() {
        int[] a = new int[5];
        System.out.println(a.toString());
        System.out.println(Arrays.toString(a));
    }

    /**
     * System.arraycopy 不会有任何附加功能.所以有可能产生越界等异常
     */
    @Test
    public void testSystemArrayCopy() {
        int[] ids = {1, 2, 3, 4, 5};
        int[] id2 = {2, 3, 4, 5, 6, 8};
        System.arraycopy(ids, 0, id2, 0, ids.length);
        System.out.println(Arrays.toString(ids));
        System.out.println(Arrays.toString(id2));
    }

    /**
     * 注意 目的数组得长度不要越界
     */
    @Test
    public void testSystemArray() {
        int[] ids = {1, 2, 3, 4, 5, 9};
        int[] id2 = {2, 3, 4, 5, 6, 8};
        System.arraycopy(ids, 0, id2, 0, ids.length);
        System.out.println(Arrays.toString(ids));
        System.out.println(Arrays.toString(id2));
    }

    @Test
    public void testArraysCopy() {
        int[] ids = {1, 2, 3, 4, 5, 9};
        int[] afterCopy = Arrays.copyOf(ids, 20);
        System.out.println(Arrays.toString(afterCopy));
    }

    @Test
    public void testArraysSortStringWrong() {
        String[] strArr = {"0", "4", "2", "5", "3", "10", "1024"};
        Arrays.sort(strArr);
        System.out.println(Arrays.asList(strArr));
    }

    @Test
    public void testArraysSortString() {
        String[] strArr = {"0", "4", "2", "5", "3", "10", "1024"};
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int parseInt = Integer.parseInt(o1);
                int parseInt2 = Integer.parseInt(o2);
                return parseInt - parseInt2;
            }
        });
        System.out.println(Arrays.asList(strArr));
    }

    @Test
    public void testArraysSortString2() {
        String paramsForUpload = "dc_spf?136,139,142?3,1,0?";
        String[] strArr = paramsForUpload.split("\\?");
        String[] raceNoArr = strArr[1].trim().split(",");
        Arrays.sort(raceNoArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int parseInt = Integer.parseInt(o1);
                int parseInt2 = Integer.parseInt(o2);
                return parseInt - parseInt2;
            }
        });
        System.out.println(StringUtils.join(raceNoArr, ","));

    }

    @Test
    public void testSortObject() {

        List<PolicyTimePartFee> list = new ArrayList<>();
        PolicyTimePartFee e1 = new PolicyTimePartFee();
        e1.setMinHours("Min");
        e1.setMaxHours("-2");
        PolicyTimePartFee e2 = new PolicyTimePartFee();
        e2.setMinHours("-2");
        e2.setMaxHours("Max");
        PolicyTimePartFee e3 = new PolicyTimePartFee();
        e3.setMinHours("Min");
        e3.setMaxHours("-24");


        list.add(e2);
        list.add(e3);
        list.add(e1);
        Collections.sort(list, new Comparator<PolicyTimePartFee>() {
            @Override
            public int compare(PolicyTimePartFee o1, PolicyTimePartFee o2) {
                Integer min1 = getMIn(o1.getMinHours());
                Integer min2 = getMIn(o2.getMinHours());
                return min1.compareTo(min2);
            }

            private Integer getMIn(String minHours) {
                Integer min ;
                if("min".equalsIgnoreCase(minHours)){
                    min = Integer.MIN_VALUE;
                    return min;
                }
                try {
                    min = Integer.valueOf(minHours);
                } catch (NumberFormatException e) {
                    min = Integer.MIN_VALUE;
                }
                return min;
            }
        });
        for (PolicyTimePartFee policyTimePartFee : list) {
            System.out.println("policyTimePartFee = " + policyTimePartFee);
        }
    }

    public static class PolicyTimePartFee {
        /**
         * 最小时间 允许是任意实数和“Min”
         */
        private String minHours;
        /**
         * 最大时间 允许是任意实数和“Max”
         */
        private String maxHours;
        /**
         * 需要花费多少钱  单位为元
         */
        private String cost;
        /**
         * 免费次数
         */
        private int freeTimes;

        public String getMinHours() {
            return minHours;
        }

        public void setMinHours(String minHours) {
            this.minHours = minHours;
        }

        public String getMaxHours() {
            return maxHours;
        }

        public void setMaxHours(String maxHours) {
            this.maxHours = maxHours;
        }

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public int getFreeTimes() {
            return freeTimes;
        }

        public void setFreeTimes(int freeTimes) {
            this.freeTimes = freeTimes;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PolicyTimePartFee that = (PolicyTimePartFee) o;

            if (freeTimes != that.freeTimes) return false;
            if (minHours != null ? !minHours.equals(that.minHours) : that.minHours != null) return false;
            if (maxHours != null ? !maxHours.equals(that.maxHours) : that.maxHours != null) return false;
            return cost != null ? cost.equals(that.cost) : that.cost == null;
        }

        @Override
        public int hashCode() {
            int result = minHours != null ? minHours.hashCode() : 0;
            result = 31 * result + (maxHours != null ? maxHours.hashCode() : 0);
            result = 31 * result + (cost != null ? cost.hashCode() : 0);
            result = 31 * result + freeTimes;
            return result;
        }

        @Override
        public String toString() {
            return "PolicyTimePartFee{" +
                    "minHours='" + minHours + '\'' +
                    ", maxHours='" + maxHours + '\'' +
                    ", cost='" + cost + '\'' +
                    ", freeTimes=" + freeTimes +
                    '}';
        }
    }
}
