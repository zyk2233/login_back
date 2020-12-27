package com.zyk.service;

import com.zyk.domain.Account;
import java.util.List;

public interface AccountService {
    void addAccount(Account account);       //添加
    void removeAccount(int id);             //删除
    void modifyAccount(Account account);     //修改
    Account matchingAccount(Account account);   //检查账号密码是否存在/正确
    List<Account> findAll();    //查找全部
}
