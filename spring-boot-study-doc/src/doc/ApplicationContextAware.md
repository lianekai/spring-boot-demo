现金Web 程序中 Spring 管理各个实例 ，使用实例：
````
ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext-common.xml");  
AbcService abcService = (AbcService)appContext.getBean("abcService");  
````
它会重新装载applicationContext-common.xml并实例化上下文bean，如果有些线程配置类也是在这个配置文件中，
那么会造成做相同工作的的线程会被启两次。一次是web容器初始化时启动，另一次是上述代码显示的实例化了一次。
当于重新初始化一遍！！！！这样就产生了冗余。

####解决方法
通过ApplicationContextAware接口进行实现，从已有的spring上下文取得已实例化的bean。
当一个类实现了这个接口（ApplicationContextAware）之后，这个类就可以方便获得ApplicationContext中的所有bean。
换句话说，就是这个类可以直接获取spring配置文件中，所有有引用到的bean对象。