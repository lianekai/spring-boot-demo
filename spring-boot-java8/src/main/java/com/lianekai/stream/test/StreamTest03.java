package com.lianekai.stream.test;

import com.lianekai.stream.pojo.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lyk
 * @version: 1.0
 * @date 15:21
 */
public class StreamTest03 {
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


        List<String> fiterList=persons.stream().filter(x -> x.getSalary()>8000).map(Person::getName).collect(Collectors.toList());

        System.out.print("高于8000的员工姓名：" + fiterList);
    }
}
