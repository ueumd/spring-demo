package com.ueumd.tech.service.ai;

import com.ueumd.tech.vo.AiTopicListVO;

import java.util.List;


/**
 * <p>
 * AI 话题配置表 服务类
 * </p>
 *
 * @author hsd
 * @since 2023-03-28
 */
public interface IAiTopicService {

    List<AiTopicListVO> getTopicList();
}
