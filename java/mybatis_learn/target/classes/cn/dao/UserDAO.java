package cn.dao;

import cn.pojo.User;
import cn.pojo.UserTest;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDAO {
//    @Select("select * from user_list")
    List<User> findAllUser();
    List<User> findAllUserById(List<Integer> arrayId);
    User findUser(User user);
    User findUserByName(String username);
    boolean insertUser(User user);
    boolean updateUserByName(User user);
    boolean deleteUserByName(User user);

    UserTest getUserTest(int id);
    User getUserId(int id);
}
