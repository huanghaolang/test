package com.ac.service;

import com.ac.entity.TAuthAppoint;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 数据库目录 服务类
 * </p>
 *
 * @author 1
 * @since 2020-04-09
 */
public interface ITAuthAppointService extends IService<TAuthAppoint> {
        public List<TAuthAppoint> getAuths(TAuthAppoint authAppoint);
}
