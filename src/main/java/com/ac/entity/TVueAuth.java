package com.ac.entity;

import java.math.BigDecimal;
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
 * 
 * </p>
 *
 * @author 1
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_VUE_AUTH")
@ApiModel(value="TVueAuth对象", description="")
public class TVueAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("AUTH_UUID")
    private String authUuid;

    @TableField("AUTH_NAME")
    private String authName;

    @TableField("AUTH_COMPONENT")
    private String authComponent;

    @ApiModelProperty(value = " 0: true 1:false")
    @TableField("AUTH_HIDDEN")
    private Integer authHidden;

    @TableField("PARENT_AUTH_UUID")
    private String parentAuthUuid;

    @TableField("AUTH_TYPE")
    private String authType;

    @TableField("SYS_CODE")
    private String sysCode;

    @TableField("META_TITLE")
    private String metaTitle;

    @TableField("META_ICON")
    private String metaIcon;

    @TableField("AUTH_ORDER")
    private BigDecimal authOrder;

    @ApiModelProperty(value = "0:可使用 1:作废")
    @TableField("STATUS")
    private String status;

    @TableField("AUTH_ATTR1")
    private String authAttr1;

    @TableField("AUTH_ATTR2")
    private String authAttr2;

    @TableField("AUTH_ATTR3")
    private String authAttr3;

    @TableField("CRT_DATE")
    private Date crtDate;

    @TableField("CRT_BY")
    private String crtBy;

    @TableField("UPD_DATE")
    private Date updDate;

    @TableField("UPD_BY")
    private String updBy;

    @TableField("AUTH_PATH")
    private String authPath;

    @TableField("AUTH_REDIRECT")
    private String authRedirect;


}
