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
 * @TableName td_video
 */
@TableName(value ="td_video")
@Data
public class Video implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer channelid;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private String lang;

    /**
     * 
     */
    private String img;

    /**
     * 
     */
    private String src;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}