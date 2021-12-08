package com.lianekai.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.graph.Graph;

import java.security.Key;
import java.util.concurrent.TimeUnit;


public class GuavaCacheDomo01 {
    public static void main(String[] args) {
        Cache<Object, Object> graph= CacheBuilder.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES).build();
                //.removalListener(My_LISTENER)
//                .build(
////                     new CacheLoader<Key,Graph>(){
////////                public Graph load(Key key) throws AnyException{
////////                    return createExpensiveGraph(key);
////////                }
//            });
    }
    public void testCache(){

    }
}
