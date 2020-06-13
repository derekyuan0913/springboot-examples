package org.yuanding.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisExampleController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/test")
    public String testRedis() {
        stringRedisTemplate.opsForValue().set("aaa", "5");
        String value = stringRedisTemplate.opsForValue().get("aaa");

        redisTemplate.opsForValue().set("bbb", 5);
        Object obj = redisTemplate.opsForValue().get("bbb");

        assert obj != null;
        return value + " and " + obj.toString();
    }
}
