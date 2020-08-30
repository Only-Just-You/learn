package com.heima.service.impl;

import com.heima.dao.IAccountDao;
import com.heima.dao.impl.AccountDaoImpl;
import com.heima.factory.BeanFactory;
import com.heima.service.IAccountService;

/**
 * 账户的业务实现类
 */
public class AccountServiceImpl implements IAccountService {
//    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    private int i = 1;
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
