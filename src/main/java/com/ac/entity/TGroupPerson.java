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
@TableName("T_GROUP_PERSON")
@ApiModel(value="TGroupPerson对象", description="分组信息表")
public class TGroupPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分组ID")
    @TableId("GROUP_ID")
    private String groupId;

    @ApiModelProperty(value = "员工ID")
    @TableField("EMPLID")
    private String emplid;

    @ApiModelProperty(value = "状态：A新增 D失效 O正常")
    @TableField("STATUS")
    private String status;

    @TableField("CRT_DATE")
    private LocalDateTime crtDate;

    @TableField("CRT_BY")
    private String crtBy;

    @TableField("UPD_DATE")
    private LocalDateTime updDate;

    @TableField("UPD_BY")
    private String updBy;


}
