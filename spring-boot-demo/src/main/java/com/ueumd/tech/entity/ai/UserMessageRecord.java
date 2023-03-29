package com.ueumd.tech.entity.ai;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户消息记录表
 * </p>
 *
 * @author hsd
 * @since 2023-03-23
 */
@Data
public class UserMessageRecord extends Model<UserMessageRecord> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户ID
     */
	private Integer userId;
    /**
     * 文本消息
     */
	private String message;
    /**
     * 语音地址
     */
	private String audioUrl;
    /**
     * 语音时长（s）
     */
	private Integer timeDuration;
    /**
     * 发送时间
     */
	private Date createTime;


	@Override
	public Serializable pkVal() {
		return this.id;
	}

}
