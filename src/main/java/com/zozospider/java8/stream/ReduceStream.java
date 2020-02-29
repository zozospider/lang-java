package com.zozospider.java8.stream;

import com.zozospider.java8.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceStream {

    private List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    private List<Employee> employeeList = Arrays.asList(
            new Employee("Amy", 10),
            new Employee("Ford", 30),
            new Employee("Mark", 40),
            new Employee("Bob", 20),
            new Employee("Car", 50),
            new Employee("Bob", 20)
    );

    /**
     * reduce: 将元素反复结合起来, 得到一个新值
     */
    @Test
    public void reduce() {

        // 有起始值参数, 结果不可能为空, 所以返回 Integer
        // 1 + 2 + 3 + 4 + 5 = 16
        Integer reduceSum = integerList.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduceSum);

        System.out.println("------");

        // 没有起始值参数, 结果可能为空, 所以返回 Optional
        Optional<Integer> optionalReduceSum = integerList.stream()
                .reduce(Integer::sum);
        System.out.println(optionalReduceSum.orElse(0));

        System.out.println("------");

        // 没有起始值参数, 结果可能为空, 所以返回 Optional
        Optional<Integer> optionalReduceAgeSum = employeeList.stream()
                .map(Employee::getAge)
                .reduce(Integer::sum);
        System.out.println(optionalReduceAgeSum.orElse(0));

        System.out.println("------");
    }

}
