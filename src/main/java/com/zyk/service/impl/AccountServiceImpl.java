package com.zyk.service.impl;

import com.zyk.dao.AccountDao;
import com.zyk.domain.Account;
import com.zyk.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao account;
    //添加账户
    public void addAccount(Account account){
        this.account.addAccount(account);
    }
    //删除账户
    public void removeAccount(int id) {
        this.account.removeAccount(id);
    }
    //修改账户信息
    public void modifyAccount(Account account) {
        this.account.updateAccount(account);
    }
    //确认账户是否存在,存在则返回账户信息
    public Account matchingAccount(Account account){
        Account ac = this.account.findAccountByUsername(account.getUsername());
        if(ac!=null)
            if(ac.getPassword().equals(account.getPassword())){
                return ac;
            }
        return null;
    }
    //查找全部用户信息
    public List<Account> findAll(){
        return this.account.findAll();
    }
}
