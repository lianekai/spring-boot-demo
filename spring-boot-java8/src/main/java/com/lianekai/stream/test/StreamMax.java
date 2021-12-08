package com.lianekai.stream.test;

import com.lianekai.stream.pojo.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lyk
 * @version: 1.0
 * @date 17:02
 */
public class StreamMax {
    public static void main(String[] args) {
        List<Person> persons=new ArrayList<>();
        persons.add(new Person("Tom",8900,23,"male","广州"));
        persons.add(new Person("Jack",9900,23,"male","深圳"));
        persons.add(new Person("Lim",7900,23,"male","上海"));
        persons.add(new Person("Anni",11900,23,"male","上海"));
        persons.add(new Person("Owe",5900,23,"male","广州"));
        persons.add(new Person("tem",8800,23,"male","上海"));
        persons.add(new Person("Xiao",8900,23,"male","深圳"));
        persons.add(new Person("Alisa",8900,23,"male","广州"));

        List<Integer> salaryList=persons.stream().filter(x ->x.getSalary()>0).map(Person::getSalary).collect(Collectors.toList());

        Optional<Integer> max=salaryList.stream().max(Comparator.comparing(Integer::intValue));

        System.out.println(" 最大值"+max.get());


        //自然排序
        Optional<Integer> max2=salaryList.stream().max(Integer::compareTo);
        System.out.println(" 最大值max2  "+max2.get());


        //自定义排序
        Optional<Integer> max3=salaryList.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(" 最小值max3  "+max3.get());


        //正确比较工资最高
        Optional<Person> maxx=persons.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println(" 最高工资值maxx  "+maxx.get().getSalary());



    }
}
