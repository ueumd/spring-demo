package com.ueumd.tech.controller.study;
import com.ueumd.tech.common.vo.ResponseDTO;
import com.ueumd.tech.entity.AiRoleListPo;
import com.ueumd.tech.entity.AiRoleListVO;
import com.ueumd.tech.service.ai.IAiRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * domain 对应数据库里的字段
 *
 * DO PO DTO VO数据流转关系
 *
 * 1. DO --> 控制器返回
 * 2. 2.DO --> PO --> 控制器返回
 * 3. DO --> VO --> 控制器返回
 * 4. DO --> PO --> VO --> 控制器返回
 * 5. DO --> DTO --> 控制器返回
 * 6. DO --> PO--> DTO --> 控制器返回
 */
@RestController
@RequestMapping("/pojo")
public class DoPoDtoVoController {

    @Autowired
    private IAiRoleService aiRoleService;

    /**
     * AI 情景模拟角色
     * @return
     */
    @GetMapping("/getAiRoleListPo")
    public ResponseDTO<List<AiRoleListPo>>getAiRoleListPo() {
        List<AiRoleListPo> aiRoleListVOS = aiRoleService.getAiRoleListPo();
        return new ResponseDTO<>(aiRoleListVOS);
    }


    @GetMapping("/getAiRoleListVo")
    public ResponseDTO<List<AiRoleListVO>>getAiRoleList() {
        List<AiRoleListVO> aiRoleListVOS = aiRoleService.getAiRoleList();
        return new ResponseDTO<>(aiRoleListVOS);
    }
}
