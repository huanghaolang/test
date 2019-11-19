package com.ac.controller;


import com.ac.annotation.UserLoginToken;
import com.ac.entity.TUser;
import com.ac.jwtToken.TokenUtil;
import com.ac.service.ITUserService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>
 * 数据库目录 前端控制器
 * </p>
 *
 * @author 1
 * @since 2019-11-06
 */
@RestController
@RequestMapping("/t-user")
@Api(description = "code操作")
public class TUserController {

    @Resource
    private ITUserService userService;

    @PostMapping("/login")
    @ApiOperation(httpMethod = "POST", value = "登陆", produces = MediaType.APPLICATION_JSON_VALUE)
    public Object login(String userId, String userPwd, HttpServletResponse response){
        JSONObject jsonObject=new JSONObject();

       /* QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("USER_ID",user.getUserId());
        queryWrapper.eq("USER_PWD",user.getUserPwd());*/
        TUser userForBase=userService.getById(userId);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getUserPwd().equals(userPwd)){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = TokenUtil.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    @ApiOperation(value = "Count the number of entities associated" , authorizations =@Authorization(value = "token"))
    public String getMessage(HttpServletResponse response){

        return "你已通过验证";
    }


}
