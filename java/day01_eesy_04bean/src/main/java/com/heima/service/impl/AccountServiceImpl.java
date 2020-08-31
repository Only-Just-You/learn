package com.heima.service.impl;

import com.heima.service.IAccountService;

/**
 * 账户的业务实现类
 */
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        System.out.println("services中的saveAccount方法执行了");
    }
}
