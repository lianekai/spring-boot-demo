package com.lyk.stream.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author lyk
 * @version: 1.0
 * @date 19:17
 */
public class StreamTest04 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(7,8,2,1,9,3,4,1,4);
        long count=list.stream().filter(x->x>6).count();
        System.out.println("list中大于6元素的个数"+count);
    }
}
