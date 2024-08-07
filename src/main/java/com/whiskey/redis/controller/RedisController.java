package com.whiskey.redis.controller;

import com.whiskey.redis.service.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redis")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @PostMapping("/save")
    public void save(@RequestBody InteractionModel interactionModel) {
        redisService.save(interactionModel.getKey(), interactionModel.getValue());
    }

    @GetMapping("/get")
    public ResponseModel getValue(@RequestParam String key) {
        return new ResponseModel(redisService.find(key));
    }
}
