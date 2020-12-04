package com.lyk.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author lyk
 * @version: 1.0
 * @date 10:51
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,2,4,1,5,1,5,7);

        /**遍历输出符合条件的元素*/
        //list.stream().filter(x -> x<6).forEach(System.out::println);

        /** 匹配第一个 */
        Optional<Integer> findFirst=list.stream().filter(x -> x<5).findFirst();
        System.out.println(findFirst.get());


        System.out.println("--------------------");

        /** 匹配任意 */
        Optional<Integer> findAny=list.stream().filter(x -> x<6).findAny();
        System.out.println(findAny.get());

        System.out.println("--------------------");

        boolean anyMatch = list.stream().anyMatch(x ->x<6);
        System.out.println(anyMatch);



    }
}
