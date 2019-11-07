package com.ac.service.impl;

import com.ac.entity.TUser;
import com.ac.dao.TUserMapper;
import com.ac.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据库目录 服务实现类
 * </p>
 *
 * @author 1
 * @since 2019-11-06
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
