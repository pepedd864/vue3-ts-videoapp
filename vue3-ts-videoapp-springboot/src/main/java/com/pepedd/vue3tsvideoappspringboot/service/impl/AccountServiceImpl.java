package com.pepedd.vue3tsvideoappspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pepedd.vue3tsvideoappspringboot.domain.Account;
import com.pepedd.vue3tsvideoappspringboot.mapper.AccountMapper;
import com.pepedd.vue3tsvideoappspringboot.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author admin
 * @description 针对表【td_account】的数据库操作Service实现
 * @createDate 2023-03-26 16:24:47
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService {
  @Resource
  private AccountMapper accountMapper;

  @Override
  public Account login(String username, String password) {
    // 判断用户名密码是否正确
    return accountMapper.selectOne(new LambdaQueryWrapper<Account>().eq(Account::getUsername, username).eq(Account::getPassword, password));
  }
}




