package com.ueumd.tech.controller.study;

import com.ueumd.tech.common.vo.ResponseDTO;
import com.ueumd.tech.domain.study.StudyUser;
import com.ueumd.tech.service.study.IStudyUserService;
import com.ueumd.tech.service.study.IStudyUserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  - @RequestParam   ?phoneNum=xxxxxx
 *  - @PathVariable   value="/getId/{uid}"
 *  - @RequestBody    RequestBody能把简单json结构参数转换成实体类
 *
 *
 *  区别              @RequestParam               @RequestBody
 * content-type      仅支持x-www-form-urlencoded  支持json格式
 * 请求类型           ALL                          除了GET
 * 注解个数           可多个                        只能一个
 */

@RestController
@RequestMapping("/study")
public class StudyUserController {

    @Autowired
    private IStudyUserService studyUserService;

    @Autowired
    private IStudyUserService2 studyUserService2;


    @GetMapping("/list")
    public ResponseDTO<List<StudyUser>> listResponseDTO(){
        List<StudyUser> list = studyUserService.list();
        return new ResponseDTO<>(list);
    }

    @GetMapping("/getUserById")
    public ResponseDTO<StudyUser> getUserById(@RequestParam long id){
        StudyUser user = studyUserService2.getUserById(id);
        return new ResponseDTO<>(user);
    }

    /**
     * ========================== RequestBody ========================================
     * JSON 请求格式
     * @param user
     * @return
     */
    @PostMapping("/getUserByJson")
    public ResponseDTO<StudyUser> getUserByJson(@RequestBody StudyUser user){
        // 返回user对象的字段
        return new ResponseDTO<>(user);
        /**
         * {
         *   "errCode": 0,
         *   "message": "操作成功！",
         *   "data": {
         *     "id": null,
         *     "userName": null,
         *     "password": null,
         *     "name": "springboot",
         *     "age": 1,
         *     "address": null
         *   }
         * }
         */
    }

    @PostMapping("/getUserByJsonList")
    public ResponseDTO<List<StudyUser>> getUserByJson(@RequestBody List<StudyUser> user){
        // 返回user对象的字段
        return new ResponseDTO<>(user);
    }

    @PostMapping("/getUserByMap")
    public ResponseDTO<Map> getUserByJson(@RequestBody Map map){
        // 只返回传递过来的数据
        return new ResponseDTO<>(map);

        /**
         * {
         *   "errCode": 0,
         *   "message": "操作成功！",
         *   "data": {
         *     "name": "springboot",
         *     "age": 1
         *   }
         * }
         */
    }

    /**
     * ========================== RequestParam ========================================
     * QueryString 请求格式
     * @return
     */

    @GetMapping("/testRequestParam")
    public ResponseDTO<Map> testRequestParam(Integer id, String name, String[] likes){
        Map map = new HashMap();
        map.put("id", id);
        map.put("name", name);
        map.put("likes", likes);
        return new ResponseDTO<>(map);
        /**
         * {
         *   "errCode": 0,
         *   "message": "操作成功！",
         *   "data": {
         *     "name": "spring",
         *     "id": 200,
         *     "likes": [
         *       "go",
         *       "java"
         *     ]
         *   }
         * }
         */
    }

    /**
     * 请求参数和字段不一样，使用 @RequestParam 映射
     *  required = false 可以不用传参，如果不加默认必须要传参，不传报400
     *  defaultValue 默认值
     * @param uid
     * @param name
     * @param likes
     * @return
     */
    @GetMapping("/testRequestParamHello")
    public ResponseDTO<Map> testRequestParamHello(
            @RequestParam(value = "id", required = false, defaultValue = "111") Integer uid,
            @RequestParam("username") String name,
            @RequestParam("likes") String[] likes
    ){
        Map map = new HashMap();
        map.put("id", uid);
        map.put("username", name);
        map.put("likes", likes);
        return new ResponseDTO<>(map);

        /**
         * {
         *   "errCode": 0,
         *   "message": "操作成功！",
         *   "data": {
         *     "id": 100,
         *     "username": "spring",
         *     "likes": [
         *       "vue",
         *       "react"
         *     ]
         *   }
         * }
         */
    }
}
