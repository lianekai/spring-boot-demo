## Guava Cache Java 本地缓存之王！
#### 使用
<dependency>  
    <groupId>com.github.ben-manes.caffeine</groupId>  
    <artifactId>caffeine</artifactId>
    <version>2.6.2</version>
</dependency>

### 1.缓存填充策略
Caffeine Cache提供了三种缓存填充策略：手动、同步加载和异步加载。

### 2.回收策略
Caffeine提供了3种回收策略：基于大小回收，基于时间回收，基于引用回收

### 3.移除事件监听

### 4.写入外部存储
CacheWriter 方法可以将缓存中所有的数据写入到第三方。

### 5.统计