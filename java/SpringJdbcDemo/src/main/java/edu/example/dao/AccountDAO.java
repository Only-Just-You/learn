package edu.example.dao;

import edu.example.domain.AccountUser;

public interface AccountDAO {
    AccountUser findByName(String name);
    void update(AccountUser accountUser);
}
