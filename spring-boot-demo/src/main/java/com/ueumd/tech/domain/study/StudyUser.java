package com.ueumd.tech.domain.study;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyUser {
    @TableId(type= IdType.AUTO)
    private Long id;
    private String userName ;
    private String password;
    private String name;
    private Integer age;
    private String address ;
}
