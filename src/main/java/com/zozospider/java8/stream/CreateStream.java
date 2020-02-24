package com.zozospider.java8.stream;

import com.zozospider.java8.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {

    /**
     * 创建流:
     * 1. 可以通过各集合的 stream() 或 parallelStream() 创建
     * 2. 通过 Arrays 的静态方法 stream() 创建
     * 3. 通过 Streams 的静态方法 of() 创建
     * 4. 创建无限流
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

        // 2

        // 创建一个 Employee 数组, 并转换为 Stream, 并循环打印每个元素的值
        Employee[] employees2 = new Employee[]{new Employee("Amy"), new Employee("Bob")};
        Stream<Employee> stream2 = Arrays.stream(employees2);
        stream2.forEach(System.out::println);

        System.out.println("------");

        // 3

        // 创建一个 Employee 数组, 并转换为 Stream, 并循环打印每个元素的值
        Employee[] employees3 = new Employee[]{new Employee("Amy"), new Employee("Bob")};
        Stream<Employee> stream3 = Stream.of(employees3);
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
