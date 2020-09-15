package cn.user.service.impl;

import cn.user.dao.UserBasicDAO;
import cn.user.domain.User;
import cn.user.service.UserBasicperform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserBasicPerformImpl implements UserBasicperform {
    @Autowired
    private UserBasicDAO userBasicDAO;
    @Override
    public void insertByList(List<User> userList) {
        for (User user:userList){
            userBasicDAO.insertOneMessage(user);
        }
    }
}
