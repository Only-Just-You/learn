package org.example.service;

import org.example.pojo.User;

import java.util.List;
public interface UserService {
    List<User> findAllUser();
    void register(User user);
}
