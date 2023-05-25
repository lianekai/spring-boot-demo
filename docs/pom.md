# pom 打包方式
pom 的打包方式有三种： pom  jar war    
--  <packaging>pom</packaging>
包含父子结构的项目中，顶级父目录的pom打包方式应为 :pom，表示只做子模块的整合，不打包成jar文件目录，maven install时不会生成jar/war压缩包。
可以将一些子项目中共用的依赖或将其版本统一写到父级配置中，以便统一管理。 groupId, artifactId, version能直接从父级继承，减少子项目的pom配置。
--  <packaging>jar</packaging>
pom文件默认的打包方式，不写<packaging> 默认就是jar ,该打包方式表明使用mvn install命令的时候，能够发现在项目中与src文件夹同级新生成了一个target文件夹，这个文件夹内的classes文件夹即为刚才提到的编译后形成的文件夹。
--  <packaging>war</packaging>
war包与jar包非常相似，同样是编译后的.class文件按层级结构形成文件树后打包形成的压缩包。不同的是，它会将项目中依赖的所有jar包都放在WEB-INF/lib这个文件夹下
war包非常适合部署时使用，不再需要下载其他的依赖包，能够使用户拿到war包直接使用，因此它经常使用于微服务项目群中的入口项目的pom配置中