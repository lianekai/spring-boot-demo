package com.lyk.hashmap;

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
        map.put("1","123");
        System.out.println(map.get("1"));
    }
}
