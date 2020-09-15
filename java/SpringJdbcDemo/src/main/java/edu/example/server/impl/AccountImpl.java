package edu.example.server.impl;

import edu.example.dao.AccountDAO;
import edu.example.domain.AccountUser;
import edu.example.server.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AccountImpl implements AccountService {
    @Autowired
    private AccountDAO accountDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public void transfer(String fromA, String toB, int account) {
        AccountUser userA = accountDAO.findByName(fromA);
        userA.setAccount(userA.getAccount()-account);
        accountDAO.update(userA);
        AccountUser userB = accountDAO.findByName(toB);
        userB.setAccount(userB.getAccount()+account);
        accountDAO.update(userB);
    }
}
