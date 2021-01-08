package com.ac.entity2;

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
 * 数据源列信息
 * </p>
 *
 * @author 1
 * @since 2020-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("S_DS_FIELDS")
@ApiModel(value="SDsFields对象", description="数据源列信息")
public class SDsFields implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据源ID")
    @TableId("DS_ID")
    private Long dsId;

    @ApiModelProperty(value = "列ID")
    @TableField("FIELD_ID")
    private String fieldId;

    @ApiModelProperty(value = "字段名")
    @TableField("FIELD_NAME")
    private String fieldName;

    @ApiModelProperty(value = "字段类型JDBCType")
    @TableField("FIELD_TYPE")
    private String fieldType;

    @ApiModelProperty(value = "名称")
    @TableField("CAPTION")
    private String caption;

    @ApiModelProperty(value = "是否主键")
    @TableField("IS_DBKEY")
    private String isDbkey;

    @ApiModelProperty(value = "数据类型JavaType")
    @TableField("DATA_TYPE")
    private String dataType;

    @ApiModelProperty(value = "数据长度")
    @TableField("DATA_LEN")
    private Long dataLen;

    @ApiModelProperty(value = "数据最小长度")
    @TableField("DATA_MIN")
    private Long dataMin;

    @ApiModelProperty(value = "数据最大长度")
    @TableField("DATA_MAX")
    private Long dataMax;

    @ApiModelProperty(value = "数据精度")
    @TableField("DATA_PRECISION")
    private Long dataPrecision;

    @ApiModelProperty(value = "数据小数位数")
    @TableField("DATA_SCALE")
    private Long dataScale;

    @ApiModelProperty(value = "数据可为NULL")
    @TableField("DATA_NULLABLE")
    private String dataNullable;

    @ApiModelProperty(value = "是否作查询参数")
    @TableField("IS_QUERY_PARAM")
    private String isQueryParam;

    @ApiModelProperty(value = "是否表格列显示")
    @TableField("IS_DISP_VISIBLE")
    private String isDispVisible;

    @ApiModelProperty(value = "表格列显示序号")
    @TableField("DISP_SEQ")
    private Long dispSeq;

    @ApiModelProperty(value = "表格列显示宽度")
    @TableField("DISP_WIDTH")
    private Long dispWidth;

    @ApiModelProperty(value = "表格列显示格式")
    @TableField("DISP_FORMAT")
    private String dispFormat;

    @ApiModelProperty(value = "表格列固定列")
    @TableField("DISP_FIXED")
    private String dispFixed;

    @ApiModelProperty(value = "准许新增")
    @TableField("CAN_INSERT")
    private String canInsert;

    @ApiModelProperty(value = "准许更新")
    @TableField("CAN_UPDATE")
    private String canUpdate;

    @ApiModelProperty(value = "准许筛选")
    @TableField("CAN_FILTER")
    private String canFilter;

    @ApiModelProperty(value = "准许排序")
    @TableField("CAN_SORT")
    private String canSort;

    @ApiModelProperty(value = "默认排序方向")
    @TableField("DEF_SORT_ORDER")
    private String defSortOrder;

    @ApiModelProperty(value = "默认排序顺序号")
    @TableField("DEF_SORT_SEQ")
    private Integer defSortSeq;

    @ApiModelProperty(value = "准许EXPORT")
    @TableField("CAN_EXPORT")
    private String canExport;

    @ApiModelProperty(value = "是否编辑显示")
    @TableField("IS_EDT_VISIBLE")
    private String isEdtVisible;

    @ApiModelProperty(value = "编辑组件类型")
    @TableField("EDT_TYPE")
    private String edtType;

    @ApiModelProperty(value = "编辑提示信息")
    @TableField("EDT_PH")
    private String edtPh;

    @ApiModelProperty(value = "编辑SHEET名称")
    @TableField("EDT_PAGE")
    private String edtPage;

    @ApiModelProperty(value = "编辑LIST类型")
    @TableField("EDT_LIST_TYPE")
    private String edtListType;

    @ApiModelProperty(value = "CODE表CD_CLS")
    @TableField("EDT_CD_CLS")
    private String edtCdCls;

    @ApiModelProperty(value = "SCRIPT表SCRIPT_ID")
    @TableField("EDT_SCRIPT_ID")
    private String edtScriptId;

    @ApiModelProperty(value = "有效验证RULE1")
    @TableField("EDT_RULE_1")
    private String edtRule1;

    @ApiModelProperty(value = "有效验证RULE2")
    @TableField("EDT_RULE_2")
    private String edtRule2;

    @ApiModelProperty(value = "有效验证RULE3")
    @TableField("EDT_RULE_3")
    private String edtRule3;

    @ApiModelProperty(value = "新增时刻")
    @TableField("CREATE_DATE")
    private Date createDate;

    @ApiModelProperty(value = "新增作业者")
    @TableField("CREATE_USER")
    private String createUser;

    @ApiModelProperty(value = "更新时刻")
    @TableField("UPDATE_DATE")
    private Date updateDate;

    @ApiModelProperty(value = "更新作业者")
    @TableField("UPDATE_USER")
    private String updateUser;


}
