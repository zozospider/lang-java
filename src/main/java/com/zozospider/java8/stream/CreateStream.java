package com.zozospider.java8.stream;

import com.zozospider.java8.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

    /**
     * 创建流:
     * 1. 可以通过各集合的 stream() 或 parallelStream() 创建
     * 2. 通过 Arrays 的静态方法 stream() 创建
     * 3. 通过 Streams 的静态方法 of() 创建
     * 4. 创建无限流
     *
     * 注意: a. 当元素为引用类型数组时, Arrays.stream() 和 Stream.of() 创建流的效果一样.
     *             Employee[] employees = new Employee[]{new Employee("Amy"), new Employee("Bob")};
     *             Stream<Employee> employeeStream1 = Arrays.stream(employees);
     *             Stream<Employee> employeeStream2 = Stream.of(employees);
     *      b. 当元素为基本类型数组时, 建议使用 Arrays.stream(), 且返回的流为子类特定流:
     *             int[] ints = new int[]{1, 2, 3};
     *             IntStream intStream = Arrays.stream(ints);
     *      c. 当元素为 char[] 时, 需要特殊对待:
     *             char[] chars = {'a','c','e'};
     *             Stream<Character> charStream = IntStream.range(0, chars.length).mapToObj(i -> chars[i]);
     */
    @Test
    public void create() {
        // 1

        // 创建一个 Employee 集合, 并转换为 Stream, 并循环打印每个元素的值
        List<Employee> employees1a = Arrays.asList(new Employee("Amy"), new Employee("Bob"));
        Stream<Employee> stream1a = employees1a.stream();
        stream1a.forEach(System.out::println);

        System.out.println("------");

        // 创建一个 String 集合, 并转换为 Stream, 并循环打印每个元素的值
        List<String> strings1b = Arrays.asList("aaa", "bbb", "ccc");
        Stream<String> stream1b = strings1b.parallelStream();
        stream1b.forEach(System.out::println);

        System.out.println("------");

        // 注意: a. 当元素为引用类型数组时, Arrays.stream() 和 Stream.of() 创建流的效果一样.
        //          Employee[] employees = new Employee[]{new Employee("Amy"), new Employee("Bob")};
        //          Stream<Employee> streamA1 = Arrays.stream(employees);
        //          Stream<Employee> streamA2 = Stream.of(employees);
        //      b. 当元素为基本类型数组时, 建议使用 Arrays.stream(), 且返回的流为子类特定流:
        //          int[] ints = new int[]{1, 2, 3};
        //          IntStream streamB = Arrays.stream(ints);
        //      c. 当元素为 char[] 时, 需要特殊对待:
        //          char[] arr = {'a','c','e'};
        //          Stream<Character> streamC = IntStream.range(0, arr.length).mapToObj(i -> arr[i]);

        // 2

        // 创建一个 Employee 数组, 并转换为 Stream, 并循环打印每个元素的值
        Employee[] employees2a = new Employee[]{new Employee("Amy"), new Employee("Bob")};
        Stream<Employee> stream2a = Stream.of(employees2a);
        stream2a.forEach(System.out::println);

        // 创建一个 int[] 数组, 并转换为元素为 int[] 的 Stream, 此处容易产生歧义, 不推荐使用
        // 参考 3 中使用方式
        int[] intArray2b = new int[]{1, 2, 3};
        Stream<int[]> stream2b = Stream.of(intArray2b);
        stream2b.forEach(System.out::println);

        System.out.println("------");

        // 3

        // 创建一个 Employee 数组, 并转换为 Stream, 并循环打印每个元素的值
        int[] intArray3 = new int[]{1, 2, 3};
        IntStream stream3 = Arrays.stream(intArray3);
        stream3.forEach(System.out::println);

        System.out.println("------");

        // 4

        // 创建一个可无限循环迭代的 Stream, 变量从 0 开始, 每次循环加 2 后, 成为下次迭代的变量值
        // 迭代 5 次, 每次循环打印变量值
        Stream<Integer> stream4a = Stream.iterate(0, x -> x + 2);
        stream4a.limit(5)
                .forEach(System.out::println);

        System.out.println("------");

        // 创建一个可无限循环迭代的 Stream, 每次循环返回一个随机 Double 值
        // 迭代 5 次, 每次循环打印变量值
        Stream<Double> stream4b = Stream.generate(Math::random);
        stream4b.limit(5)
                .forEach(System.out::println);
    }

}
