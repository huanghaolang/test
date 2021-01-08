package com.ac.service.impl;

import com.ac.entity.TAuthAppoint;
import com.ac.dao.TAuthAppointMapper;
import com.ac.service.ITAuthAppointService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 数据库目录 服务实现类
 * </p>
 *
 * @author 1
 * @since 2020-04-09
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TAuthAppointServiceImpl extends ServiceImpl<TAuthAppointMapper, TAuthAppoint> implements ITAuthAppointService {

    @Resource
    private TAuthAppointMapper authAppointMapper;

    @Override
    public List<TAuthAppoint> getAuths(TAuthAppoint authAppoint) {
        QueryWrapper<TAuthAppoint> queryWrapper = new QueryWrapper();
        queryWrapper.eq("1","1");
        queryWrapper.like("o","1");
        List<TAuthAppoint> list  = authAppointMapper.selectList(queryWrapper);
        return list;
    }
}
