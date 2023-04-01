package com.ueumd.tech.service.study.impl;

import com.ueumd.tech.domain.study.StudyUser;
import com.ueumd.tech.mapper.study.StudyUserMapper;
import com.ueumd.tech.service.study.IStudyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudyUserServiceImpl implements IStudyUserService {

    @Autowired
    private StudyUserMapper studyUserMapper;

    @Override
    public List<StudyUser> list() {
        return  studyUserMapper.selectList(null);
    }
}
