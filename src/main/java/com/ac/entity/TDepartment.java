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
 * 部门信息表
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_DEPARTMENT")
@ApiModel(value="TDepartment对象", description="部门信息表")
public class TDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "集合ID")
    @TableField("SETID")
    private String setid;

    @ApiModelProperty(value = "部门ID")
    @TableId("DEPTID")
    private String deptid;

    @ApiModelProperty(value = "生效日期")
    @TableField("EFFDT")
    private String effdt;

    @ApiModelProperty(value = "部门负责人工号")
    @TableField("MANAGER_ID")
    private String managerId;

    @ApiModelProperty(value = "状态")
    @TableField("EFF_STATUS")
    private String effStatus;

    @ApiModelProperty(value = "部门名称")
    @TableField("DESCR")
    private String descr;

    @ApiModelProperty(value = "公司ID")
    @TableField("COMPANY")
    private String company;

    @ApiModelProperty(value = "区域ID")
    @TableField("LOCATION")
    private String location;

    @ApiModelProperty(value = "区域描述")
    @TableField("DESCR1")
    private String descr1;

    @ApiModelProperty(value = "部门级别")
    @TableField("TM_DEPARTMENT_LEV")
    private String tmDepartmentLev;

    @ApiModelProperty(value = "部门级别描述")
    @TableField("DESCR2")
    private String descr2;

    @ApiModelProperty(value = "部门类型")
    @TableField("TM_DEPARTMENT_TYPE")
    private String tmDepartmentType;

    @ApiModelProperty(value = "部门类型描述")
    @TableField("DESCR3")
    private String descr3;

    @ApiModelProperty(value = "部门分类")
    @TableField("TM_DEP_CLASS")
    private String tmDepClass;

    @ApiModelProperty(value = "部门分类描述")
    @TableField("DESCR4")
    private String descr4;

    @ApiModelProperty(value = "HRBP工号")
    @TableField("TM_HRBP")
    private String tmHrbp;

    @ApiModelProperty(value = "管理人员岗位")
    @TableField("MANAGER_POSN")
    private String managerPosn;

    @ApiModelProperty(value = "上级部门")
    @TableField("PART_DEPTID_CHN")
    private String partDeptidChn;

    @ApiModelProperty(value = "操作日期")
    @TableField("ACTION_DT")
    private String actionDt;

    @ApiModelProperty(value = "操作类型")
    @TableField("ACTION_TYPE")
    private String actionType;

    @TableField("CRT_DATE")
    private LocalDateTime crtDate;

    @TableField("CRT_BY")
    private String crtBy;

    @TableField("UPD_DATE")
    private LocalDateTime updDate;

    @TableField("UPD_BY")
    private String updBy;

    @ApiModelProperty(value = "ISC同步唯一标识")
    @TableField("ORG_INDEX_CODE")
    private String orgIndexCode;

    @ApiModelProperty(value = "Y处理 N不处理")
    @TableField("ISC_FLAG")
    private String iscFlag;

    @ApiModelProperty(value = "ISC同步父标识")
    @TableField("PARENT_INDEX_CODE")
    private String parentIndexCode;


}
