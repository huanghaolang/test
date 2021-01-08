package com.ac.controller;


import com.ac.annotation.Action;
import com.ac.entity.Itemmaster;
import com.ac.ext.dao.ItemmasterExtMapper;
import com.ac.ext.entity.ItemmasterExt;
import com.ac.ext.entity.ReturnMsg;
import com.ac.initBinder.DataBinder;
import com.ac.service.IItemmasterService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 1
 * @since 2020-05-09
 */
@RestController
@RequestMapping("/itemmaster")
public class ItemmasterController {

    @Resource
    private ItemmasterExtMapper itemmasterExtMapper;

    @Resource
    private IItemmasterService iItemmasterService;

    @PostMapping("getPageConfig")
    @Action(name="注解式拦截的 add 操作.")
    public ReturnMsg getPageConfig(String tableId) {
        ReturnMsg returnMsg = null;
        try {
            List<ItemmasterExt> list = itemmasterExtMapper.getTableColumnById(tableId);
            returnMsg = new ReturnMsg("0", "success", list);

        } catch (Exception e) {
            returnMsg = new ReturnMsg("1", e.getMessage());
        }
        return returnMsg;
    }


    @PostMapping("/get")
    public ReturnMsg getItemmaster(Itemmaster itemmaster, Page page,
                                   @RequestParam(value = "dateQuantum[]", required = false) List<Date> dateQuantum,
                                   @RequestParam(value = "pageorder",required = false) String pageorder,
                                   @RequestParam(value = "pageprop",required = false) String pageprop,
                                   HttpServletResponse response, HttpServletRequest request) {
        // response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        ReturnMsg returnMsg = null;
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String, Object> map = new HashMap<>();
        try {
            if(itemmaster.getTableid()!=null && itemmaster.getTableid().trim().length() != 0){
                queryWrapper.eq("tableid",itemmaster.getTableid());
            }
            if(itemmaster.getItemname()!=null && itemmaster.getItemname().trim().length() != 0){
                queryWrapper.like("ITEMNAME",itemmaster.getItemname());
            }
            queryWrapper.orderByAsc();
            map.put("data", iItemmasterService.page(page, queryWrapper));
            returnMsg = new ReturnMsg("0", "success", map);
        } catch (Exception e) {
            e.printStackTrace();
            returnMsg = new ReturnMsg("30001", e.getMessage(), null);
        }


        return returnMsg;
    }

    @PostMapping("save")
    public ReturnMsg save(Itemmaster itemmaster) {
        ReturnMsg returnMsg = new ReturnMsg("1","error");
        try {
            if (iItemmasterService.updateById(itemmaster)) {
                returnMsg.setCode("0");
                returnMsg.setMsg("修改用户信息成功");
            } else {
                if (iItemmasterService.save(itemmaster)) {
                    returnMsg.setCode("0");
                    returnMsg.setMsg("新增用户成功");
                }
            }
        } catch (Exception e) {
            returnMsg = new ReturnMsg("3",e.getMessage());
        }

        return returnMsg;
    }

    @PostMapping("delete")
    public ReturnMsg delete(Itemmaster itemmaster){
        ReturnMsg returnMsg = null;
        try {
            QueryWrapper queryWrapper =new QueryWrapper();
            queryWrapper.eq("TABLEID",itemmaster.getTableid());
            queryWrapper.eq("ITEMNAME",itemmaster.getItemname());
            if(iItemmasterService.remove(queryWrapper)){
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
    public ReturnMsg batchDel(@RequestParam(value = "ids[]",required = true) List<Map<String,String>> ids){
        ReturnMsg returnMsg = null;
        try {
            //userService.batch
            if(iItemmasterService.removeByIds(null)){
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


    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        binder.registerCustomEditor(Date.class, new DataBinder());


    }
}
