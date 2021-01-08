package com.ac.service;

import com.ac.entity.TRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 1
 * @since 2020-04-09
 */
public interface ITRoleService extends IService<TRole> {

            public List<TRole> getRoleList(TRole role);
}
