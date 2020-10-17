package edu.dao;

import edu.User;

public interface UserPerformDAO {
    User findByName(String username);
    void insertUser(User user);
}
