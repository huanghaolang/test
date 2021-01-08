package com.ac.dao;

import com.ac.entity.ItemmasterMultiselect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 1
 * @since 2020-05-08
 */
public interface ItemmasterMultiselectMapper extends BaseMapper<ItemmasterMultiselect> {
       List<ItemmasterMultiselect> getMultiSelect(@Param("tableid") String tableid,@Param("multiselectid") String multiselectid);
}
