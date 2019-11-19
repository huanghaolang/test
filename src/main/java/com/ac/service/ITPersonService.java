package com.ac.service;

import com.ac.entity.Page;
import com.ac.entity.TPerson;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 人员信息表 服务类
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */
public interface ITPersonService extends IService<TPerson> {

    public Map<String,Object> personPage(Page iPage,TPerson person);

}
