package com.example.MainService.dao;

import com.example.MainService.model.User;

public interface UserDao {

    User findUser(Long id);

    void saveUser(User user);

    void update(User user);

    void delete(Long id);
}
