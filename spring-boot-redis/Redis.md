**SpringBoot 集成redis**
-----------------
#### 添加依赖

````xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
````

springboot2.x 之后 jedis 改为 lettuce
jedis:采用直连，在多线程环境下是非线程安全的，这个时候只有使用连接池，为每个Jedis实例增加物理连接
lettuce:采用netty,实例可以在多个线程中共享，线程安全，可以减少线程数量  
[jedis和lettuce的区别](https://www.cnblogs.com/albertzhangyu/p/13745818.html)

#### 配置链接  

````shell script
# Redis数据库索引（默认为0）
spring.redis.database=0
# Redis服务器地址
spring.redis.host=127.0.0.1
# Redis服务器连接端口
spring.redis.port=6379
# Redis服务器连接密码（默认为空）
spring.redis.password=
# 连接池最大连接数（使用负值表示没有限制）
spring.redis.jedis.pool.max-active=20
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.jedis.pool.max-wait=-1
# 连接池中的最大空闲连接
spring.redis.jedis.pool.max-idle=10
# 连接池中的最小空闲连接
spring.redis.jedis.pool.min-idle=0
# 连接超时时间（毫秒）
spring.redis.timeout=1000
````


#### 开始使用
RedisTemplate 提供了各种redis数据类型的操作方法,API和redis命令基本相同  
````
opsForValue()
opsForList()
opsForSet()
opsForHash()
opsForZSet()
opsForGeo()
opsForHyperLogLog()
````

/**
*@return  
*@date 2021/12/10 
**/
####Redis 常用控制台窗口命令
````shell script
keys *   #查看所有的key
flushdb  #删除当前数据库中的所有Key
flushall #删除所有数据库中的key
get {key}  #获取key的值




        
  
        
 
        


````




