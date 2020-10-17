package edu.service.impl;

import edu.User;
import edu.dao.UserPerformDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPerform implements edu.service.UserPerform {
    @Autowired
    private UserPerformDAO userPerformDAO;
    @Override
    public void register(User user) {
        userPerformDAO.insertUser(user);
    }
}
