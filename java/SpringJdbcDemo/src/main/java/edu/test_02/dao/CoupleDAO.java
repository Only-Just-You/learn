package edu.test_02.dao;


import edu.test_02.CoupleUser;

public interface CoupleDAO {
    CoupleUser findByName(String name);
    void update(CoupleUser coupleUser);
}
