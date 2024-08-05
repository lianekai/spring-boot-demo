package com.lianekai.caffeine.controller;

import com.lianekai.caffeine.Device;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/VIID",name = "相机识别算法接口")
@Slf4j
public class TestController {

    @PostMapping(value = "/System/Register",name="设备注册")

    public String deviceRegister(@RequestParam("id") String id){
        return getDeviceTest(id);//        return device;
    }

    @Cacheable(value = "name1",key = "#id")
    public String getDeviceTest(String id){
        String s1="s1";
        String s2="s2";
        return "缓存的值"+s1;
    }

    @PostMapping(value = "/System/Get",name="设备注册")
    @CachePut(value = "name2",key = "#id")
    public Device getDevice(@RequestParam("id") String id){
        Device device1=new Device();
        String name="name";
        device1.setName(name);
        return device1;
    }

}
