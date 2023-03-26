package com.pepedd.vue3tsvideoappspringboot.controller;

import com.pepedd.vue3tsvideoappspringboot.service.ChannelService;
import com.pepedd.vue3tsvideoappspringboot.utils.Code;
import com.pepedd.vue3tsvideoappspringboot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {

  @Autowired
  private ChannelService channelService;

  @GetMapping("/channel")
  public Result getChannel() {
    return new Result(Code.GET_OK, "请求成功",channelService.list());
  }
}
