package com.ac.service.impl;

import com.ac.entity.Itemmaster;
import com.ac.dao.ItemmasterMapper;
import com.ac.service.IItemmasterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 1
 * @since 2020-05-09
 */
@Service
public class ItemmasterServiceImpl extends ServiceImpl<ItemmasterMapper, Itemmaster> implements IItemmasterService {

    @Resource
    private ItemmasterMapper itemmasterMapper;

    public void get(){
       // itemmasterMapper.selectById()
    }
}
