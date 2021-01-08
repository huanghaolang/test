package com.ac.ext.dao;

import com.ac.dao.ItemmasterMapper;
import com.ac.ext.entity.ItemmasterExt;

import java.util.List;

public interface ItemmasterExtMapper   {
    //  extends ItemmasterMapper
    List<ItemmasterExt> getTableColumnById(String tableId);
}
