package com.pepedd.vue3tsvideoappspringboot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName td_comment
 */
@TableName(value ="td_comment")
@Data
public class Comment implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 
     */
    private Integer videoid;

    /**
     * 
     */
    private String user;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Date date;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}