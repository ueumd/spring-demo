package com.ueumd.tech.service.ai.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ueumd.tech.domain.ai.AiRole;
import com.ueumd.tech.entity.AiRoleListPo;
import com.ueumd.tech.mapper.ai.AiRoleMapper;
import com.ueumd.tech.service.ai.IAiRoleService;
import com.ueumd.tech.entity.AiRoleListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * AI角色配置表 服务实现类
 * </p>
 *
 * @author hsd
 * @since 2023-03-27
 */
@Service
public class AiRoleServiceImpl extends ServiceImpl<AiRoleMapper, AiRole> implements IAiRoleService {

    @Override
    public AiRoleListVO selectById(int id) {
        AiRole aiRole = this.getById(id);
        if (aiRole == null) return null;
        AiRoleListVO aiRoleListVO = new AiRoleListVO();
        BeanUtils.copyProperties(aiRole, aiRoleListVO);
        return aiRoleListVO;
    }

    @Override
    public List<AiRoleListVO> getAiRoleList() {
        LambdaQueryWrapper<AiRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AiRole::getIsDelete, false);
        List<AiRole> aiRoles = this.baseMapper.selectList(queryWrapper);
        return aiRoles.stream().map(aiRole -> {
            AiRoleListVO aiRoleListVO = new AiRoleListVO();
            BeanUtils.copyProperties(aiRole, aiRoleListVO);
            return aiRoleListVO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<AiRoleListPo> getAiRoleListPo() {
        LambdaQueryWrapper<AiRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AiRole::getIsDelete, false);
        List<AiRole> aiRoles = this.baseMapper.selectList(queryWrapper);
        return aiRoles.stream().map(aiRole -> {
            AiRoleListPo aiRoleListPo = new AiRoleListPo();
            BeanUtils.copyProperties(aiRole, aiRoleListPo);
            return aiRoleListPo;
        }).collect(Collectors.toList());
    }
}
