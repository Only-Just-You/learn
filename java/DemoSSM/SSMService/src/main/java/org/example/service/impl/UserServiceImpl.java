package org.example.service.impl;

import org.example.pojo.User;
import org.example.dao.UserDAO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAllUser() {
        return userDAO.findAllUser();
    }

    @Override
    public void register(User user) {
        userDAO.insertUser(user);
    }
}
