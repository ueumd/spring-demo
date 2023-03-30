package com.ueumd.tech.service.ai;


import com.ueumd.tech.entity.AiRoleListPo;
import com.ueumd.tech.entity.AiRoleListVO;

import java.util.List;

/**
 * <p>
 * AI角色配置表 服务类
 * </p>
 *
 * @author hsd
 * @since 2023-03-27
 */
public interface IAiRoleService {

    AiRoleListVO selectById(int id);

    List<AiRoleListVO> getAiRoleList();

    List<AiRoleListPo> getAiRoleListPo();
}
