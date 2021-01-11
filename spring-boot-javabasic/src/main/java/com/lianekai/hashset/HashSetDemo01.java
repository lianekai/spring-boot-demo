package com.lianekai.hashset;

import java.util.HashSet;

public class HashSetDemo01 {
    public static void main(String[] args) {
        User user1=new User();
        user1.setId(1);
        user1.setName("lian");

        User user2=new User();
        user2.setId(1);
        user2.setName("lian");

        /**明显上面的user1和user2 应该是同一个对象*/

        /**如果User类没有重写hasode()和equals()方法*/

        HashSet set=new HashSet();
        boolean isAddUser1=set.add(user1);
        boolean isAddUser2=set.add(user2);
        System.out.println("增加user1的结果为:"+isAddUser1);
        System.out.println("增加user2的结果为:"+isAddUser2);
        /**结果都为true 也就是说添加对象都成功了，可是业务上应该是需要添加不成功的，添加的对象应该是不能重复的，所以此时应该需要重写hasode()和equals()方法*/

        /**具体原因看HashMap的put()方法源码。
         * 在判断元素是否已存在的时候：
         * 要先进行当前链表头结点与新增加的节点的hash值判断是否相等。
         * 进行key 值（HashSet的key就是存入对象，value 为Object present 的常量）的equals方法判断。
         * 按照上面User1 和 User2 两个对象，hash值肯定不同，equals 方法比较两个对象的地址，均为false。
         * 所以Hashmap 认为两者不是相同的对象，所以都添加成功。这显然不符合我们的实际业务要求。所以我们要重写hashcode 和 equals 方法。只重写一个方法依然不满足。
         * */


        /**下面是重写过hashcode 和 equals 的类的比较*/
        Student student1=new Student();
        student1.setId(1);
        student1.setName("lian");

        Student student2=new Student();
        student2.setId(1);
        student2.setName("lian");

        boolean isAddStudent1=set.add(student1);
        boolean isAddStudent2=set.add(student2);
        System.out.println("增加Student1的结果为:"+isAddStudent1);
        System.out.println("增加Student2的结果为:"+isAddStudent2);

        /**此时添加student1 成功，但是student2是失败的，应为此时判断到两个student对象是相等的*/

    }
}
