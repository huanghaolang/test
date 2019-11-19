package com.ac.controller;


import com.ac.entity.Page;
import com.ac.entity.TPerson;
import com.ac.service.ITPersonService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 * 人员信息表 前端控制器
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */
@RestController
@RequestMapping("person")
public class TPersonController {

    @Resource
    private ITPersonService itPersonService;




    @RequestMapping(value = "/getPersonListPage",method = RequestMethod.POST)
    public Map<String, Object> getPersonListPage(TPerson person, Page iPage, String exportCode, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int current = iPage.getOffset()/iPage.getLimit()+1;

            com.baomidou.mybatisplus.extension.plugins.pagination.Page<TPerson> page =
                    new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(current, iPage.getLimit());
            IPage<TPerson> personPage = itPersonService.page(page, new QueryWrapper<TPerson>().like("name", "黄"));
            assertThat(page).isSameAs(personPage);


            List<TPerson> list = personPage.getRecords();
            map.put("rows",list);
            map.put("total",personPage.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }




}
