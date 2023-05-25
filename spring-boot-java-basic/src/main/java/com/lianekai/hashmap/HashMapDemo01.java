package com.lianekai.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyk
 * @version: 1.0
 * @date 10:04
 */
public class HashMapDemo01 {
    public static void main(String[] args) {
        Map map=new HashMap<>(10);
        map.put("1","1234");
        map.put("2","1235");
        map.put("3","1236");
        map.put("4","12347");
        map.put("5","123");
        map.put("6","123");
        map.put("7","123");
        map.put("8","123");
        map.put("9","123");
        map.put("10","123");
        map.put("11","123");
        map.put("12","123");
        map.put("13","123");
        map.put("15","123");
        map.put("14","123");
        System.out.println(map.get("1"));
        System.out.println(map.get("3"));
    }
}
