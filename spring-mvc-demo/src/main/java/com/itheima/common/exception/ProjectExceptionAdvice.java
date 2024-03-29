package com.itheima.common.exception;

import com.itheima.common.util.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.itheima.common.util.Code;

/**
 * 异常处理类
 * SpringMvcConfig.java
 * @ComponentScan({"com.itheima.controller","com.itheima.config", "com.itheima.common"})
 *
 * 业务层就不需要一个一个写异常
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {

//    @ExceptionHandler(Exception.class)
//    public Result doException(Exception exception) {
//        System.out.println("异常处理");
//        return new Result(null, 666, "服务异常");
//    }


    //@ExceptionHandler用于设置当前处理器类对应的异常类型
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    //除了自定义的异常处理器，保留对Exception类型的异常处理，用于处理非预期的异常
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试！");
    }
}
