package com.ueumd.tech.entity;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author hsd
 * @since 2023-03-28
 */
@Data
public class AiTopicListVO {

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


}
