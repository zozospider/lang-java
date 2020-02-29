package com.zozospider.java8.stream;

import com.zozospider.java8.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 查找与匹配 - 终止操作
 */
public class MatchFindStream {

    private List<Employee> employeeList = Arrays.asList(
            new Employee("Ford", 20, 30.0, Employee.Size.M),
            new Employee("Mark", 40, 40.0, Employee.Size.L),
            new Employee("Amy", 10, 10.0, Employee.Size.S),
            new Employee("Bob", 20, 20.0, Employee.Size.M),
            new Employee("Car", 40, 50.0, Employee.Size.L),
            new Employee("Bob", 20, 20.0, Employee.Size.M)
    );

    /**
     * 终止操作
     * 1. allMatch: 是否匹配所有元素 (boolean)
     * 2. anyMatch: 是否至少匹配一个元素 (boolean)
     * 3. noneMatch: 是否没有匹配任何一个元素 (boolean)
     */
    @Test
    public void match() {
        // 1
        boolean allMatch = employeeList.stream()
                .allMatch(e -> Employee.Size.S.equals(e.getSize()));
        System.out.println(allMatch);

        System.out.println("------");

        // 2
        boolean anyMatch = employeeList.stream()
                .anyMatch(e -> Employee.Size.S.equals(e.getSize()));
        System.out.println(anyMatch);

        System.out.println("------");

        // 3
        boolean noneMatch = employeeList.stream()
                .noneMatch(e -> Employee.Size.S.equals(e.getSize()));
        System.out.println(noneMatch);
    }

    /**
     * 终止操作
     * 1. 返回流中的第一个元素 (Optional)
     * 2. 返回流中的任意一个元素 (Optional)
     */
    @Test
    public void find() {
        // 1
        // Optional 调用 get() 方法取值, 但可能抛出 NoSuchElementException
        Optional<Employee> firstOptionalEmployeeA = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .findFirst();
        System.out.println(firstOptionalEmployeeA.get());

        System.out.println("------");

        // Optional 调用 orElse() 方法, 当元素为空时会返回传入参数的默认值
        Optional<Employee> firstOptionalEmployeeB = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .limit(0)
                .findFirst();
        System.out.println(firstOptionalEmployeeB.isPresent() ? firstOptionalEmployeeB.get() : new Employee("默认名称"));
        System.out.println(firstOptionalEmployeeB.orElseGet(() -> new Employee("默认名称")));
        System.out.println(firstOptionalEmployeeB.orElse(new Employee("默认名称")));

        System.out.println("------");

        // 2
        Optional<Employee> anyOptionalEmployee = employeeList.parallelStream()
                .filter(e -> Employee.Size.M.equals(e.getSize()))
                .findAny();
        System.out.println(anyOptionalEmployee.orElse(new Employee("默认名称")));
    }

    /**
     * 终止操作
     * count: 返回流中元素的总个数 (long)
     */
    @Test
    public void count() {
        long count = employeeList.stream()
                .filter(e -> Employee.Size.M.equals(e.getSize()))
                .count();
        System.out.println(count);
    }

    /**
     * 终止操作
     * 1. 返回流中元素的最大值
     * 2. 返回流中元素的最小值
     */
    @Test
    public void maxMin() {
        // 1
        Optional<Employee> maxOptionalEmployee = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge));
        System.out.println(maxOptionalEmployee.orElse(new Employee("默认名称")));

        System.out.println("------");

        Optional<Integer> minOptionalAge = employeeList.stream()
                .map(Employee::getAge)
                .min(Integer::compareTo);
        System.out.println(minOptionalAge.orElse(0));
    }

}
