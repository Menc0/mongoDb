package com.cwh.mongodb.controller;

import com.cwh.mongodb.po.User;
import com.cwh.mongodb.service.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ______
 * _________      ____  /_
 * _  ___/_ | /| / /_  __ \
 * / /__ __ |/ |/ /_  / / /
 * \___/ ____/|__/ /_/ /_/
 */
@RestController
@RequestMapping
public class UserController {

    @Autowired
    private MongoDBService mongoDBService;

    @GetMapping(value = "/findByNameLike")
    List<User>findByNameLike(@RequestParam String name){
        return mongoDBService.findByNameLike(name);
    }
    @GetMapping(value = "/findByNameLike2")
    List<User>findByUsernameLike(@RequestParam String name){
        return mongoDBService.findUserByNameLike(name);
    }
    @GetMapping(value = "/findall")
    List<User>findall(){
        return mongoDBService.findAll(Sort.by(Sort.Order.desc("age")));
    }
    @GetMapping("add")
    void insertBath(){
        mongoDBService.save(new User(1L, "ABC", 30));
        mongoDBService.save(new User(2L, "ACC", 40));
        mongoDBService.save(new User(3L, "CCS", 50));
        mongoDBService.save(new User(4L, "ASD", 30));
        mongoDBService.save(new User(5L, "CSS", 40));
        mongoDBService.save(new User(6L, "ERR", 50));
        System.out.println(mongoDBService.findAll().size());
    }
}
