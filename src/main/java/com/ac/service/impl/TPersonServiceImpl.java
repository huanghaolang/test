package com.ac.service.impl;

import com.ac.entity.Page;
import com.ac.entity.TPerson;
import com.ac.dao.TPersonMapper;
import com.ac.service.ITPersonService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.convert.EntityWriter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 * 人员信息表 服务实现类
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TPersonServiceImpl extends ServiceImpl<TPersonMapper, TPerson> implements ITPersonService {

    @Resource
    private TPersonMapper tPersonMapper;

    @Override
    public Map<String, Object> personPage(Page iPage, TPerson person) {
        Map<String, Object> map = new HashMap<>();
        //int current = iPage.getOffset();

        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TPerson> page =
                new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(1, 10);
        IPage<TPerson> personPage = tPersonMapper.selectPage(page, new QueryWrapper<TPerson>().like("name", "黄"));
        assertThat(page).isSameAs(personPage);

        System.out.println("总条数 ------> " + personPage.getTotal());
        System.out.println("当前页数 ------> " + personPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + personPage.getSize());

        List<TPerson> list = personPage.getRecords();

        return null;
    }

    @Override
    public void savePerson() throws Exception {
        TPerson person = tPersonMapper.selectById("TEST0002");
        System.out.println("select1:"+JSON.toJSONString(person));
        UpdateWrapper updateWrapper =new UpdateWrapper();
        person.setEmplid("TEST0002");
        person.setName("2222");
        person.setDescr1("3333");

        //tPersonMapper.updateById(person);

        System.out.println("update1:"+JSON.toJSONString(person));
        TPerson person2 = tPersonMapper.selectById("TEST0002");

        System.out.println("select2:"+JSON.toJSONString(person2));
        throw new Exception("1");

    }
}
