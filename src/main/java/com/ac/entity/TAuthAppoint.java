package com.ac.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据库目录
 * </p>
 *
 * @author 1
 * @since 2020-04-09
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_AUTH_APPOINT")
@ApiModel(value="TAuthAppoint对象", description="数据库目录")
public class TAuthAppoint implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "权限唯一ID")
    @TableId("AUTH_UUID")
    private String authUuid;

    @ApiModelProperty(value = "P:人员 G:分组 D:部门 R角色")
    @TableField("OBJECT_TYPE")
    private String objectType;

    @ApiModelProperty(value = "人员ID/分组ID/部门ID/角色ID")
    @TableField("OBJECT_ID")
    private String objectId;

    @ApiModelProperty(value = "分派备注")
    @TableField("AUTH_APPOINT_DESC")
    private String authAppointDesc;

    @ApiModelProperty(value = "0:新增 1:删除 2:变更 9:已生成指令")
    @TableField("AUTH_APPOINT_STATUS")
    private String authAppointStatus;

    @TableField("CRT_DATE")
    private Date crtDate;

    @TableField("CRT_BY")
    private String crtBy;

    @TableField("UPD_DATE")
    private Date updDate;

    @TableField("UPD_BY")
    private String updBy;

    @TableField("SYN_FLAG")
    private String synFlag;

    @TableField("SYN_DATE")
    private Date synDate;

    @TableField("SYN_INDEX")
    private String synIndex;


}
