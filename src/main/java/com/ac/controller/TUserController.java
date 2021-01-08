package com.ac.controller;


import com.ac.annotation.UserLoginToken;
import com.ac.entity.TUser;
import com.ac.ext.entity.ReturnMsg;
import com.ac.initBinder.DataBinder;
import com.ac.jwtToken.TokenUtil;
import com.ac.service.ITUserService;
import com.auth0.jwt.interfaces.Claim;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * <p>
 * 数据库目录 前端控制器
 * </p>
 *
 * @author 1
 * @since 2019-11-06
 */
@RestController
@RequestMapping("/User")
@Api(description = "用户操作")
public class TUserController {

    @Resource
    private ITUserService userService;


    @Resource
    private TokenUtil tokenUtil;

    @PostMapping("/login")
    @ApiOperation(httpMethod = "POST", value = "登陆", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnMsg login(String userId, String userPwd, HttpServletResponse response, HttpServletRequest request) {
        // response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        ReturnMsg returnMsg = null;
        try {
            Map<String, Object> map = new HashMap<>();
            TUser userForBase = userService.getById(userId);
            if (userForBase == null) {
                returnMsg = new ReturnMsg("0", "登录失败,用户不存在", null);
            } else {
                if (!userForBase.getUserPwd().equals(userPwd)) {
                    returnMsg = new ReturnMsg("0", "密码不匹配", null);
                } else {
                    map.put("token", tokenUtil.getFinalToken(userForBase));
                    map.put("user", userForBase);
                    returnMsg = new ReturnMsg("0", "登录成功", map);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnMsg = new ReturnMsg("30001", e.getMessage(), null);
        }


        return returnMsg;
    }

    @PostMapping("/loginByToken")
    @ApiOperation(httpMethod = "POST", value = "token检查", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnMsg loginByToken(String token, HttpServletResponse response, HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        ReturnMsg returnMsg = null;
        try {
            Map<String, Claim> claims = tokenUtil.verifyToken(token);
            String userId = claims.get("userId").asString();
            String userPwd = claims.get("userPwd").asString();
            Map<String, Object> map = new HashMap<>();

            TUser userForBase = userService.getById(userId);
            if (userForBase == null) {
                returnMsg = new ReturnMsg("10001", "登录失败,用户不存在", null);
            } else {
                if (!userForBase.getUserPwd().equals(userPwd)) {
                    returnMsg = new ReturnMsg("10002", "密码不匹配", null);
                } else {
                    token = tokenUtil.getFinalToken(userForBase);
                    map.put("token", token);
                    map.put("user", userForBase);
                    returnMsg = new ReturnMsg("0", "token验证成功", map);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnMsg = new ReturnMsg("30001", e.getMessage(), null);
        }


        return returnMsg;
    }


    @PostMapping("/get")
    @ApiOperation(httpMethod = "POST", value = "获取用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnMsg getUser(TUser user, Page page, @RequestParam(value = "userSexs[]", required = false) List<String> userSexs,
                              @RequestParam(value = "roleIds[]", required = false) List<String> roleIds,
                              @RequestParam(value = "dateQuantum[]", required = false) List<Date> dateQuantum,
                              HttpServletResponse response, HttpServletRequest request) {
        // response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        ReturnMsg returnMsg = null;
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String, Object> map = new HashMap<>();
        try {
            if (user.getUserName() != null && user.getUserName().trim().length() != 0) {
                queryWrapper.like("USER_NAME", user.getUserName());
            }
            if (userSexs != null && userSexs.size() > 0) {
                queryWrapper.in("USER_SEX", userSexs);
            }
            if (roleIds != null && roleIds.size() > 0) {
                queryWrapper.in("ROLEID", roleIds);
            }
            /*if (dateQuantum != null && dateQuantum.size() > 0) {
                queryWrapper.between("CRT_DATE",
                        dateQuantum.get(0),
                        dateQuantum.get(1));
            }*/
            map.put("data", userService.page(page, queryWrapper));
            returnMsg = new ReturnMsg("0", "success", map);
        } catch (Exception e) {
            e.printStackTrace();
            returnMsg = new ReturnMsg("30001", e.getMessage(), null);
        }


        return returnMsg;
    }

    @PostMapping("save")
    @ApiOperation(httpMethod = "POST", value = "新增或修改用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnMsg saveUser(TUser user,@RequestParam(value = "userDesc[]",required = false) List<String> userdescs){
        ReturnMsg returnMsg = new ReturnMsg();
        QueryWrapper queryWrapper = new QueryWrapper();
        try {
            if(user.getUserId()!=null && user.getUserId().trim()!=""){
                if(userService.updateById(user)){
                    returnMsg.setCode("0");
                    returnMsg.setMsg("修改用户信息成功");
                }else{
                    returnMsg.setCode("1");
                    returnMsg.setMsg("修改用户信息失败");
                }
            }else{
                user.setUserId(UUID.randomUUID().toString());
                if(userService.save(user)){
                    returnMsg.setCode("0");
                    returnMsg.setMsg("新增用户成功");
                }else{
                    returnMsg.setCode("1");
                    returnMsg.setMsg("新增用户失败");
                }
            }
        }catch (Exception e){
            returnMsg.setCode("3");
            returnMsg.setMsg(e.getMessage());
        }

        return returnMsg;
    }

    @PostMapping("delete")
    @ApiOperation(httpMethod = "POST", value = "删除用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnMsg deleteUser(TUser user){
        ReturnMsg returnMsg = null;
        try {

            if(userService.removeById(user.getUserId())){
                returnMsg= new  ReturnMsg("0","删除成功");
            }else{
                returnMsg= new  ReturnMsg("1","删除失败");

            }
        }catch(Exception e ){
            e.printStackTrace();
            returnMsg= new  ReturnMsg("2",e.getMessage());

        }
        return returnMsg;
    }

    @PostMapping("batchDel")
    @ApiOperation(httpMethod = "POST", value = "批量用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    public ReturnMsg delUsers(@RequestParam(value = "ids[]") List<List<String>> ids){
        ReturnMsg returnMsg = null;
        try {
            //userService.batch
            if(userService.removeByIds(null)){
                returnMsg= new  ReturnMsg("0","批量删除成功");
            }else{
                returnMsg= new  ReturnMsg("1","批量删除失败");

            }
        }catch(Exception e ){
            e.printStackTrace();
            returnMsg= new  ReturnMsg("2",e.getMessage());

        }
        return returnMsg;
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    @ApiOperation(value = "Count the number of entities associated", authorizations = @Authorization(value = "token"))
    public String getMessage(HttpServletResponse response) {

        return "你已通过验证";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

       binder.registerCustomEditor(Date.class, new DataBinder());


    }

        /*private class MyDateEditor extends PropertyEditorSupport {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                //通过两次异常的处理可以，绑定两次日期的格式
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                try {
                    date = format.parse(text);
                } catch (Exception e) {
                    format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                    try {
                        date = format.parse(text);
                    } catch (ParseException e2) {
                        e2.printStackTrace();
                        System.out.println(e2.getMessage());
                    }
                }
                setValue(date);
            }
        }*/
}
