package com.ueumd.tech.entity;

import lombok.Data;

/**
 *
 * @author hsd
 * @since 2023-03-27
 */
@Data
public class AiRoleListVO  {

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


}
