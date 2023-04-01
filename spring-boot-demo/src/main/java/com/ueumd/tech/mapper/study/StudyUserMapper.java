package com.ueumd.tech.mapper.study;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ueumd.tech.domain.study.StudyUser;
import org.apache.ibatis.annotations.Param;

public interface StudyUserMapper extends BaseMapper<StudyUser> {
    StudyUser findMyUser(Long id);

    /**
     * 自定方法结合条件构造器
     * @param wrapper
     * @return
     */
    StudyUser findMyUserByWrapper(@Param(Constants.WRAPPER) Wrapper<StudyUser> wrapper);
}
