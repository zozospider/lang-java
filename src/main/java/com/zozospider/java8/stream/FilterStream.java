package com.zozospider.java8.stream;

import com.zozospider.java8.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 筛选和切片
 */
public class FilterStream {

    List<Employee> employees = Arrays.asList(
            new Employee("Amy", 10, 10.0),
            new Employee("Ford", 30, 30.0),
            new Employee("Mark", 40, 40.0),
            new Employee("Bob", 20, 20.0),
            new Employee("Car", 50, 50.0),
            new Employee("Bob", 20, 20.0)
    );

    /**
     * filter: 接收 Lambda, 从流中过滤元素
     */
    @Test
    public void filter() {
        // 旧的方式 a
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee next = iterator.next();
            System.out.println("Predicate 断言年龄是否大于 20: " + next.getName());
            if (next.getAge() > 20) {
                System.out.println(next);
            }
        }

        System.out.println("------");

        // 旧的方式 b
        for (Employee employee : employees) {
            System.out.println("Predicate 断言年龄是否大于 20: " + employee.getName());
            if (employee.getAge() > 20) {
                System.out.println(employee);
            }
        }

        System.out.println("------");

        // Stream 方式 - 分开写

        // 1 创建 Stream
        Stream<Employee> stream = employees.stream();
        // 2 中间操作
        // 循环所有元素进行判断
        Stream<Employee> stream1 = stream.filter(e -> {
            System.out.println("Predicate 断言年龄是否大于 20: " + e.getName());
            return e.getAge() > 20;
        });
        // 3 终止操作
        // 输出年满足条件的元素
        stream1.forEach(System.out::println);

        System.out.println("------");

        // Stream 方式 - 连写
        employees.stream()
                .filter(e -> {
                    System.out.println("Predicate 断言年龄是否大于 20: " + e.getName());
                    return e.getAge() > 20;
                })
                .forEach(System.out::println);
    }

    /**
     * limit: 截断流, 使元素不超过限定数量, 达到限定数量后会停止循环 (limit 和 filter 方法的顺序会影响结果)
     */
    @Test
    public void limit() {
        // 多次循环, 直到找到 2 个满足条件的元素后, 结束循环
        employees.stream()
                .filter(e -> {
                    System.out.println("Predicate 断言年龄是否大于 20: " + e.getName());
                    return e.getAge() > 20;
                })
                .limit(2)
                .forEach(System.out::println);

        System.out.println("------");

        // 循环两次 (不管是否满足过滤条件) 后, 结束循环
        employees.stream()
                .limit(2)
                .filter(e -> {
                    System.out.println("Predicate 断言年龄是否大于 20: " + e.getName());
                    return e.getAge() > 20;
                })
                .forEach(System.out::println);
    }

    /**
     * skip: 跳过元素, 返回一个去掉了前 n 个元素的流
     *       若流中元素不足 n 个, 则返回一个空流
     *       与 limit(n) 互补
     */
    @Test
    public void skip() {
        // 所有满足条件的元素
        employees.stream()
                .filter(e -> e.getAge() > 20)
                .forEach(System.out::println);

        System.out.println("------");

        // 跳过前 2 个满足条件的元素
        employees.stream()
                .filter(e -> e.getAge() > 20)
                .skip(2)
                .forEach(System.out::println);

        System.out.println("------");

        // 跳过前 3 个满足条件的元素
        employees.stream()
                .filter(e -> e.getAge() > 20)
                .skip(3)
                .forEach(System.out::println);
    }

    /**
     * distinct: 去重, 通过元素的 equals() 和 hashCode() 方法判断是否重复 (必须都相等)
     */
    @Test
    public void distinct() {
        // 跳过前 1 个满足条件的元素
        employees.stream()
                .filter(e -> e.getAge() < 30)
                .skip(1)
                .forEach(System.out::println);

        System.out.println("------");

        // 跳过前 1 个满足条件的元素, 并去重剩余元素
        employees.stream()
                .filter(e -> e.getAge() < 30)
                .skip(1)
                .distinct()
                .forEach(System.out::println);
    }

}
