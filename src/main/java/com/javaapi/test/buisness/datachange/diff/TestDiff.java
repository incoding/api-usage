package com.javaapi.test.buisness.datachange.diff;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.ValueChange;
import org.junit.Test;

import static org.javers.core.diff.ListCompareAlgorithm.LEVENSHTEIN_DISTANCE;

/**
 * Created by user on 2020/12/27.
 */
public class TestDiff {

    /**
     * 校验参数是否改动,避免后续产生额外操作.
     * <p>
     * 更新前发现变动对象,值没变动就不会进行后续操作进行
     * 排除新数据是null的,
     * 1 vo当做参数,前端未更新的值会传进来,(ps 可以使用新建可更新的参数对象,避免)
     * 2 实际到数据库因为是mybatis的 selective操作,是null不会改变,
     */
    @Test
    public void testDiff() {
        Javers javers = JaversBuilder.javers()
                                     .withListCompareAlgorithm(LEVENSHTEIN_DISTANCE)
                                     .build();
        PledgeDO pledgeOld = new PledgeDO("1", "2");
        PledgeDO pledgeNew = new PledgeDO(null, "2");
        Diff compare = javers.compare(pledgeOld, pledgeNew);
        System.out.println("compare.prettyPrint() = " + compare.prettyPrint());
        int size = compare.getChanges(change -> {
            ValueChange valueChange = (ValueChange) change;
            if (valueChange.getRight() == null) {
                return false;
            }
            return true;
        }).size();
        System.out.println("size = " + size);

    }
}
