package com.zyk.controller;

import com.zyk.domain.Account;
import com.zyk.service.AccountService;
import com.zyk.tool.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/account")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;

    //登录
    @ResponseBody
    @RequestMapping(path = "/login")
    public Msg login(@RequestParam(value = "username",required = true) String username,
                     @RequestParam(value = "password",required = true) String password){
        Account account = this.accountService.matchingAccount(new Account(username,password));
        if (account != null){
            return Msg.success().add("account",account);
        }
        return Msg.fail().add("message","用户不存在");
    }

    //测试
    @RequestMapping("/findAll")
    public String findAll() {
        List<Account> list = this.accountService.findAll();
        for (Account item : list) {
            System.out.println(item.toString());
        }
        return "success";
    }
}
