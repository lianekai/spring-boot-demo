package com.lyk.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lyk
 * @version: 1.0
 * @date 10:01
 */
public class StreamTest01 {
    public static void main(String[] args) {

        //创建一个顺序流
        List<String> list= Arrays.asList("a","b","c");
        Stream<String> stream=list.stream();
        stream.forEach(System.out::println);

        System.out.println("---------------------");

        //创建一个并行流
        Stream<String> parallelStream=list.parallelStream();
        parallelStream.forEach(System.out::println);
        System.out.println("---------------------");

        //用数组创建流
        int[] array={1,2,3,4,33,44,8};
        IntStream intStream=Arrays.stream(array);
        intStream.forEach(System.out::println);
        System.out.println("---------------------");

        //使用Stream的静态方法

        Stream<Integer> stream1=Stream.of(1,2,3,4,5,6);
        stream1.forEach(System.out::println);
        System.out.println("---------------------");


        Stream<Integer> stream2=Stream.iterate(0,(x)->x+3).limit(4);

        stream2.forEach(System.out::println);

        Stream<Double> stream3=Stream.generate(Math::random).limit(3);

        stream3.forEach(System.out::println);



    }
}
