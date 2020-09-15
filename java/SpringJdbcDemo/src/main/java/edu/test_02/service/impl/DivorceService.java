package edu.test_02.service.impl;

import edu.test_02.CoupleUser;
import edu.test_02.dao.CoupleDAO;
import edu.test_02.service.Divorce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class DivorceService implements Divorce {
    @Autowired
    private CoupleDAO coupleDAO;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void break_diverce(String onePerson, String another) {
        CoupleUser userA = coupleDAO.findByName(onePerson);
        CoupleUser userB = coupleDAO.findByName(another);
        userA.setCouple(null);
        userB.setCouple(null);
        coupleDAO.update(userA);
        coupleDAO.update(userB);
    }
}
