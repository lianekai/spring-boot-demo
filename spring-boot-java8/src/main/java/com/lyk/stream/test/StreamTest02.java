package com.lyk.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lyk
 * @version: 1.0
 * @date 15:17
 */
public class StreamTest02 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(6,5,1,4,4,4,7,78);
        Stream<Integer> stream=list.stream();
        stream.filter(x -> x>=7).forEach(System.out::println);
    }
}
