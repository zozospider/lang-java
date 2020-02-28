package com.zozospider.java8.stream;

import com.zozospider.java8.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * sorted: 中间操作 - 排序
 */
public class SortedStream {

    List<String> stringList = Arrays.asList("aaa", "ccc", "bbb");
    List<Employee> employeeList = Arrays.asList(
            new Employee("Amy", 10, 10.0),
            new Employee("Ford", 20, 30.0),
            new Employee("Mark", 40, 40.0),
            new Employee("Bob", 20, 20.0),
            new Employee("Car", 40, 50.0),
            new Employee("Bob", 20, 20.0)
    );

    /**
     * 中间操作
     */
    @Test
    public void sorted() {
        // 默认使用当前元素类型的排序功能 (实现了 Comparable 接口)
        stringList.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("------");

        // 如果元素是自定义类, 可以通过实现 Comparable 接口, 自定义元素的默认排序逻辑
        // 案例: 略

        System.out.println("------");

        // Lambda 定义当前排序逻辑
        // 先按照年龄升序, 再按薪资升序
        employeeList.stream()
                .sorted((e1, e2) -> {
                    if (e1.getAge() > e2.getAge()) {
                        return 1;
                    } else if (e1.getAge() < e2.getAge()) {
                        return -1;
                    } else {
                        return Double.compare(e1.getSalary(), e2.getSalary());
                    }
                })
                .forEach(System.out::println);
    }

}
