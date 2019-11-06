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
 * @since 2019-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_EVENTS")
@ApiModel(value="TEvents对象", description="")
public class TEvents implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "	事件Id，唯一标识事件的一次发生，同一事件发送多次需要ID相同")
    @TableId("EVENTID")
    private String eventid;

    @ApiModelProperty(value = "方法名，用于标识报文用途,事件固定OnEventNotify")
    @TableField("METHOD")
    private String method;

    @ApiModelProperty(value = "	事件从接收者（如设备接入框架）发出的时间，格式 YYYY-mm-dd hh:MM:ss")
    @TableField("SENDTIME")
    private Date sendtime;

    @TableField("ABILITY")
    private String ability;

    @ApiModelProperty(value = "	指定的事件接收用户列表，用于事件源发起组件指定接收用户，如指定用户接收手动事件、在部分应用中可以设置事件到指定用户接收")
    @TableField("UIDS")
    private String uids;

    @ApiModelProperty(value = "事件源编号，物理设备是资源编号")
    @TableField("SRCINDEX")
    private String srcindex;

    @ApiModelProperty(value = "事件源类型")
    @TableField("SRCTYPE")
    private String srctype;

    @ApiModelProperty(value = "事件源名称，utf8")
    @TableField("SRCNAME")
    private String srcname;

    @ApiModelProperty(value = "事件类型")
    @TableField("EVENTTYPE")
    private BigDecimal eventtype;

    @ApiModelProperty(value = "事件状态, 0-瞬时 1-开始 2-停止 3-事件脉冲 4-事件联动结果更新 5-异步图片上传")
    @TableField("STATUS")
    private BigDecimal status;

    @ApiModelProperty(value = "事件等级：0-未配置 1-低 2-中 3-高，注意，此处事件等级是指在事件联动中配置的等级")
    @TableField("EVENTLVL")
    private BigDecimal eventlvl;

    @ApiModelProperty(value = "脉冲超时时间，一个持续性的事件，上报的间隔")
    @TableField("TIMEOUT")
    private BigDecimal timeout;

    @ApiModelProperty(value = "事件发生时间")
    @TableField("HAPPENTIME")
    private String happentime;

    @ApiModelProperty(value = "事件发生的事件源父设备，无-空字符串")
    @TableField("SRCPARENTINDEX")
    private String srcparentindex;

    @ApiModelProperty(value = "住址")
    @TableField("ADDRESS")
    private String address;

    @ApiModelProperty(value = "出生日期")
    @TableField("BIRTH")
    private String birth;

    @ApiModelProperty(value = "有效日期结束时间")
    @TableField("ENDDATE")
    private String enddate;

    @ApiModelProperty(value = "	身份证id")
    @TableField("IDNUM")
    private String idnum;

    @ApiModelProperty(value = "签发机关")
    @TableField("ISSUINGAUTHORITY")
    private String issuingauthority;

    @ApiModelProperty(value = "姓名")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "	民族")
    @TableField("NATION")
    private BigDecimal nation;

    @ApiModelProperty(value = "性别")
    @TableField("SEX")
    private BigDecimal sex;

    @ApiModelProperty(value = "有效日期开始时间")
    @TableField("STARTDATE")
    private String startdate;

    @ApiModelProperty(value = "是否长期有效")
    @TableField("TERMOFVALIDITY")
    private BigDecimal termofvalidity;

    @ApiModelProperty(value = "人员通道号")
    @TableField("EXTACCESSCHANNEL")
    private BigDecimal extaccesschannel;

    @ApiModelProperty(value = "报警输入/防区通道")
    @TableField("EXTEVENTALARMINID")
    private BigDecimal exteventalarminid;

    @ApiModelProperty(value = "报警输出通道")
    @TableField("EXTEVENTALARMOUTID")
    private BigDecimal exteventalarmoutid;

    @ApiModelProperty(value = "卡号")
    @TableField("EXTEVENTCARDNO")
    private String exteventcardno;

    @ApiModelProperty(value = "事件输入通道")
    @TableField("EXTEVENTCASEID")
    private BigDecimal exteventcaseid;

    @ApiModelProperty(value = "事件类型代码")
    @TableField("EXTEVENTCODE")
    private BigDecimal exteventcode;

    @ApiModelProperty(value = "通道号")
    @TableField("ACCESSCHANNEL")
    private BigDecimal accesschannel;

    @ApiModelProperty(value = "进人数")
    @TableField("ENTRYTIMES")
    private BigDecimal entrytimes;

    @ApiModelProperty(value = "出人数")
    @TableField("EXITTIMES")
    private BigDecimal exittimes;

    @ApiModelProperty(value = "总通行人数")
    @TableField("TOTALTIMES")
    private BigDecimal totaltimes;

    @ApiModelProperty(value = "门编号")
    @TableField("EXTEVENTDOORID")
    private BigDecimal exteventdoorid;

    @ApiModelProperty(value = "进出方向:1-进、0-出")
    @TableField("EXTEVENTINOUT")
    private BigDecimal exteventinout;

    @ApiModelProperty(value = "身份证图片")
    @TableField("EXTEVENTIDCARDPICTUREURL")
    private String exteventidcardpictureurl;

    @ApiModelProperty(value = "就地控制器id")
    @TableField("EXTEVENTLOCALCONTROLLERID")
    private BigDecimal exteventlocalcontrollerid;

    @ApiModelProperty(value = "主设备拨码")
    @TableField("EXTEVENTMAINDEVID")
    private BigDecimal exteventmaindevid;

    @ApiModelProperty(value = "图片的url")
    @TableField("EXTEVENTPICTUREURL")
    private String exteventpictureurl;

    @ApiModelProperty(value = "图片服务器唯一编码")
    @TableField("SVRINDEXCODE")
    private String svrindexcode;

    @ApiModelProperty(value = "读卡器id")
    @TableField("EXTEVENTREADERID")
    private BigDecimal exteventreaderid;

    @ApiModelProperty(value = "读卡器类别:0-无效，1-IC读卡器，2-身份证读卡器，3-二维码读卡器,4-指纹头")
    @TableField("EXTEVENTREADERKIND")
    private BigDecimal exteventreaderkind;

    @ApiModelProperty(value = "报告上传通道:1-布防上传，2-中心组1上传，3-中心组2上传，为0无效")
    @TableField("EXTEVENTREPORTCHANNEL")
    private BigDecimal exteventreportchannel;

    @ApiModelProperty(value = "群组编号")
    @TableField("EXTEVENTROLEID")
    private BigDecimal exteventroleid;

    @ApiModelProperty(value = "分控制器硬件ID")
    @TableField("EXTEVENTSUBDEVID")
    private BigDecimal exteventsubdevid;

    @ApiModelProperty(value = "刷卡次数")
    @TableField("EXTEVENTSWIPNUM")
    private BigDecimal exteventswipnum;

    @ApiModelProperty(value = "事件类型")
    @TableField("EXTEVENTTYPE")
    private BigDecimal exteventtype;

    @ApiModelProperty(value = "多重认证序号")
    @TableField("EXTEVENTVERIFYID")
    private BigDecimal exteventverifyid;

    @ApiModelProperty(value = "白名单单号")
    @TableField("EXTEVENTWHITELISTNO")
    private BigDecimal exteventwhitelistno;

    @ApiModelProperty(value = "人员编号")
    @TableField("EXTEVENTPERSONNO")
    private String exteventpersonno;

    @ApiModelProperty(value = "用于统计事件上报延时")
    @TableField("EXTRECEIVETIME")
    private String extreceivetime;

    @ApiModelProperty(value = "事件流水号，为0无效")
    @TableField("SEQ")
    private BigDecimal seq;


}
