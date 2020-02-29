package com.zozospider.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapStream2 {

    /**
     * flatMap: 接收一个 Lambda, 将流中的每个元素进行转换, 并将转换后的所有元素平铺成一个新的 Stream
     */
    @Test
    public void flatMap() {
        List<String> stringList = Arrays.asList("aaa", "bbb", "ccc");

        // 将每个元素转换成字符 Stream, 并对多个元素对应的 Stream 列表元素进行平铺, 组成一个新的 Stream
        stringList.stream()
                .flatMap(MapStream2::toCharacterStream)
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

    private static Stream<Character> toCharacterStream(String s) {
        List<Character> characterList = new ArrayList<>();

        for (char c : s.toCharArray()) {
            characterList.add(c);
        }
        return characterList.stream();
    }

}
