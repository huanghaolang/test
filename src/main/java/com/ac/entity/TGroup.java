package com.ac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 分组信息表
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_GROUP")
@ApiModel(value="TGroup对象", description="分组信息表")
public class TGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分组ID")
    @TableId("GROUP_ID")
    private String groupId;

    @ApiModelProperty(value = "分组名称")
    @TableField("GROUP_NAME")
    private String groupName;

    @ApiModelProperty(value = "分组描述")
    @TableField("GROUP_DESC")
    private String groupDesc;

    @ApiModelProperty(value = "权限所属系统CODE")
    @TableField("SYS_CODE")
    private String sysCode;

    @ApiModelProperty(value = "权限所属子系统CODE1")
    @TableField("SYS_SUBCODE1")
    private String sysSubcode1;

    @ApiModelProperty(value = "权限所属子系统CODE2")
    @TableField("SYS_SUBCODE2")
    private String sysSubcode2;

    @ApiModelProperty(value = "父分组ID")
    @TableField("PARENT_GROUP_ID")
    private String parentGroupId;

    @TableField("CRT_DATE")
    private LocalDateTime crtDate;

    @TableField("CRT_BY")
    private String crtBy;

    @TableField("UPD_DATE")
    private LocalDateTime updDate;

    @TableField("UPD_BY")
    private String updBy;


}
