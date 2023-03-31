package com.ueumd.tech.study;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.ueumd.tech.domain.study.StudyUser;
import com.ueumd.tech.mapper.study.StudyUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@SpringBootTest
public class StudyUserTest {
    @Autowired
    private StudyUserMapper studyUserMapper;

    @Test
    public void testQueryList(){
        List<StudyUser> studyUsers = studyUserMapper.selectList(null);
        System.out.println(studyUsers);
    }

    @Test
    public void testInsert() {
        StudyUser studyUser = new StudyUser();
        studyUser.setUserName("三更草堂11");
        studyUser.setPassword("1111");
        studyUserMapper.insert(studyUser);
    }

    @Test
    public void deleteById() {
        int i = studyUserMapper.deleteById(6);
        System.out.println(i);
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "三更草堂11");
        int i = studyUserMapper.deleteByMap(map);
        System.out.println(i);
    }

    @Test
    public void testUpdate(){
        //把id为2的用户的年龄改为14
        StudyUser user = new StudyUser();
        user.setId(2L);
        user.setAge(14);
        int i = studyUserMapper.updateById(user);
        System.out.println(i);
    }

    /**
     * 常用QueryWrapper方法
     * QueryWrapper的 select 可以设置要查询的列。
     */

    @Test
    public void select1() {
        QueryWrapper<StudyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "user_name");
        List<StudyUser> studyUsers = studyUserMapper.selectList(queryWrapper);
        System.out.println(studyUsers);
    }
    @Test
    public void testSelect02(){
        QueryWrapper<StudyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(StudyUser.class, new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return "user_name".equals(tableFieldInfo.getColumn());
            }
        });
        List<StudyUser> users = studyUserMapper.selectList(queryWrapper);
        System.out.println(users);
    }


}
