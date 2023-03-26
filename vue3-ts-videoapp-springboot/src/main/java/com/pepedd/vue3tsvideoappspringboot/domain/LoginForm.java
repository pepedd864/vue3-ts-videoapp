package com.pepedd.vue3tsvideoappspringboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {
  private String username;
  private String password;
  private String checkCode;
  private Integer userType;
}
