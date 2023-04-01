package com.ueumd.tech.mapper.study;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ueumd.tech.domain.study.StudyOrders;

import java.util.List;

public interface StudyOrdersMapper extends BaseMapper<StudyOrders> {
    IPage<StudyOrders> findAllOrders(Page<StudyOrders> page);
    List<StudyOrders> findAllOrders2();
}
