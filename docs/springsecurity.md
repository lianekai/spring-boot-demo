# spring security 详细解读
## 1. 概述
Spring Security 是一个开源的 Java 框架，用于实现基于 Spring 的应用程序的认证、授权和访问控制。


## 2. Spring Security 的核心组件
1. AuthenticationManager：Spring Security 的核心组件，用于处理用户认证。


## WebSecurityConfigurerAdapter

WebSecurityConfigurerAdapter 是 Spring Security 中用于 配置 Web 安全策略的核心基类。它提供了多个 configure(...) 方法，允许你自定义：
URL 访问权限控制
表单登录、退出逻辑
静态资源放行
CSRF 保护
Session 管理
CORS 设置
异常处理等

✅ 作用总结一句话：
WebSecurityConfigurerAdapter 是 Spring Security 提供的一个抽象类，用于帮助开发者通过继承并重写方法的方式，定制应用的安全策略。
📌 主要功能详解
1. configure(HttpSecurity http)   该方法用于配置 Web 安全策略。
```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/public/**").permitAll() // 允许公开访问
            .anyRequest().authenticated()          // 其他请求必须认证
            .and()
        .formLogin()                              //开启没有认证的求情统一返回到登录页面
            .loginPage("/login")                  // 自定义登录页面
            .permitAll()
            .and()
        .logout()
            .permitAll();
}
```

包含常见配置项：
模块
功能
.formLogin()
表单登录配置
.logout()
注销配置
.authorizeRequests()
URL 权限控制
.csrf()
跨站请求伪造防护
.sessionManagement()
Session 管理
.exceptionHandling()
异常处理（如无权限访问）
.headers()
HTTP 响应头安全设置


2. configure(WebSecurity web) 允许你配置 Web 相关的策略，如静态资源放行、CSRF 保护等。
```java
@Override
public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
}
```
适用于：
CSS、JS、图片等静态资源
Swagger、Actuator 等监控接口
第三方资源（如字体文件）

3. configure(AuthenticationManagerBuilder auth) 用于配置认证机制，例如使用数据库、LDAP 或自定义的认证方式：
```java
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
}
```
也可以注册自定义的 AuthenticationProvider：
```java
auth.authenticationProvider(myCustomAuthProvider);
```
🧩 示例说明
经典继承结构：
```java
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user").password("{noop}password").roles("USER");
    }
}
```

从 Spring Boot 2.7 开始弃用
在 Spring Boot 2.7 及之后版本中，WebSecurityConfigurerAdapter 已被 标记为废弃，官方推荐使用基于组件的新风格配置方式，即不用继承WebSecurityConfigurerAdapter，直接在容器配置类中声明返回一个 bean 对象，例如：
✅ 推荐新写法（Spring Boot >= 2.7）
```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
http
.authorizeRequests(auth -> auth
.antMatchers("/public/**").permitAll()
.anyRequest().authenticated()
)
.formLogin(withDefaults())
.logout(withDefaults());

    return http.build();
}
```
但如果你使用的是 低于 Spring Boot 2.7 的版本（如 2.6.x 或更早），则仍然可以继续使用 WebSecurityConfigurerAdapter。


## AuthenticationDetailsSource 
AuthenticationDetailsSource 是 Spring Security 框架中的一个接口，其主要作用是为认证请求提供额外的详细信息（即认证的上下文信息），通常用于自定义认证流程中。
主要用途如下：
提供认证细节：
在用户登录过程中，它可以将一些与请求相关的附加信息（如 IP 地址、会话 ID、用户代理等）封装到 Authentication 对象中。
实现类通常会实现 buildDetails(Object) 方法，返回一个包含这些细节的对象（如 WebAuthenticationDetails）。
支持自定义认证逻辑：
如果你使用了自定义的 AuthenticationProvider 或 AbstractUserDetailsAuthenticationProvider，可以通过设置 AuthenticationDetailsSource 来注入额外的身份验证信息，供后续鉴权或审计使用。
在 Filter 中使用：
一般在 Spring Security 的过滤器链中，比如 UsernamePasswordAuthenticationFilter，会使用配置的 AuthenticationDetailsSource 来填充认证对象的 details 属性。
典型实现类：
org.springframework.security.web.authentication.WebAuthenticationDetailsSource：这是默认常用的实现类，用于从 HTTP 请求中提取基本的认证详情（如远程地址和会话 ID）。

示例代码（在配置中使用）：
```java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .formLogin(form -> form
                    .authenticationDetailsSource(authenticationDetailsSource())
            );
    return http.build();
}

@Bean
public AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource() {
    return new WebAuthenticationDetailsSource();
}
```

总结：
AuthenticationDetailsSource 提供了一个机制，用于在认证阶段向 Authentication 对象注入更多上下文信息。
它常用于增强安全审计、多因素认证、IP 白名单等场景。

#### 提问：authenticationDetailsSource 这个方法里面也是返回一个新的对象，有什么用，里面也没有添加什么额外的信息？
✅ 1. 这个方法的作用是什么？
这个方法定义了一个 AuthenticationDetailsSource Bean，用于在 Spring Security 的认证流程中 构建认证详情（Authentication Details）。
WebAuthenticationDetailsSource 是 Spring Security 提供的一个默认实现。
它会在用户登录时从 HttpServletRequest 中提取一些基础信息（如 IP 地址、会话 ID），并封装到 Authentication 对象的 details 属性中。
默认情况下，Spring Security 并不会自动注册这个 Bean，所以通过配置显式声明是为了确保其可用性。
✅ 2. 虽然没有“添加额外信息”，但本身是有意义的
虽然你在方法中没有添加额外逻辑，但：
WebAuthenticationDetailsSource 本身已经实现了默认的认证细节构建逻辑。
它返回的是一个 WebAuthenticationDetails 实例，包含以下信息：
用户登录的远程地址（Remote Address）
会话 ID（Session ID）
这些信息对于安全审计、风控系统等场景非常有用。
例如，在登录成功后你可以这样获取：
```java
WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
String remoteAddress = details.getRemoteAddress();
String sessionId = details.getSessionId();
```
✅ 3. 可以不写这个方法吗？
✔️ 如果你使用的是 Spring Boot + Spring Security 的默认行为：
大多数情况下，Spring Security 会自动创建一个默认的 AuthenticationDetailsSource。
所以如果你不需要自定义逻辑，可以不显式声明这个 Bean。
❗ 但是如果你想：
自定义认证详情（比如记录 User-Agent、设备类型、地理位置等）
在认证过程中注入更多上下文用于风控或日志审计
替换默认的 WebAuthenticationDetails 实现
那你需要自己实现一个 AuthenticationDetailsSource，并在配置中注册它。
✅ 4. 示例：自定义 AuthenticationDetailsSource
如果你希望添加更多信息，可以这样做：
```java
@Bean
public AuthenticationDetailsSource<HttpServletRequest, ?> authenticationDetailsSource() {
return request -> {
String userAgent = request.getHeader("User-Agent");
String remoteAddr = request.getRemoteAddr();
return new CustomWebAuthenticationDetails(remoteAddr, userAgent);
};
}
```

