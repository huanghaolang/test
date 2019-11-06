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
 * 人员信息表
 * </p>
 *
 * @author 1
 * @since 2019-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_PERSON")
@ApiModel(value="TPerson对象", description="人员信息表")
public class TPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工ID")
    @TableId("EMPLID")
    private String emplid;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "出生日期")
    @TableField("BIRTHDATE")
    private String birthdate;

    @ApiModelProperty(value = "国籍")
    @TableField("BIRTHCOUNTRY")
    private String birthcountry;

    @ApiModelProperty(value = "国籍描述")
    @TableField("DESCR1")
    private String descr1;

    @ApiModelProperty(value = "AD账号")
    @TableField("TM_AD_ACCOUNT")
    private String tmAdAccount;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    private String sex;

    @ApiModelProperty(value = "第一外语")
    @TableField("LANG_CD")
    private String langCd;

    @ApiModelProperty(value = "第一外语描述")
    @TableField("DESCR2")
    private String descr2;

    @ApiModelProperty(value = "主要证件号")
    @TableField("NATIONAL_ID")
    private String nationalId;

    @ApiModelProperty(value = "手机号")
    @TableField("PHONE")
    private String phone;

    @ApiModelProperty(value = "公司邮箱")
    @TableField("EMAIL_ADDR")
    private String emailAddr;

    @ApiModelProperty(value = "工龄调整")
    @TableField("TM_LEN_SERVICE_ADJ")
    private String tmLenServiceAdj;

    @ApiModelProperty(value = "工龄")
    @TableField("DESCR3")
    private String descr3;

    @ApiModelProperty(value = "集团司龄调整")
    @TableField("TM_GROUP_AGE_ADJ")
    private String tmGroupAgeAdj;

    @ApiModelProperty(value = "集团司龄")
    @TableField("DESCR4")
    private String descr4;

    @ApiModelProperty(value = "司龄调整")
    @TableField("TM_CMPY_AGE_ADJ")
    private String tmCmpyAgeAdj;

    @ApiModelProperty(value = "司龄")
    @TableField("DESCR5")
    private String descr5;

    @ApiModelProperty(value = "籍贯描述")
    @TableField("DESCR6")
    private String descr6;

    @ApiModelProperty(value = "学历")
    @TableField("TM_EDUCATION")
    private String tmEducation;

    @ApiModelProperty(value = "学位")
    @TableField("TM_DEGREED")
    private String tmDegreed;

    @ApiModelProperty(value = "学位描述")
    @TableField("DESCR8")
    private String descr8;

    @ApiModelProperty(value = "学历教育类型")
    @TableField("TM_EDUCT_TYPE")
    private String tmEductType;

    @ApiModelProperty(value = "学历教育类型描述")
    @TableField("DESCR9")
    private String descr9;

    @ApiModelProperty(value = "毕业院校")
    @TableField("TM_GRAD_SCH")
    private String tmGradSch;

    @ApiModelProperty(value = "专业")
    @TableField("TM_MAJOR")
    private String tmMajor;

    @ApiModelProperty(value = "毕业日期")
    @TableField("TM_DATE")
    private String tmDate;

    @ApiModelProperty(value = "年龄")
    @TableField("TM_DESCR10")
    private String tmDescr10;

    @ApiModelProperty(value = "政治面貌代码")
    @TableField("POLITICAL_STA_CHN")
    private String politicalStaChn;

    @ApiModelProperty(value = "政治面貌描述")
    @TableField("TM_DESCR11")
    private String tmDescr11;

    @ApiModelProperty(value = "单位类别")
    @TableField("TM_CMP_TYPE")
    private String tmCmpType;

    @ApiModelProperty(value = "员工序列")
    @TableField("TM_EMPL_JOB_FAMILY")
    private String tmEmplJobFamily;

    @ApiModelProperty(value = "既往病史")
    @TableField("TM_PRE_HISTORY_CHN")
    private String tmPreHistoryChn;

    @ApiModelProperty(value = "操作日期")
    @TableField("ACTION_DT")
    private String actionDt;

    @ApiModelProperty(value = "操作类型")
    @TableField("ACTION_TYPE")
    private String actionType;

    @ApiModelProperty(value = "人员类型 E:雇员 L:临时人员 S：供应商")
    @TableField("PERSON_TYPE")
    private String personType;

    @TableField("CRT_DATE")
    private LocalDateTime crtDate;

    @TableField("CRT_BY")
    private String crtBy;

    @TableField("UPD_DATE")
    private LocalDateTime updDate;

    @TableField("UPD_BY")
    private String updBy;

    @TableField("DEPTID")
    private String deptid;

    @ApiModelProperty(value = "等级")
    @TableField("TM_RANK")
    private String tmRank;

    @TableField("HR_STATUS")
    private String hrStatus;

    @ApiModelProperty(value = "ISC人员同步ID")
    @TableField("PERSON_ID")
    private String personId;

    @ApiModelProperty(value = "卡号")
    @TableField("CARD_NO")
    private String cardNo;

    @ApiModelProperty(value = "卡状态")
    @TableField("CARDEVTTYPEID")
    private String cardevttypeid;

    @ApiModelProperty(value = "卡号变更")
    @TableField("CARD_NO_OP")
    private String cardNoOp;

    @ApiModelProperty(value = "卡状态变更")
    @TableField("CARDEVTTYPEID_OP")
    private String cardevttypeidOp;

    @ApiModelProperty(value = "ISC卡同步ID")
    @TableField("CARD_ID")
    private String cardId;

    @ApiModelProperty(value = "人脸图片ID")
    @TableField("PHOTO_ID")
    private String photoId;

    @ApiModelProperty(value = "人脸图片URL")
    @TableField("PHOTO_FACE_URL")
    private String photoFaceUrl;

    @ApiModelProperty(value = "照片图片URL")
    @TableField("PHOTO_URL")
    private String photoUrl;

    @ApiModelProperty(value = "ISC人脸同步ID")
    @TableField("FACE_ID")
    private String faceId;

    @ApiModelProperty(value = "权限下发标识")
    @TableField("AUTH_SYN_FLAG")
    private String authSynFlag;

    @ApiModelProperty(value = "证件类型")
    @TableField("NATIONAL_ID_TYPE")
    private String nationalIdType;


}
