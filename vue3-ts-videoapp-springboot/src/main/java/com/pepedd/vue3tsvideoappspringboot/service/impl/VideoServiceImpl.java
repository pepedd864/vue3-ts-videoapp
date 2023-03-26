package com.pepedd.vue3tsvideoappspringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pepedd.vue3tsvideoappspringboot.domain.Video;
import com.pepedd.vue3tsvideoappspringboot.service.VideoService;
import com.pepedd.vue3tsvideoappspringboot.mapper.VideoMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【td_video】的数据库操作Service实现
* @createDate 2023-03-26 16:25:07
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
    implements VideoService{

}




