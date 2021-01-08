package com.ac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author 1
 * @since 2020-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TABLEMASTER")
@ApiModel(value="Tablemaster对象", description="")
public class Tablemaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("TABLEID")
    private String tableid;

    @TableField("TABLENAME")
    private String tablename;

    @TableField("CONTROLLERNAME")
    private String controllername;

    @TableField("CHNNAME")
    private String chnname;

    @TableField("CREATEDIALOGTITLE")
    private String createdialogtitle;

    @TableField("UPDATEIALOGTITLE")
    private String updateialogtitle;

    @TableField("CRT_DATE")
    private Date crtDate;

    @TableField("CRT_BY")
    private String crtBy;

    @TableField("UPD_DATE")
    private Date updDate;

    @TableField("UPD_BY")
    private String updBy;


}
