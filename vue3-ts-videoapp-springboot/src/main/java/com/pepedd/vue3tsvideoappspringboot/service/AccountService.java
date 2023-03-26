package com.pepedd.vue3tsvideoappspringboot.service;

import com.pepedd.vue3tsvideoappspringboot.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author admin
* @description 针对表【td_account】的数据库操作Service
* @createDate 2023-03-26 16:24:47
*/
public interface AccountService extends IService<Account> {
  public Account login(String username, String password);
}
