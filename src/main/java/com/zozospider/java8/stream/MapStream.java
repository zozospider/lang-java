package com.zozospider.java8.stream;

import com.zozospider.java8.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapStream {

    private List<String> stringList = Arrays.asList("aaa", "bbb", "ccc");
    private List<Integer> integerList = Arrays.asList(1, 2, 3);
    private List<Employee> employeeList = Arrays.asList(
            new Employee("Amy", 10, 10.0),
            new Employee("Ford", 30, 30.0),
            new Employee("Mark", 40, 40.0),
            new Employee("Bob", 20, 20.0),
            new Employee("Car", 50, 50.0),
            new Employee("Bob", 20, 20.0)
    );

    /**
     * map: 接收 Lambda, 该 Lambda 会将每个元素转换成新元素
     */
    @Test
    public void map() {
        // 将每个元素转换成大写
        stringList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("------");

        // 将每个元素乘以 2
        integerList.stream()
                .map(i -> i * 2)
                .forEach(System.out::println);

        System.out.println("------");

        // 将每个元素转换成 name
        employeeList.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("------");

        // 测试将单个元素转换成 Stream
        toStreamCharacterOld("xxx")
                .forEach(System.out::println);

        toStreamCharacter("yyy")
                .forEach(System.out::println);

        System.out.println("------");

        // 将每个元素转换成 Stream - 分步写

        // 将 stringList 中的每个元素转换成 Stream<Character>, 得到以 Stream<Character> 为元素的 Stream
        Stream<Stream<Character>> streamStream = stringList.stream()
                .map(MapStream::toStreamCharacter);
        // 循环以 Stream<Character> 为元素的 Stream, 并输出
        streamStream.forEach(characterStream -> characterStream.forEach(System.out::println));

        System.out.println("------");

        // 将每个元素转换成 Stream - 连写
        stringList.stream()
                .map(MapStream::toStreamCharacter)
                .forEach(characterStream -> characterStream.forEach(System.out::println));
    }

    /**
     * flatMap: 接收一个 Lambda, 将流中的每个元素进行转换, 并将转换后的所有元素平铺成一个新的 Stream
     */
    @Test
    public void flatMap() {
        List<String> stringList = Arrays.asList("aaa", "bbb", "ccc");

        // 将每个元素转换成字符 Stream, 并对多个元素对应的 Stream 列表元素进行平铺, 组成一个新的 Stream
        stringList.stream()
                .flatMap(MapStream::toStreamCharacter)
                .forEach(System.out::println);

        System.out.println("------");

        // Test
        //   map 转换后的元素组成方式, 类似 List 的 add() 方法
        //   flatMap 转换的元素组成方式, 类似 List 的 addAll() 方法
        List<Object> stringListTest = new ArrayList<>();
        stringListTest.add(Arrays.asList("a", "a", "a"));
        stringListTest.add(Arrays.asList("b", "b", "b"));
        stringListTest.add(Arrays.asList("c", "c", "c"));
        stringListTest.addAll(Arrays.asList("a", "a", "a"));
        stringListTest.addAll(Arrays.asList("b", "b", "b"));
        stringListTest.addAll(Arrays.asList("c", "c", "c"));
        System.out.println(stringListTest);
    }

    /**
     * 将 String 的每个字符转换成数组, 并转换成 Stream
     */
    private static Stream<Character> toStreamCharacterOld(String s) {
        List<Character> characterList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            characterList.add(c);
        }
        return characterList.stream();
    }

    /**
     * 将 String 的每个字符转换成数组, 并转换成 Stream
     */
    private static Stream<Character> toStreamCharacter(String s) {
        char[] chars = s.toCharArray();
        return IntStream.range(0, chars.length).mapToObj(i -> chars[i]);
    }

}
