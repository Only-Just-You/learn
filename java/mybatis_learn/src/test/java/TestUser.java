import cn.dao.UserDAO;
import cn.dao.impl.UserDAOImpl;
import cn.pojo.User;
import cn.pojo.UserTest;

import java.util.ArrayList;
import java.util.List;


public class TestUser {
    public static void findAllUser(){
        UserDAO userDAO = new UserDAOImpl();
//        根据ID来查找用户---------------------------------------------------------
        List<Integer> list_01 = new ArrayList<Integer>(){
            {add(1);add(2);}
        };
        List<User> list = userDAO.findAllUserById(list_01);

//        List<User> list = userDAO.findAllUserById();
        for (int i =0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }

    public static void findUser(){
        UserDAO userDAO = new UserDAOImpl();
//        User user = userDAO.findUser(new User("admin",null));
//        User user = userDAO.findUserByName("asd");
        User user = userDAO.getUserId(1);
        System.out.println(user.toString());
    }
//    public static void insertUser(){
//        UserDAO userDAO = new UserDAOImpl();
//        if (userDAO.insertUser(new User("mkl","333"))){
//            System.out.println("insert success");
//        }else {
//            System.out.println("insert false");
//        }
//    }
//
//    public static void updateUserByName(){
//        UserDAO userDAO = new UserDAOImpl();
//        if (userDAO.updateUserByName(new User("admin","null"))){
//            System.out.println("update success");
//        }else {
//            System.out.println("update false");
//        }
//    }
//
//    public static void deleteUserByName(){
//        UserDAO userDAO = new UserDAOImpl();
//        User user = new User();
//        user.setUsername("mkl");
//        if (userDAO.deleteUserByName(user)){
//            System.out.println("delete success");
//        }else {
//            System.out.println("delete false");
//        }
//    }
    public static void main(String[] args) {
//        insertUser();
//        findAllUser();
//        updateUserByName();
//        deleteUserByName();
        findUser();
    }
}
