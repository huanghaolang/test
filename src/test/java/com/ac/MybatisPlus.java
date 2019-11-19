package com.ac;

import com.ac.dao.TPersonMapper;
import com.ac.entity.TPerson;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MybatisPlus {

    @Resource
    private TPersonMapper tPersonMapper;

    @Test
    public void test(){
        System.out.println("----- baseMapper 自带分页 ------");
        Page<TPerson> page = new Page<>(1, 5);
        IPage<TPerson> userIPage = tPersonMapper.selectPage(page, new QueryWrapper<TPerson>()
                .like("name", "黄").orderByAsc("name","emplid"));
        assertThat(page).isSameAs(userIPage);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        print(userIPage.getRecords());
        System.out.println("----- baseMapper 自带分页 ------");

    }

    @Test
    public void test2(){

    }


    private <T> void print(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(System.out::println);
        }
    }
}
