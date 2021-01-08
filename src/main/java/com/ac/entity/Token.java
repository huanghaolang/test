package com.ac.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "token")
public class Token {

    /**
     * jwt头部
     */
    private Map<String, Object> headerClaims;

    /**
     * jwt有效载荷
     */
    private String iss; //发行人
    private Date exp;   //到期时间
    private String sub; //主题
    private String aud; //用户
    private String nbf; //在此之前不可用
    private Date iat;   //发布时间
    private String id;
    private String password;
    private int interval;
    private String roleId;

    /*
     *  签名
     */

}
