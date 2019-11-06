package com.ac.controller;


import com.ac.entity.TCode;
import com.ac.service.ITCodeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.tools.javac.util.Convert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 数据库目录 前端控制器
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */

@Api(description = "code操作")
@RestController
@RequestMapping("/code")
public class TCodeController {

    @Resource
    private ITCodeService itCodeService;


    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="获取codeList")
    public Map getCodes() {
        Map<String, Object> map = new HashMap<>();
        List<TCode> list = itCodeService.list();
        map.put("total", list);
        map.put("rows", list == null ? 0 : list.size());
        return map;
    }
    @RequestMapping(value="/getCodeById",method = RequestMethod.GET)
    @ApiOperation(value="根据id获取单个code")
    public Map getCodeById() {
        System.out.println("这是getCodes的方法");
        Map<String, Object> map = new HashMap<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("cd","T1");
        queryWrapper.like("cd_cls","1");
        TCode tcode = itCodeService.getById("1");
        map.put("total", tcode);
        map.put("rows", tcode == null ? 0 : 1);
        return map;
    }
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value="添加单个code")
    public Map insertCode() {
        Map<String, Object> map = new HashMap<>();
        TCode tCode = getCode();
        boolean flag =  itCodeService.save(tCode);
        map.put("flag:",flag);
        return map;
    }

    @RequestMapping(value ="/batchSave",method = RequestMethod.POST)
    @ApiOperation(value="批量添加code")
    public Map insertCodes() {
        Map<String, Object> map = new HashMap<>();
        List<TCode> list = getCodeList();
        boolean flag =  itCodeService.saveOrUpdateBatch(list);
        map.put("flag:",flag);
        return map;
    }

    private TCode  getCode(){
        TCode tCode = new TCode();
        tCode.setCdCls("T1");
        tCode.setCd("A");
        tCode.setChnName("黄");
        tCode.setCrtDate(new Date());
        return tCode;
    }
    private List<TCode> getCodeList(){
        List<TCode> codeList = new ArrayList<>();
        TCode tCode = null;
        for (int i = 0;i<1005;i++){
            tCode= new TCode();
            tCode.setCdCls("TLIST");
            tCode.setCd(i+"");
            tCode.setChnName("黄"+i);
            tCode.setCrtDate(new Date());
            tCode.setUpdDate(new Date());
            codeList.add(tCode);
        }
        return codeList;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value="修改单个code")
    public Map updateCode() {
        System.out.println("1");
        Map<String, Object> map = new HashMap<>();
        TCode tCode = getCode();
        boolean flag =  itCodeService.updateById(tCode);
        map.put("flag", flag);
        return map;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value="删除单个code")
    public Map deleteCode() {
        QueryWrapper<TCode> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cd", "0");
        queryWrapper.eq("cd_cls","TLIST");
        Map<String, Object> map = new HashMap<>();
        boolean flag  =  itCodeService.remove(queryWrapper);
        map.put("flag", flag);
        return map;
    }
}
