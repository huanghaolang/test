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
 * @since 2019-11-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_USER")
@ApiModel(value="TUser对象", description="数据库目录")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID,即登录名")
    @TableId("USER_ID")
    private String userId;

    @ApiModelProperty(value = "用户名")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    @TableField("USER_PWD")
    private String userPwd;

    @ApiModelProperty(value = "用户EMAIL")
    @TableField("USER_EMAIL")
    private String userEmail;

    @ApiModelProperty(value = "用户性别")
    @TableField("USER_SEX")
    private String userSex;

    @ApiModelProperty(value = "用户信息描述")
    @TableField("USER_DESC")
    private String userDesc;

    @TableField("CRT_DATE")
    private Date crtDate;

    @TableField("CRT_BY")
    private String crtBy;

    @TableField("UPD_DATE")
    private Date updDate;

    @TableField("UPD_BY")
    private String updBy;


}
