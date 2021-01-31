package com.lianekai.guava.charset;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class JoinerDemo01 {
    public static void main(String[] args) {
        Joiner joiner=Joiner.on(";").skipNulls();
        String s=joiner.join("lianyikai",null,"太帅了了","对的对的");
        log.info(s);
        System.out.println(s);


        Joiner joiner1=joiner.on("|").useForNull("//");
        String  s2=joiner1.join("123"," ",null,"qwe","shiajosjOI");
        System.out.println(s2);

        List<String> list=Splitter.on("|")
                .trimResults()
                .omitEmptyStrings()
                .splitToList(s2);
        System.out.println(list);
    }
}
