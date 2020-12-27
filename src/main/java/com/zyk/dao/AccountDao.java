package com.zyk.dao;

import com.zyk.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDao {
    void addAccount(Account account);
    void removeAccount(int id);
    Account findAccountByUsername(String username);
    void updateAccount(Account account);

    List<Account> findAll();
}
