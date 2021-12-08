package com.lianekai.guava.multiset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MutilsetDemo02 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        List<String> readOnlyList= Collections.unmodifiableList(list);
        //readOnlyList.add("c");java.lang.UnsupportedOperationException
        list.add("c");

        System.out.println(readOnlyList.size());
    }
}
