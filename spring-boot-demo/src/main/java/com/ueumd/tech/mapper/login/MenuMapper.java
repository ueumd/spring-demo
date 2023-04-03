package com.ueumd.tech.mapper.login;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ueumd.tech.domain.login.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(Long userid);
}
