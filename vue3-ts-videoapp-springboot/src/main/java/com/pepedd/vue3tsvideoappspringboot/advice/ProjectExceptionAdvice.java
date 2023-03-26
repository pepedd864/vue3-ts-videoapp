package com.pepedd.vue3tsvideoappspringboot.advice;

import com.pepedd.vue3tsvideoappspringboot.utils.Code;
import com.pepedd.vue3tsvideoappspringboot.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @ClassName ProjectExceptionAdvice
 * @Description TODO
 * @Date 2023/3/26 21:54
 * @Created by admin
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
  @ExceptionHandler
  public Result handleException(Exception e) {
    // 记录日志
    // ...

    // 打印异常信息
    System.out.println("出现异常，请处理！！！");
    e.printStackTrace();
    return new Result(Code.SYS_ERR, e.getMessage(), null);
  }
}
