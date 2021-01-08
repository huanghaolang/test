package com.ac.controller;


import com.ac.ext.entity.ReturnMsg;
import com.ac.service.ITablemasterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 1
 * @since 2020-05-12
 */
@RestController
@RequestMapping("/tablemaster")
public class TablemasterController {

    @Resource
    private ITablemasterService iTablemasterService;

    @PostMapping("getTablemasterById")
    public ReturnMsg getTablemasterById(String tableId){
        ReturnMsg returnMsg  = null;
        try {
            returnMsg = new ReturnMsg("0","success",iTablemasterService.getById(tableId));
        }catch(Exception e){
            e.printStackTrace();
            returnMsg = new ReturnMsg("1",e.getMessage());
        }
        return returnMsg;
    }
}
