package com.ueumd.tech.service.study.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ueumd.tech.domain.study.StudyUser;
import com.ueumd.tech.mapper.study.StudyUserMapper;
import com.ueumd.tech.service.study.IStudyUserService2;
import org.springframework.stereotype.Service;


/**
 * 自定义方法
 */
@Service
public class StudyUserServiceImpl2 extends ServiceImpl<StudyUserMapper, StudyUser> implements IStudyUserService2 {

    @Override
    public StudyUser getUserById(long id) {
        StudyUserMapper baseMapper1 = getBaseMapper();

        StudyUser studyUser = this.getById(id);
        if (studyUser == null) return null;
        return baseMapper1.findMyUser(id);

    }
}
