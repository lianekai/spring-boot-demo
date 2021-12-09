##**Quartz是一个定时任务框架**
核心接口：
#### Scheduler接口：
Scheduler翻译成调度器，Quartz通过调度器来注册、暂停、删除Trigger和JobDetail。Scheduler还拥有一个SchedulerContext，顾名思义就是上下文，通过SchedulerContext我们可以获取到触发器和任务的一些信息。

#### Trigger接口
Trigger可以翻译成触发器，通过cron表达式或是SimpleScheduleBuilder等类，指定任务执行的周期。系统时间走到触发器指定的时间的时候，触发器就会触发任务的执行

#### JobDetail接口
ob接口是真正需要执行的任务。JobDetail接口相当于将Job接口包装了一下，Trigger和Scheduler实际用到的都是JobDetail。