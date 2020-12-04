## java8新增特性之一：stream
##### Stream将要处理的元素集合看作一种流，在流的过程中，借助Stream API对流中的元素进行操作，比如：筛选、排序、聚合等。

Stream可以由数组或集合创建，对流的操作分为两种：
中间操作，每次返回一个新的流，可以有多个。
终端操作，每个流只能进行一次终端操作，终端操作结束后流无法再次使用。终端操作会产生一个新的集合或值。
另外，Stream有几个特性：
stream不存储数据，而是按照特定的规则对数据进行计算，一般会输出结果。
stream不会改变数据源，通常情况下会产生一个新的集合或一个值。
stream具有延迟执行特性，只有调用终端操作时，中间操作才会执行
2 Stream的创建

Stream可以通过集合数组创建。
1、通过 java.util.Collection.stream() 方法用集合创建流

List<String> list = Arrays.asList("a", "b", "c");
// 创建一个顺序流
Stream<String> stream = list.stream();
// 创建一个并行流
Stream<String> parallelStream = list.parallelStream();



2、使用java.util.Arrays.stream(T[] array)方法用数组创建流
int[] array={1,3,5,6,8};
IntStream stream = Arrays.stream(array);


3、使用Stream的静态方法：of()、iterate()、generate()
Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
stream2.forEach(System.out::println); // 0 2 4 6 8 10

Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
stream3.forEach(System.out::println);
输出结果：
0 3 6 9
0.6796156909271994
0.1914314208854283
0.8116932592396652



### 遍历/匹配（foreach/find/match）
stream和parallelStream的简单区分： stream是顺序流，由主线程按顺序对流执行操作，而parallelStream是并行流，内部以多线程并行执行的方式对流进行操作，但前提是流中的数据处理没有顺序要求。例如筛选集合中的奇数，两者的处理不同之处：

如果流中的数据量足够大，并行流可以加快处速度。
除了直接创建并行流，还可以通过parallel()把顺序流转换成并行流：
Optional<Integer> findFirst = list.stream().parallel().filter(x->x>6).findFirst();

Optional类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。

### 筛选（filter）
筛选，是按照一定的规则校验流中的元素，将符合条件的元素提取到新的流中的操作。