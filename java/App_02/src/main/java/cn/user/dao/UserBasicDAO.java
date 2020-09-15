package cn.user.dao;


import cn.user.domain.User;

import java.util.List;

public interface UserBasicDAO {
    List<User> findAll();
    User findById(Integer id);
    void insertOneMessage(User user);
}
