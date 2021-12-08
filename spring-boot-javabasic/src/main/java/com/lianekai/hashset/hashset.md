# hashSet原理
#### hashset底层是hashmap实现的,但是hashset有元素不可重复的原则
hashCode()方法和equals()方法的作用其实一样，在Java里都是用来对比两个对象是否相等一致。
hashcode 其实是对象物理地址返回的整数值，equals() 方法默认比较的就是两个对象的地址是否相同；所以equals() 相等的两个对象，hashCode 一定相同。
equals 比较的比较全面，所以效率方面没有hashcode的效率高，而hashcode只需要生成一个hash值就可以进行比较了，效率高，但只是大部分情况下可靠，并非绝对可靠。
### equals()与hashCode()比较的区别
equals()相等的两个对象他们的hashCode()肯定相等，也就是用equals()对比是绝对可靠的。
hashCode()相等的两个对象他们的equals()不一定相等，也就是hashCode()不是绝对可靠的

### HashSet需要重写hashcode()和equals()方法。 
原因：如果类并没有重写两个方法，不能保证元素的的不可重复的原则