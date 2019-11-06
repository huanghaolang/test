package com.ac.service;

import com.ac.entity.TCode;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 数据库目录 服务类
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */
public interface ITCodeService extends IService<TCode> {
        public List<TCode> getCodeList(TCode code);
}
