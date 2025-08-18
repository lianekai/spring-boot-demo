package com.lianekai.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lianyikai
 * @version 1.0
 * @description 测试控制器
 * @date 2022/9/17 20:08
 **/
@Slf4j
@RestController(value = "")
public class TestController {

    @Autowired
    RedissonClient redisson;

    @Autowired
    StringRedisTemplate redisTemplate;

    @PostMapping(value = "/test/readWriteLock/toRead")
    public String toReadLock(){
        /**获取 锁
         *
         */
        RReadWriteLock readWriteLock = redisson.getReadWriteLock("readWriteLock");
        RLock rLock = readWriteLock.readLock();
        /**上 读锁*/
        rLock.lock();
        String writeValue = "";
        try {
            log.info("【读锁-{}】加锁成功，读数据...", Thread.currentThread().getId());
            writeValue = redisTemplate.opsForValue().get("writeValue");
        } finally {
            log.info("【读锁-{}】解锁成功,uuid={}", Thread.currentThread().getId(),writeValue);
            //解锁
            rLock.unlock();
        }
        return writeValue;
    }

    @GetMapping("/test/readWriteLock/toWrite")
    public String toWriteLock() {
        /**获取 锁*/
        RReadWriteLock readWriteLock = redisson.getReadWriteLock("readWriteLock");
        RLock rLock = readWriteLock.writeLock();
        /**上 写锁*/
        rLock.lock();
        String uuid = UUID.randomUUID().toString();
        try {
            log.info("【写锁-{}】加锁成功，睡眠3秒，模拟执行业务...", Thread.currentThread().getId());
            Thread.sleep(3000);
            redisTemplate.opsForValue()
                    .set("writeValue", uuid);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log.info("【写锁-{}】解锁成功，uuid={}", Thread.currentThread()
                    .getId(),uuid);
            //解锁
            rLock.unlock();
        }
        return "writeLock ok,uuid = " + uuid;
    }
}
