package com.lianekai.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/01/05 09:27
 */
public class StreamTest05 {
    public static void main(String[] args) {
        List<Integer> integerList= Arrays.asList(1,2,5,3,4,4,3,8);
        /**将List流化，map映射*/
        List<Integer> mapList=integerList.stream().map(i->i*i).distinct().collect(Collectors.toList());

        System.out.println(mapList);


        List<String> strings=Arrays.asList("wo","hen","帅","","lianyikai");
        List<String> filterStrings=strings.stream().filter(s->!"".equals(s)).collect(Collectors.toList());
        System.out.println(filterStrings);
    }
}
