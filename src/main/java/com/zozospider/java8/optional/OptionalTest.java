package com.zozospider.java8.optional;

import com.zozospider.java8.entity.Employee;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    private Employee employee = new Employee("Amy");

    /**
     * Optional.ofNullable(T t): 若 t 不为 null 则创建 Optional 实例, 否则创建空的 Optional 实例 (推荐)
     */
    @Test
    public void optionalCreate() {

        // 创建一个空的 Optional 实例
        Optional<Employee> optionalEmployee1 = Optional.empty();
        System.out.println(optionalEmployee1);

        System.out.println("------");

        // 创建一个 Optional 实例 (如果传入的 t 为 null, 会报空指针异常)
        Optional<Employee> optionalEmployee2 = Optional.of(employee);
        System.out.println(optionalEmployee2);

        System.out.println("------");

        // 若 t 不为 null 则创建 Optional 实例, 否则创建空的 Optional 实例 (推荐)
        Optional<Employee> optionalEmployee3 = Optional.ofNullable(employee);
        System.out.println(optionalEmployee3);

        System.out.println("------");

        // 将 Optional 对象通过 map() 转换成另一个 Optional 对象
        Optional<String> optionalSa = optionalEmployee3.map(Employee::getName);
        System.out.println(optionalSa);

        System.out.println("------");

        Optional<String> optionalSb = optionalEmployee3.flatMap(e -> Optional.ofNullable(e.getName()));
        System.out.println(optionalSb);
    }

    /**
     * optional.orElseGet(Lambda lambda): 如果 Optional 对象不为空则返回 t 对象, 否则返回传入的默认 Lambda 返回对象 (推荐)
     */
    @Test
    public void optionalGet() {
        Optional<Employee> optionalEmployee = Optional.ofNullable(employee);

        // 判断 Optional 对象元素是否存在
        System.out.println(optionalEmployee.isPresent());

        System.out.println("------");

        // 获取 t 对象 (如果 Optional 对象为空, 会报 NoSuchElementException)
        Employee employee1 = optionalEmployee.get();
        System.out.println(employee1);

        System.out.println("------");

        // 如果 Optional 对象不为空则返回 t 对象, 否则返回传入的默认 t
        Employee employee2 = optionalEmployee.orElse(new Employee("默认名称"));
        System.out.println(employee2);

        System.out.println("------");

        // 如果 Optional 对象不为空则返回 t 对象, 否则返回传入的默认 Lambda 返回对象 (推荐)
        Employee employee3 = optionalEmployee.orElseGet(() -> {
            System.out.println("do something");
            return new Employee("默认名称");
        });
        System.out.println(employee3);
    }

}
