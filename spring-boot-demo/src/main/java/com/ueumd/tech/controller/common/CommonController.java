package com.ueumd.tech.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.ueumd.tech.common.constant.CommonConstant;
import com.ueumd.tech.common.constant.VersionValue;
import com.ueumd.tech.common.vo.ResponseDTO;
import com.ueumd.tech.service.common.CommonConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("common")
public class CommonController {

    @Autowired
    private CommonConfigService commonConfigService;


    @GetMapping(VersionValue.V1 + "getSystemDate")
    public ResponseDTO<String> getSystemDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String now = df.format(System.currentTimeMillis());
        return  new ResponseDTO<>(now);
    }

    @GetMapping (VersionValue.V1 + "startChat")
    public ResponseDTO<List<String>> startChat(@RequestParam("content") String content) {
        JSONObject object = commonConfigService.getByKey(CommonConstant.START_CHAT);
        List<String> list = (List<String>)object.get(content);
        return  new ResponseDTO<>(list);
    }


    /**
     * 话题
     * @param content
     * @return
     */
    @GetMapping (VersionValue.V1 + "getTopics")
    public ResponseDTO<List<String>> getTopics(@RequestParam("content") String content) {
        JSONObject object = commonConfigService.getByKey(CommonConstant.TOPIC);
        List<String> list = (List<String>)object.get(content);
        return  new ResponseDTO<>(list);
    }
}
