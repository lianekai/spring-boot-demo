package com.lianekai.redis.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lianekai.redis.pojo.User;
import com.lianekai.redis.util.RedisUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    RedisUtils redisUtils;


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

    @org.junit.Test
    public void testExpire(){
        redisUtils.expire("name1",20);
    }

    @org.junit.Test
    public void getExpire(){
        long time=redisUtils.getExpire("sex");
        System.out.println(time);
    }

    @org.junit.Test
    public void testHasKey(){
        boolean hasKey=redisUtils.hasKey("sex");
        System.out.println("有这个key:"+hasKey);
    }

    @org.junit.Test
    public void delKey(){
        redisUtils.del("name","sex1");
        System.out.println("删除这个key");
    }


    @org.junit.Test
    public void getKey(){
        Object value=redisUtils.get("X");
        System.out.println("这个key的value:"+value.toString());
    }

    @org.junit.Test
    public void setKey(){
        boolean b=redisUtils.set("name","lianeiaki");
        System.out.println("设置key的value:"+b);
    }

    @org.junit.Test
    public void setKeyAndExpireTime(){
        long expireTime=20;
        boolean b=redisUtils.set("name2","lianeiaki",expireTime);
        System.out.println("设置key的value:,超期时间"+expireTime);
    }

    @org.junit.Test
    public void hmset(){
        Map<String,Object> map=new HashMap<>();
        map.put("lianyikai","练益楷");
        map.put("heliuqing","何柳青");
        boolean b=redisUtils.hmset("person",map);
        System.out.println("设置key的value:,超期时间");
    }

    @org.junit.Test
    public void hset(){
        boolean b=redisUtils.hset("person","qianyan","千言");
        System.out.println("设置key的value:");
    }

    @org.junit.Test
    public void hget(){
        Object o=redisUtils.hget("person","lianyikai");
        System.out.println("获取Map person 的 key qianyan 的值:"+o.toString());
    }

}
