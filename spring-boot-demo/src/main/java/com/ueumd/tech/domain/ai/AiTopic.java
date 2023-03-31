package com.ueumd.tech.domain.ai;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * AI话题 配置表
 * </p>
 *
 * @author hsd
 * @since 2023-03-28
 */
@Data
public class AiTopic extends Model<AiTopic> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 图标
     */
	private String icon;
    /**
     * 内容
     */
	private String content;

	/**
	 * 级别
	 */
	private Integer level;

    /**
     * 创建时间
     */
	private Date createTime;

	private Integer deleted;

	@Override
	public Serializable pkVal() {
		return this.id;
	}

}
