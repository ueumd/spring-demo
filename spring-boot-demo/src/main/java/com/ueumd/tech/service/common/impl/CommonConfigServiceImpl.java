package com.ueumd.tech.service.common.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ueumd.tech.entity.common.CommonConfig;
import com.ueumd.tech.mapper.common.CommonConfigMapper;
import com.ueumd.tech.service.common.CommonConfigService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 键值对 存储数据结构 服务实现类
 * </p>
 *
 * @author hsd
 * @since 2023-03-24
 */
@Service
public class CommonConfigServiceImpl extends ServiceImpl<CommonConfigMapper, CommonConfig> implements CommonConfigService {

    @Override
    public JSONObject getByKey(String key) {
        LambdaQueryWrapper<CommonConfig> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CommonConfig::getConfigKey, key);
        CommonConfig commonConfig = this.baseMapper.selectOne(queryWrapper);
        if (commonConfig!=null) {
            return JSONObject.parseObject(commonConfig.getConfigValue());
        }
        return new JSONObject();
    }
}
