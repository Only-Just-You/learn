package edu.test.server.impl;

import edu.test.dao.CoupleDAO;
import edu.test.domain.CoupleUser;
import edu.test.server.BecomeCouple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class BecomeServer implements BecomeCouple {
    @Autowired
    private CoupleDAO coupleDAO;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void getMarried(String one, String two) {
        CoupleUser userA = coupleDAO.findByName(one);
        CoupleUser userB = coupleDAO.findByName(two);
        userA.setCouple(two);
        userB.setCouple(one);
        coupleDAO.update(userA);
//        int i = 1/0;
        coupleDAO.update(userB);
    }
}
