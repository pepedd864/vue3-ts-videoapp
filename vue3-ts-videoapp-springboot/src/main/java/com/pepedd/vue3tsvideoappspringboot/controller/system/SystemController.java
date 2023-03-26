package com.pepedd.vue3tsvideoappspringboot.controller.system;

import com.pepedd.vue3tsvideoappspringboot.domain.LoginForm;
import com.pepedd.vue3tsvideoappspringboot.service.AccountService;
import com.pepedd.vue3tsvideoappspringboot.utils.Code;
import com.pepedd.vue3tsvideoappspringboot.utils.CreateVerifiCodeImage;
import com.pepedd.vue3tsvideoappspringboot.utils.MD5;
import com.pepedd.vue3tsvideoappspringboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName SystemController
 * @Description TODO
 * @Date 2023/3/26 16:42
 * @Created by admin
 */
@RestController
@RequestMapping("/api/system")
public class SystemController {
  @Autowired
  private AccountService accountService;

  @GetMapping("/checkCodeImage")
  public void getCheckCodeImage(HttpSession session, HttpServletResponse response) throws IOException {
    // 获取验证码图片
    BufferedImage checkCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
    // 获取验证码图片中的值
    String verifiCode = new String(CreateVerifiCodeImage.getVerifiCode());
    System.out.println("verifiCode = " + verifiCode);
    // 将验证码中的值保存到session中 用于登录时校验
    session.setAttribute("code", verifiCode);
    System.out.println("code = " + session.getAttribute("code"));
    // 将验证码图片响应给客户端
    ImageIO.write(checkCodeImage, "jpg", response.getOutputStream());
  }

  @PostMapping("/login")
  public Result login(@RequestBody LoginForm loginForm, HttpSession session) {
    // 获取的验证码
    String code = (String) session.getAttribute("code");
    // 获取用户输入的用户名
    String username = loginForm.getUsername();
    // 获取用户输入的密码
    String password = MD5.encrypt(loginForm.getPassword());
    // 获取用户输入的验证码
    String inputCode = loginForm.getCheckCode();
    System.out.println("code = " + code + ", username = " + username + ", password = " + password + ", inputCode = " + inputCode);
    // 判断验证码是否正确
    if (!code.equalsIgnoreCase(inputCode)) {
      return new Result(Code.GET_ERR, "验证码错误", null);
    }
    // 销毁验证码
    session.removeAttribute("code");
    // 判断用户名密码是否正确
    if (accountService.login(username, password) == null) {
      return new Result(Code.GET_ERR, "用户名或密码错误", null);
    } else {
      return new Result(Code.GET_OK, "登录成功", null);
    }
  }
}
