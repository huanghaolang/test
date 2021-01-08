package com.ac.entity2;

import lombok.Data;

@Data
public class AdmissionInfo {

    private String schoolName;
    //基础信息
    private String schoolQuality;// 学校性质
    private String schoolProp1;//所获认证
    private String schoolProp2;//学制及招生人数
    private String schoolProp3;//联系方式
    //学费信息
    private String schoolProp4;//全日制
    private String schoolProp5;//非全日制

    //申请条件
    private String schoolProp6;//正常批考生
    private String schoolProp7;//提前批考生
    private String schoolProp8;//转档案及转户要求
    private String schoolProp9;//院校地址

    //院校专业信息
    private String schoolProp10;//研究方向
    private String schoolProp11;//招生简章
    private String schoolProp12;//院校网址

    //注意事项
    private String schoolProp13;//注意事项全日制
    private String schoolProp14;//注意事项非全日制
    private String schoolProp15;//注意事项历年分数线

}
