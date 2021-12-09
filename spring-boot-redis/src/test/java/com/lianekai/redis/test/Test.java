package com.lianekai.redis.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lianekai.redis.pojo.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/08 13:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;


    @org.junit.Test
    public void test(){
        stringRedisTemplate.opsForValue().set("sex","M");
    }


    @org.junit.Test
    public void testHash(){
        redisTemplate.opsForHash();
    }

    @org.junit.Test
    public void testObject() throws JsonProcessingException {
        User u= User.builder().build().setId(1).setName("lianyikai").setSex("M");
        String jsonUser = new ObjectMapper().writeValueAsString(u);
        /**设定key的序列化方式 不然设置的值有问题*/
        redisTemplate.setKeySerializer(RedisSerializer.string());
        /**设定value的序列化方式 不然设置的值有问题*/
        redisTemplate.setValueSerializer(RedisSerializer.string());
        redisTemplate.opsForValue().set("student",jsonUser);
    }



}
