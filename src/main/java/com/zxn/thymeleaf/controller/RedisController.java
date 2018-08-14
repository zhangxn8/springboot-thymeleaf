package com.zxn.thymeleaf.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
   
	
	    @Autowired
	    private RedisTemplate<String, Object> redisTemplate;

	    /**
	     * 缓存测试
	     *
	     * @return
	     * @author  SHANHY
	     * @create  2016年9月12日
	     */
	    @RequestMapping("/redisTest")
	    public String redisTest() {
	        try {
	            redisTemplate.opsForValue().set("test-key01", "redis测试内容", 1, TimeUnit.HOURS);// 缓存有效期2秒

	            System.out.println("从Redis中读取数据：" + redisTemplate.opsForValue().get("test-key01").toString());

	            TimeUnit.SECONDS.sleep(3);

	            System.out.println("等待3秒后尝试读取过期的数据：" + redisTemplate.opsForValue().get("test-key01"));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        return "hello";
	    }
} 
