
### @MapperScan
@MapperScan注解的主要作用是自动扫描并注册MyBatis的Mapper接口，将其注册为Spring容器中的Bean‌。这样，Spring Boot应用在启动时能够自动识别并加载这些Mapper接口，从而简化了配置过程，提高了开发效率‌

使用场景和配置方法
‌自动扫描和注册Mapper‌：@MapperScan注解可以指定要扫描的包路径，自动扫描该路径下的Mapper接口，并将它们注册为Spring的Bean。这样，开发者不需要手动声明每一个Mapper接口，简化了配置过程‌
‌减少@Mapper注解的使用‌：通过使用@MapperScan注解，可以减少在每个Mapper接口上单独添加@Mapper注解的需要，使得配置更加集中和简洁‌
‌配置示例‌：在Spring Boot应用的主类上添加@MapperScan注解，指定要扫描的包路径。例如：

```java

@SpringBootApplication
@MapperScan("com.example.projectDemo.mapper")
public class ProjectDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectDemoApplication.class, args);
    }
}
```

这段代码表示扫描com.example.projectDemo.mapper包下的所有Mapper接口‌
2
。
原理和属性
@MapperScan注解通过Spring Framework提供的功能，自动扫描指定的包路径，找到MyBatis的Mapper接口，并将其注册为Spring容器中的Bean。其主要属性包括：

basePackages‌：指定要扫描的包路径。
value‌：与basePackages作用相同，指定扫描的包路径。
basePackageClasses‌：指定要扫描的类路径。
nameGenerator‌：扫描注册的bean命名规则。
annotationClass‌：指定自定义注解进行扫描‌
