package com.ac.ext.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnMsg {
    // 规范输出
    // 0 成功
    // 1xxx  参数输入问题
    // 2xxx  相关配置问题
    // 3xxx  异常报错
    // 4xxx  程序处理问题
    // 5xxx  程序响应问题
    // 自定义  ..........
    private String code;
    private String msg;
    private Object data;


    public ReturnMsg(String code, String msg){
        this.code= code;
        this.msg= msg;
    }



}
