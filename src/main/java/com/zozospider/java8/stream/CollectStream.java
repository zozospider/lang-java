package com.zozospider.java8.stream;

import com.zozospider.java8.entity.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * collect: 终止操作
 */
public class CollectStream {

    private List<Employee> employeeList = Arrays.asList(
            new Employee("Ford", 20, 30.0, Employee.Size.M),
            new Employee("Mark", 40, 40.0, Employee.Size.L),
            new Employee("Amy", 10, 10.0, Employee.Size.S),
            new Employee("Bob", 20, 20.0, Employee.Size.M),
            new Employee("Car", 40, 50.0, Employee.Size.L),
            new Employee("Bob", 20, 20.0, Employee.Size.M)
    );

    /**
     * collect: 将流转换成其他形式, 接收一个 Collector 接口实现
     */
    @Test
    public void collect() {

        // 将每个元素转换成 name, 并将流转换成 List 对象
        List<String> collectNameList = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        collectNameList.forEach(System.out::println);

        System.out.println("------");

        // 将每个元素转换成 name, 并将流转换成 Set 对象
        Set<String> collectNameSet = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        collectNameSet.forEach(System.out::println);

        System.out.println("------");

        // 将每个元素转换成 name, 并将流转换成 HashSet 对象
        HashSet<String> collectNameHashSet = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        collectNameHashSet.forEach(System.out::println);

        System.out.println("------");
    }

    /**
     * collect 求总数, 总和, 平均值, 最大值, 最小值
     */
    @Test
    public void collectMath() {
        // 总数
        // a
        Long collectCountA = employeeList.stream()
                .collect(Collectors.counting());
        // b
        Long collectCountB = employeeList.stream().count();
        // c
        int collectCountC = employeeList.size();
        // d
        Optional<Integer> reduceSum = employeeList.stream()
                .map(e -> 1)
                .reduce(Integer::sum);
        System.out.println(collectCountA);
        System.out.println(collectCountB);
        System.out.println(collectCountC);
        System.out.println(reduceSum);

        // 总和
        // a
        Integer collectSumA = employeeList.stream()
                .collect(Collectors.summingInt(Employee::getAge));
        // b
        Integer collectSumB = employeeList.stream().mapToInt(Employee::getAge).sum();
        System.out.println(collectSumA);
        System.out.println(collectSumB);

        // 平均值
        Double collectAverage = employeeList.stream()
                .collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(collectAverage);

        // 最大值
        Optional<Employee> collectMax = employeeList.stream()
                .collect(Collectors.maxBy((e1, e2) -> {
                    return Integer.compare(e1.getAge(), e2.getAge());
                }));
        System.out.println(collectMax.orElse(new Employee("默认名称")));

        // 最小值
        // a
        Optional<Employee> collectMinA = employeeList.stream()
                .collect(Collectors.minBy((e1, e2) -> {
                    return Integer.compare(e1.getAge(), e2.getAge());
                }));
        // b
        Optional<Employee> collectMinB = employeeList.stream()
                .min((e1, e2) -> {
                    return Integer.compare(e1.getAge(), e2.getAge());
                });
        // c
        Optional<Employee> collectMinC = employeeList.stream()
                .min(Comparator.comparingInt(Employee::getAge));

        System.out.println(collectMinA.orElse(new Employee("默认名称")));
        System.out.println(collectMinB.orElse(new Employee("默认名称")));
        System.out.println(collectMinC.orElse(new Employee("默认名称")));
    }

    /**
     * 统一统计
     */
    @Test
    public void collectSummary() {
        IntSummaryStatistics intSummaryStatistics = employeeList.stream()
                .collect(Collectors.summarizingInt(Employee::getAge));
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getSum());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
    }

    /**
     * collect 分组
     */
    @Test
    public void collectGroup() {
        // 一级分组
        // A: 按照 Size 分组
        Map<Employee.Size, List<Employee>> collectSizeMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getSize));
        System.out.println(collectSizeMap);

        System.out.println("------");

        // B: 按照 Age 对应的年龄段字符串分组
        Map<String, List<Employee>> collectAgeMap = employeeList.stream()
                .collect(Collectors.groupingBy(e -> {
                    if (e.getAge() < 20) {
                        return "青年";
                    } else if (e.getAge() < 40) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                }));
        System.out.println(collectAgeMap);

        System.out.println("------");

        // 二级分组
        // A: 先按照 Size 分组, 再按照 Age 分组
        Map<Integer, Map<Integer, List<Employee>>> collectSizeAgeMapA = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(Employee::getAge)));
        System.out.println(collectSizeAgeMapA);

        System.out.println("------");

        // B: 先按照 Size 分组, 再按照 Age 对应的年龄段字符串分组
        Map<Employee.Size, Map<String, List<Employee>>> collectSizeAgeMapB = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getSize, Collectors.groupingBy(e -> {
                    if (e.getAge() < 20) {
                        return "青年";
                    } else if (e.getAge() < 40) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(collectSizeAgeMapB);
    }

    /**
     * collect 分区
     */
    @Test
    public void collectPartition() {
        // 满足条件的一个区, 不满足条件的另一个区
        Map<Boolean, List<Employee>> collectSizeMap = employeeList.stream()
                .collect(Collectors.groupingBy(e -> Employee.Size.S.equals(e.getSize())));
        System.out.println(collectSizeMap);
    }

    /**
     * collect 连接
     */
    @Test
    public void collectJoin() {
        // 连接 name
        String collectNameJoinA = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining());
        System.out.println(collectNameJoinA);

        System.out.println("------");

        // 连接 name, 且以 | 分割
        String collectNameJoinB = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("|"));
        System.out.println(collectNameJoinB);

        System.out.println("------");

        // 连接 name, 且以 | 分割, 以 [ 开头, ] 结尾
        String collectNameJoinC = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("|", "[", "]"));
        System.out.println(collectNameJoinC);
    }

}
