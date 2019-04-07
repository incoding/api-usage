package com.javaapi.test.test.javafeature.version8.streams.streamcollect;

import org.junit.Test;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Mutable reduction
 A mutable reduction operation accumulates input elements into a mutable result container, such as a Collection or StringBuilder, as it processes the elements in the stream.
 If we wanted to take a stream of strings and concatenate them into a single long string, we could achieve this with ordinary reduction:
 String concatenated = strings.reduce("", String::concat)

 We would get the desired result, and it would even work in parallel. However, we might not be happy about the performance! Such an implementation would do a great deal of string copying, and the run time would be O(n^2) in the number of characters. A more performant approach would be to accumulate the results into a StringBuilder, which is a mutable container for accumulating strings. We can use the same technique to parallelize mutable reduction as we do with ordinary reduction.
 The mutable reduction operation is called collect(), as it collects together the desired results into a result container such as a Collection. A collect operation requires three functions: a supplier function to construct new instances of the result container, an accumulator function to incorporate an input element into a result container, and a combining function to merge the contents of one result container into another. The form of this is very similar to the general form of ordinary reduction:
 <R> R collect(Supplier<R> supplier,
 BiConsumer<R, ? super T> accumulator,
 BiConsumer<R, R> combiner);

 As with reduce(), a benefit of expressing collect in this abstract way is that it is directly amenable to parallelization: we can accumulate partial results in parallel and then combine them, so long as the accumulation and combining functions satisfy the appropriate requirements. For example, to collect the String representations of the elements in a stream into an ArrayList, we could write the obvious sequential for-each form:
 ArrayList<String> strings = new ArrayList<>();
 for (T element : stream) {
 strings.add(element.toString());
 }

 Or we could use a parallelizable collect form:
 ArrayList<String> strings = stream.collect(() -> new ArrayList<>(),
 (c, e) -> c.add(e.toString()),
 (c1, c2) -> c1.addAll(c2));

 or, pulling the mapping operation out of the accumulator function, we could express it more succinctly as:
 List<String> strings = stream.map(Object::toString)
 .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

 Here, our supplier is just the ArrayList constructor, the accumulator adds the stringified element to an ArrayList, and the combiner simply uses addAll to copy the strings from one container into the other.
 The three aspects of collect -- supplier, accumulator, and combiner -- are tightly coupled. We can use the abstraction of a Collector to capture all three aspects. The above example for collecting strings into a List can be rewritten using a standard Collector as:
 List<String> strings = stream.map(Object::toString)
 .collect(Collectors.toList());

 Packaging mutable reductions into a Collector has another advantage: composability. The class Collectors contains a number of predefined factories for collectors, including combinators that transform one collector into another. For example, suppose we have a collector that computes the sum of the salaries of a stream of employees, as follows:
 Collector<Employee, ?, Integer> summingSalaries
 = Collectors.summingInt(Employee::getSalary);

 (The ? for the second type parameter merely indicates that we don't care about the intermediate representation used by this collector.) If we wanted to create a collector to tabulate the sum of salaries by department, we could reuse summingSalaries using groupingBy:
 Map<Department, Integer> salariesByDept
 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
 summingSalaries));

 As with the regular reduction operation, collect() operations can only be parallelized if appropriate conditions are met. For any partially accumulated result, combining it with an empty result container must produce an equivalent result. That is, for a partially accumulated result p that is the result of any series of accumulator and combiner invocations, p must be equivalent to combiner.apply(p, supplier.get()).
 Further, however the computation is split, it must produce an equivalent result. For any input elements t1 and t2, the results r1 and r2 in the computation below must be equivalent:
 A a1 = supplier.get();
 accumulator.accept(a1, t1);
 accumulator.accept(a1, t2);
 R r1 = finisher.apply(a1);  // result without splitting

 A a2 = supplier.get();
 accumulator.accept(a2, t1);
 A a3 = supplier.get();
 accumulator.accept(a3, t2);
 R r2 = finisher.apply(combiner.apply(a2, a3));  // result with splitting

 Here, equivalence generally means according to Object.equals(Object). but in some cases equivalence may be relaxed to account for differences in order.
 */
public class ClientCollect {


    /**
     *    1 将list里的元素拆分成  N个list分片,    其中每个分片应用accumulater的方法
     *    2 N个list分片 合成一个大list, 其中合成方法使用combiner 的方法
     */
    @Test
    public void testCollect() {
        List<String> result = Lists.newArrayList("a", "b", "c", "d");
        List<String> asList = result.stream().collect(ArrayList::new, ArrayList::add,
                ArrayList::addAll);
        System.out.println("concat = " + asList);
    }


    @Test
    public void testCollect2() {
        List<String> result = Lists.newArrayList("a", "b", "c", "d");
        String concat = result.stream().collect(StringBuilder::new, StringBuilder::append,
                StringBuilder::append).toString();
        System.out.println("concat = " + concat);
    }
}
