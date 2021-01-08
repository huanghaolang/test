package com.ac.service.impl;

import com.ac.entity.TRole;
import com.ac.dao.TRoleMapper;
import com.ac.service.ITRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 1
 * @since 2020-04-09
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements ITRoleService {

    @Resource
    private TRoleMapper roleMapper;


    @Override
    public List<TRole> getRoleList(TRole role) {
        QueryWrapper<TRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_Id",role.getRoleId());
        return  roleMapper.selectList(queryWrapper);
    }
}
