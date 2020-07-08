package com.cwh.mongodb.service;

import com.cwh.mongodb.po.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * ______
 * _________      ____  /_
 * _  ___/_ | /| / /_  __ \
 * / /__ __ |/ |/ /_  / / /
 * \___/ ____/|__/ /_/ /_/
 */

public interface MongoDBService extends MongoRepository<User, Long> {

    @Query("{\"name\":{\"$regex\":?0}}")
    List<User> findByNameLike(String name);

    /**
     * Like（模糊查询）
     * {"name" : username} ( name as regex)
     * */
    List<User> findUserByNameLike(String username);

}
