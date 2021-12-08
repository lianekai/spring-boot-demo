java 实现导入导出 加校验


## Spring Validation
校验：Spring Validation是对hibernate validation的二次封装
spring-boot版本小于2.3.x，spring-boot-starter-web会自动传入hibernate-validator依赖。如果spring-boot版本大于2.3.x，则需要手动引入依赖：

`<dependency>
     <groupId>org.hibernate</groupId>
     <artifactId>hibernate-validator</artifactId>
     <version>6.0.1.Final</version>
 </dependency>`
 
 对于web服务来说，为防止非法参数对业务造成影响，在Controller层一定要做参数校验的！大部分情况下，请求参数分为如下两种形式：
 
 POST、PUT请求，使用requestBody传递参数；
 GET请求，使用requestParam/PathVariable传递参数。
 
 ###requestBody参数校验
 
 POST、PUT请求一般会使用requestBody传递参数，这种情况下，后端使用DTO对象进行接收。只要给DTO对象加上@Validated注解就能实现自动参数校验。