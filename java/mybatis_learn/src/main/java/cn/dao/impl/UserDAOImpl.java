package cn.dao.impl;

import cn.dao.UserDAO;
import cn.pojo.Product;
import cn.pojo.User;
import cn.pojo.UserTest;
import cn.utils.MyBatisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
//@Mapper
public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> findAllUser() {
        SqlSession session = null;
        List<User> list = new ArrayList<User>();
        try {
//            String resource = "mybatis-config.xml";
//            Reader reader = Resources.getResourceAsReader(resource);
//
//            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            SqlSessionFactory factory = builder.build(reader);

            session = MyBatisUtil.getSession();

            list = session.selectList("cn.dao.UserDAO.findAllUser");

//            以下使用注解方式----------------------------------------------------------------
//            UserDAO userDAO = session.getMapper(UserDAO.class);
//            list = userDAO.findAllUser();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        return list;
    }

    @Override
    public List<User> findAllUserById(List<Integer> arrayId) {
        SqlSession session = null;
        List<User> list = new ArrayList<User>();
        try {
            session = MyBatisUtil.getSession();
            list = session.selectList("cn.dao.UserDAO.findAllUser", arrayId);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        return null;
    }

    @Override
    public User findUser(User user) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            User user1 = session.selectOne("cn.dao.UserDAO.findUser", user);
            return user1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        return null;
    }

    @Override
    public User findUserByName(String username) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            User user1 = session.selectOne("cn.dao.UserDAO.findUserByName", username);
            return user1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        return null;
    }

    @Override
    public boolean insertUser(User user) {
        SqlSession session = null;
        int value = 0;
        try {
            session = MyBatisUtil.getSession();
            value = session.insert("cn.dao.UserDAO.insertUser", user);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        if (value != 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateUserByName(User user) {
        SqlSession session = null;
        int value = 0;
        try {
            session = MyBatisUtil.getSession();
            value = session.update("cn.dao.UserDAO.updateUserByName", user);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        if (value != 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteUserByName(User user) {
        SqlSession session = null;
        int value = 0;
        try {
            session = MyBatisUtil.getSession();
            value = session.delete("cn.dao.UserDAO.deleteUserByName", user);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        if (value != 0)
            return true;
        else
            return false;
    }

    @Override
    public UserTest getUserTest(int id) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
//            UserTest user = session.selectOne("cn.dao.UserDAO.selectUserDetails", id);
            UserDAO mapper = session.getMapper(UserDAO.class);
            UserTest user  = mapper.getUserTest(1);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        return null;
    }

    @Override
    public User getUserId(int id) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            User user = mapper.getUserId(1);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        return null;
    }

    @Override
    public Product getProduct(int id) {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSession();
            UserDAO mapper = session.getMapper(UserDAO.class);
            Product product = mapper.getProduct(id);
            return product;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        return null;
    }
}
