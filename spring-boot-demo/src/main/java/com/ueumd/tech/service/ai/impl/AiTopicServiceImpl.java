package com.ueumd.tech.service.ai.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ueumd.tech.entity.ai.AiTopic;
import com.ueumd.tech.mapper.ai.AiTopicMapper;
import com.ueumd.tech.service.ai.IAiTopicService;
import com.ueumd.tech.vo.AiTopicListVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 话题配置表 服务实现类
 * </p>
 *
 * @author hsd
 * @since 2023-03-28
 */
@Service
public class AiTopicServiceImpl extends ServiceImpl<AiTopicMapper, AiTopic> implements IAiTopicService {

    @Override
    public List<AiTopicListVO> getTopicList() {
        LambdaQueryWrapper<AiTopic> queryWrapper = new LambdaQueryWrapper<>();
        List<AiTopic> aiRoles = this.baseMapper.selectList(queryWrapper);
        return aiRoles.stream().map(aiRole -> {
            AiTopicListVO aiTopicListVO = new AiTopicListVO();
            BeanUtils.copyProperties(aiRole, aiTopicListVO);
            return aiTopicListVO;
        }).collect(Collectors.toList());
    }
}
