package com.ueumd.tech.ai;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ueumd.tech.domain.ai.AiTopic;
import com.ueumd.tech.mapper.ai.AiTopicMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * MP 学习
 */
@SpringBootTest
public class AiTopicMapperTest {
    @Autowired
    private AiTopicMapper aiTopicMapper;


    @Test
    public void getAll() {
        List<AiTopic> aiTopics = aiTopicMapper.selectList(null);
        aiTopics.forEach(System.out::println);
    }

    @Test
    public void deleteById() {
        aiTopicMapper.deleteById(34);
    }


    /**
     * 与 pagehelper 会有冲突问题
     * 分页查询
     */
    @Test
    public void getAllByPage() {
        Page<AiTopic> page = new Page<>(1, 3);
        aiTopicMapper.selectPage(page, null);
        System.out.println("总数：" + page.getTotal());
        System.out.println("当前页：" + page.getCurrent());
        List<AiTopic> records = page.getRecords();
        records.forEach(System.out::println);
    }


    /**
     * 条件构造器 （不推荐）
     */
    @Test
    public void select() {
        // 这种方式不好之处在于字段写错了也不错，检测不到
        QueryWrapper<AiTopic> wrapper = new QueryWrapper<>();

        // 条件构造器
        // 查询id 大于 10的数据
        wrapper.gt("id", 10);

        // 按ID降序
        wrapper.orderByDesc("id");
        List<AiTopic> aiTopics = aiTopicMapper.selectList(wrapper);
        aiTopics.forEach(System.out::println);
    }

    @Test
    public void select2() {
        LambdaQueryWrapper<AiTopic> wrapper = new LambdaQueryWrapper<>();

        // 条件构造器

        // 查询id 大于 10的数据
        wrapper.gt(AiTopic::getId, 10);
        wrapper.likeRight(AiTopic::getContent, "t");

        // 按ID降序
        wrapper.orderByDesc(AiTopic::getId);
        List<AiTopic> aiTopics = aiTopicMapper.selectList(wrapper);
        aiTopics.forEach(System.out::println);
    }
}
