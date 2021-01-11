package com.lianekai.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/01/05 11:40
 */
public class StreamTest06 {
    public static void main(String[] args) {
        List<String> strings= Arrays.asList("1","2","3","3","21");
        List<String> os=strings.stream().filter(s->!"1".equals(s)).distinct().collect(Collectors.toList());
        System.out.println(os);
    }
}
