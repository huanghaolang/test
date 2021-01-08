package com.ac.dao;

import com.ac.entity.TVueAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 1
 * @since 2020-04-13
 */
public interface TVueAuthMapper extends BaseMapper<TVueAuth> {
    public List<TVueAuth> getRouters(TVueAuth vueAuth);
}
