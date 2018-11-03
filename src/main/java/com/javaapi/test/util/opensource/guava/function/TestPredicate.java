package com.javaapi.test.util.opensource.guava.function;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 17/8/9.
 */
public class TestPredicate {
    @Test
    public void testAnd() {
        Predicate<Integer> predicat1 = new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                if (input == 1) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean equals(Object object) {
                return false;
            }
        };

        Predicate<Integer> predicate2 = new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                if (input == 2) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean equals(Object object) {
                return false;
            }
        };

        Predicate<Integer> and = Predicates.and(predicat1, predicate2);
        boolean apply = and.apply(1);
        System.out.println("apply = " + apply);

    }

    @Test
    public void doThenTest() {
        Predicates.compose(new Predicate<Object>() {

            @Override
            public boolean apply(Object input) {
                return false;
            }
        }, new Function<Object, Object>() {
            @Override
            public Object apply(Object input) {
                return null;
            }
        });
    }

    @Test
    public void testIfThen(){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        Iterator<Integer> iterator = list.iterator();
        Integer nihao = 1;
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                return input == 1;
            }

            @Override
            public boolean equals(Object object) {
                return false;
            }
        };

        Function<Iterator<Integer>, Boolean> function = new Function<Iterator<Integer>, Boolean>() {
            @Override
            public Boolean apply(Iterator<Integer> input) {
                Integer next = input.next();
                if (predicate.apply(next)) {
                    input.remove();
                }
                return null;
            }

            @Override
            public boolean equals(Object object) {
                return false;
            }
        };

        while (iterator.hasNext()) {
            function.apply(iterator);
        }
        System.out.println("list = " + list);



    }
}
