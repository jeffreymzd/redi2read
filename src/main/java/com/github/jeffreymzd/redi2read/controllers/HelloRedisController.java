package com.github.jeffreymzd.redi2read.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by jeffreymzd on 4/13/21
 */
@RestController
@RequestMapping("/api/redis")
public class HelloRedisController {
    @Autowired
    private RedisTemplate<String, String> template;

    private static final String STRING_KEY_PREFIX = "redi2read:strings:"; // prefix the keys that we write to Redis

    @PostMapping("/strings")
    @ResponseStatus(HttpStatus.CREATED)
    public Map.Entry<String, String> setString(@RequestBody Map.Entry<String, String> kvp) {
        // use opsForValue() method to get an instance of ValueOperations
        // then call SET method to set key value pairs into Redis cache
        template.opsForValue().set(STRING_KEY_PREFIX + kvp.getKey(), kvp.getValue());
        return kvp;
    }
}
