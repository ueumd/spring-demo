package com.ueumd.tech.domain.ai;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * AI角色配置表
 * </p>
 *
 * @author hsd
 * @since 2023-03-27
 */
@Data
public class AiRole extends Model<AiRole> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户名
     */
	private String username;
    /**
     * 角色定位
     */
	private String role;

	/**
	 * 角色类型
	 */
	private Integer roleType;
    /**
     * 使用场景
     */
	private String scene;
    /**
     * 提示
     */
	private String prompt;
    /**
     * 介绍
     */
	private String introduce;

	private String headUrl;

	private Boolean isDelete;
    /**
     * 创建时间
     */
	private Date createTime;


	@Override
	public Serializable pkVal() {
		return this.id;
	}

}
