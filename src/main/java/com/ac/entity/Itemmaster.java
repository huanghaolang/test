package com.ac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 1
 * @since 2020-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ITEMMASTER")
@ApiModel(value="Itemmaster对象", description="")
public class Itemmaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "tableId")
    @TableField("TABLEID")
    private String tableid;

    @ApiModelProperty(value = "列名")
    @TableField("ITEMNAME")
    private String itemname;

    @ApiModelProperty(value = "是否主键  1表示主键")
    @TableField("DBKEY")
    private Integer dbkey;

    @ApiModelProperty(value = "排序")
    @TableField("DISPLAYNUMBER")
    private Integer displaynumber;

    @ApiModelProperty(value = "显示的名称")
    @TableField("DISPLAYNAME")
    private String displayname;

    @ApiModelProperty(value = "列名的类型 V1:字符串,V2固定长度的字符串,N1数字(有精度就用字符串),D1日期和时间,D2日期,D3时间(建议用字符串)")
    @TableField("ITEMTYPE")
    private String itemtype;

    @ApiModelProperty(value = "输入框类型")
    @TableField("ITEMINPUTTYPE")
    private String iteminputtype;

    @ApiModelProperty(value = "列名的格式")
    @TableField("ITEMFORMAT")
    private String itemformat;

    @ApiModelProperty(value = "列名长度和该表对应")
    @TableField("ITEMLENGTH")
    private String itemlength;

    @ApiModelProperty(value = "输入的最小长度")
    @TableField("ITEMMIN")
    private String itemmin;

    @ApiModelProperty(value = "输入的最大长度,不能超过列名")
    @TableField("ITEMMAX")
    private String itemmax;

    @ApiModelProperty(value = "是否显示 0代表true")
    @TableField("SHOWCOLUMN")
    private Integer showcolumn;

    @ApiModelProperty(value = "显示的初始长度 单位px")
    @TableField("ITEMWIDTH")
    private String itemwidth;

    @ApiModelProperty(value = "是否当作查询条件 1代表true")
    @TableField("SENDREQUIRED")
    private Integer sendrequired;

    @ApiModelProperty(value = "是否导出该列 1代表true")
    @TableField("EXCELFLAG")
    private Integer excelflag;

    @ApiModelProperty(value = "和tableId 关联ITEMMASTER_MULTISELECT表")
    @TableField("MULTISELECTID")
    private String multiselectid;

    @ApiModelProperty(value = "提示信息")
    @TableField("PLACEHOLDER")
    private String placeholder;

    @TableField("CRT_DATE")
    private Date crtDate;

    @TableField("CRT_BY")
    private String crtBy;

    @TableField("UPD_DATE")
    private Date updDate;

    @TableField("UPD_BY")
    private String updBy;

    @ApiModelProperty(value = "当作查询条件时,给前端的参数名")
    @TableField("SENDREQUIREDNAME")
    private String sendrequiredname;

    @ApiModelProperty(value = "查询多选还是非多选,时间类型多选即为时间段,N代表多选")
    @TableField("SENDREQUIREDCOUNT")
    private String sendrequiredcount;

    @ApiModelProperty(value = "列是否固定在左侧或者右侧,0不国定,left 固定在左 right 固定在右")
    @TableField("FIXED")
    private String fixed;

    @ApiModelProperty(value = "模态框的label ")
    @TableField("LABEL")
    private String label;

    @ApiModelProperty(value = "模态框的prop和程序中的属性必须一致")
    @TableField("PROP")
    private String prop;

    @ApiModelProperty(value = "此列是否在table中显示 0显示,1不显示,2可显可不显示")
    @TableField("COLUMNSHOW")
    private String columnshow;

    @ApiModelProperty(value = "此列是否在模态框中显示 0显示,1不显示")
    @TableField("MODALSHOW")
    private String modalshow;

    @ApiModelProperty(value = "此列是否在模态框中是否可输入 0可以,1不可以")
    @TableField("KEYINPUT")
    private String keyinput;
}
