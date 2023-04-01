package com.ueumd.tech.controller.study;

import com.ueumd.tech.common.vo.ResponseDTO;
import com.ueumd.tech.domain.study.StudyUser;
import com.ueumd.tech.service.study.IStudyUserService;
import com.ueumd.tech.service.study.IStudyUserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
