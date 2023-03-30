package com.ueumd.tech.domain.common;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 键值对 存储数据结构
 * </p>
 *
 * @author hsd
 * @since 2023-03-24
 */
@Data
@TableName("t_common_config")
public class CommonConfig extends Model<CommonConfig> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 键
     */
	private String configKey;
    /**
     * 备注
     */
	private String remark;
    /**
     * 值
     */
	private String configValue;
    /**
     * 活动创建时间
     */
	private Date createTime;


	@Override
	public Serializable pkVal() {
		return this.id;
	}

}
