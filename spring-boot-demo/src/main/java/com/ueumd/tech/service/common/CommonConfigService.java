package com.ueumd.tech.service.common;


import com.alibaba.fastjson.JSONObject;

/**
 * <p>
 * 键值对 存储数据结构 服务类
 * </p>
 *
 * @author 夏鹏
 * @since 2023-03-24
 */
public interface CommonConfigService {

    JSONObject getByKey(String key);

}
