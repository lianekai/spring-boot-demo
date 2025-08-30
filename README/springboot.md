## 注解使用

### @SpringBootApplication
这是一个组合注解，包含了  `@Configuration`、 `@EnableAutoConfiguration` 和 `@ComponentScan` 注解。通常用于 Spring Boot 应用的主类。

### @RestController
这是一个组合注解，包含了 `@Controller` 和 `@ResponseBody` 注解。用于创建 RESTFUL 风格的控制器。

### @Service
用于标注服务层的组件。

### @Repository
用于标注数据访问层的组件，通常用于 DAO 层。

### @Component
用于标注一个普通的 Spring 组件，可以用于任何层。

### @Autowired
用于自动装配 bean，可以用于构造函数、属性或方法。

### @Value
用于注入外部化配置的值，如配置文件中的属性。

### @Configuration
用于定义配置类，相当于 Spring 的 XML 配置文件。

### @Bean
用于定义一个 bean，通常在 @Configuration 类中使用。

### @Conditional
用于根据特定条件创建 bean，如 `@ConditionalOnProperty`、`@ConditionalOnClass` 等。

### @EnableAutoConfiguration
用于启用 Spring Boot 的自动配置功能。

### @Profile：
用于根据不同的环境加载不同的配置。

### @RequestMapping
用于映射 HTTP 请求到控制器方法。

### @GetMapping、@PostMapping、@PutMapping、@DeleteMapping
是 `@RequestMapping` 的特化，用于处理特定的 HTTP 方法。

### @RequestParam、@PathVariable、@RequestBody：
用于处理请求参数和请求体。

### @EnableConfigurationProperties 和 @ConfigurationProperties
在 Spring Boot 开发过程中，我们经常会使用到 `@ConfigurationProperties` 注解，其主要作用是将 properties 或 yml 配置文件转化为 bean 以供使用。而 `@EnableConfigurationProperties` 注解的作用是使 `@ConfigurationProperties` 注解生效。
如果只配置 `@ConfigurationProperties` 注解，在 Spring Boot 的 IOC 容器中是无法获取到 properties 配置文件转化的 bean 的。当然，如果我们在 `@ConfigurationProperties` 注解的类上加上 `@Component` 注解，也可以使该类交由 Spring Boot 管理。
这里的 `@EnableConfigurationProperties` 注解和`@Component` 注解都可以使`@ConfigurationProperties` 注解生效，但 `@EnableConfigurationProperties` 注解是 Spring Boot 提供的一个更优雅的方式。
