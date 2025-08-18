package com.lianekai.concurrency.service;

/**
 * @author lianyikai
 * @date 2025年07月30日 10:20
 */
public class TestMeddle {

    private static int i = 0;

    public int cul(Object obj) {
        i = 200;
       return i;
    }
}
