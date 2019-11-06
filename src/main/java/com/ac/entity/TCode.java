package com.ac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 数据库目录
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_CODE")
@ApiModel(value="TCode对象", description="数据库目录")
public class TCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "CODE分类")
    @TableId("CD_CLS")
    private String cdCls;

    @ApiModelProperty(value = "CD")
    @TableField("CD")
    private String cd;

    @ApiModelProperty(value = "中文描述")
    @TableField("CHN_NAME")
    private String chnName;

    @ApiModelProperty(value = "英文描述")
    @TableField("ENG_NAME")
    private String engName;

    @TableField("CRT_DATE")
    private Date crtDate;

    @TableField("CRT_BY")
    private String crtBy;

    @TableField("UPD_DATE")
    private Date updDate;

    @TableField("UPD_BY")
    private String updBy;


}
