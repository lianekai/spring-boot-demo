package com.lianekai.guava.multiset;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MutilsetDemo01 {
    public static void main(String[] args) {
        Multiset<String> multiset= HashMultiset.create();
        multiset.add("a");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");
        multiset.add("d");
        System.out.println(multiset.size());
        System.out.println(multiset.count("a"));
    }
}
