Springfox 2.9.2 依赖 Spring Boot 2.6.x，而 Spring Boot 2.7.18 属于 2.7.x 版本。直接使用会导致启动失败，常见错误为 Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException，通常由版本不兼容导致的路径匹配策略冲突引起。 ‌
1

解决方案
‌降级 Springfox
将 Springfox 版本降级至与 Spring Boot 2.7.x 兼容的版本（如 3.0.0 或更高）。
‌升级 Spring Boot
若需保留 Springfox 2.9.2，可将 Spring Boot 升级至 2.6.x（如 2.6.10）。
‌修改路径匹配策略‌
若保留 Spring Boot 2.7.18，需在配置中强制使用 ant-path-matcher：
spring:  
mvc:  
pathmatch:  
pattern: ant-path-matcher
``` ‌:ml-citation{ref="1" data="citationList"}
