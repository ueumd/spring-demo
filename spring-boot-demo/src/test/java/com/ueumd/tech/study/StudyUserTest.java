package com.ueumd.tech.study;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ueumd.tech.domain.study.StudyOrders;
import com.ueumd.tech.domain.study.StudyUser;
import com.ueumd.tech.mapper.study.StudyOrdersMapper;
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

    @Autowired
    private StudyOrdersMapper studyOrdersMapper;

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


    /**
     * SELECT id,user_name  FROM  USER
     */
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


    /**
     *
     * SELECT id,user_name,password,name,age FROM  USER
     * 把address排除
     *
     */
    @Test
    public void testSelect03(){
        QueryWrapper<StudyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(StudyUser.class, new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return !"address".equals(tableFieldInfo.getColumn());
            }
        });
        List<StudyUser> users = studyUserMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    /**
     * UpdateWrapper
     * 把ID大于1的 age 全部修改成99
     */

    @Test
    public void testUpdateWrapper(){
        UpdateWrapper<StudyUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.gt("id",1);
        updateWrapper.set("age",99);
        studyUserMapper.update(null,updateWrapper);
    }

    /**
     * 自定义方法
     */
    @Test
    public void testMyMethod() {
        StudyUser myUser = studyUserMapper.findMyUser(1L);
        System.out.println(myUser);
    }


    /**
     * 自定方法结合条件构造器
     */
    @Test
    public void testMyMethod2() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("id", 1);
        wrapper.eq("address", "山东");
        StudyUser myUser = studyUserMapper.findMyUserByWrapper(wrapper);
        System.out.println(myUser);
    }


    /**
     * 分页查询
     */

    @Test
    public void testPage(){
        IPage<StudyUser> page = new Page<>();
        //设置每页条数
        page.setSize(2);
        //设置查询第几页
        page.setCurrent(1);
        studyUserMapper.selectPage(page, null);
        List<StudyUser> list = page.getRecords();
        System.out.println("获取当前页的数据：" + list);//获取当前页的数据
        System.out.println("    获取总记录数：" +page.getTotal());//获取总记录数
        System.out.println("       当前页码：" + page.getCurrent());//当前页码
    }

    /**
     * 多表分页查询
     * SELECT
     * 	o.*,u.`user_name`
     * FROM
     * 	USER u, orders o
     * WHERE
     * 	o.`user_id` = u.`id`
     */
    @Test
    public void testPage2() {
        Page<StudyOrders> page = new Page<>();
        //设置每页大小
        page.setSize(2);
        //设置当前页码
        page.setCurrent(1);
        studyOrdersMapper.findAllOrders(page);
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }

    /**
     * 多表无分页查询
     */

    @Test
    public void testPage3() {
       List<StudyOrders> orders =  studyOrdersMapper.findAllOrders2();
        System.out.println(orders);
    }


    /**
     * 测试自动填充
     */
    @Test
    public void testFill() {
        StudyOrders studyOrders = new StudyOrders();
        studyOrders.setPrice(123);
        studyOrders.setId(1l);
        studyOrdersMapper.update(studyOrders, null);
    }

}
