package com.pepedd.vue3tsvideoappspringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pepedd.vue3tsvideoappspringboot.domain.Comment;
import com.pepedd.vue3tsvideoappspringboot.service.CommentService;
import com.pepedd.vue3tsvideoappspringboot.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【td_comment】的数据库操作Service实现
* @createDate 2023-03-26 16:25:03
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




