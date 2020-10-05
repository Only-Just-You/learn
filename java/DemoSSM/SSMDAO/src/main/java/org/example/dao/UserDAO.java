package org.example.dao;

import org.example.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDAO {
    List<User> findAllUser();
    void insertUser(User user);
}
