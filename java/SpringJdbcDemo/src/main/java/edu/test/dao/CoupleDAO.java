package edu.test.dao;


import edu.test.domain.CoupleUser;

public interface CoupleDAO {
    CoupleUser findByName(String name);
    void update(CoupleUser coupleUser);
}
