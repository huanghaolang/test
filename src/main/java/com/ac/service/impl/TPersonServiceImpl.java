package com.ac.service.impl;

import com.ac.entity.TPerson;
import com.ac.dao.TPersonMapper;
import com.ac.service.ITPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员信息表 服务实现类
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */
@Service
public class TPersonServiceImpl extends ServiceImpl<TPersonMapper, TPerson> implements ITPersonService {

}
