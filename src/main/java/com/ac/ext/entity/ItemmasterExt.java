package com.ac.ext.entity;

import com.ac.entity.Itemmaster;
import com.ac.entity.ItemmasterMultiselect;
import lombok.Data;

import java.util.List;

@Data
public class ItemmasterExt extends Itemmaster {
    private List<ItemmasterMultiselect> multiselects;

}
