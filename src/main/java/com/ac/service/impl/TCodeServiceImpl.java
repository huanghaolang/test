package com.ac.service.impl;

import com.ac.entity.TCode;
import com.ac.dao.TCodeMapper;
import com.ac.service.ITCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 数据库目录 服务实现类
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */
@Service
public class TCodeServiceImpl extends ServiceImpl<TCodeMapper, TCode> implements ITCodeService {

    private TCodeMapper codeMapper;
    @Override
    public List<TCode> getCodeList(TCode code) {

        return null;
    }
}
