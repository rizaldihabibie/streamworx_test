package com.example.MainService.service;

import com.example.MainService.dao.UserDao;
import com.example.MainService.model.User;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDao {

    private final String HASH_REFERENCE = "USER";

    @Resource(name="redisTemplate")
    private HashOperations<String, Long, User> hashOperations;

    @Override
    public User findUser(Long id) {
        return hashOperations.get(HASH_REFERENCE, id);
    }

    @Override
    public void saveUser(User user) {
        hashOperations.putIfAbsent(HASH_REFERENCE, user.getId(), user);
    }

    @Override
    public void update(User user) {
        hashOperations.put(HASH_REFERENCE, user.getId(), user);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(HASH_REFERENCE, id);
    }
}
