package com.ac.entity;

public class JavaBeanTest {

    private String f;//纯小写不能生成
    private String id;
    private String aaaCdDe;//小驼峰命名
    private String bbbBbbCdDe;//小驼峰命名
    private String userName;//小驼峰命名
    private String qDate;//小驼峰命名
    private String ADate;//大驼峰命名-常用与类名
    private String AaaBbbCcc;//大驼峰命名-常用与类名
    private String ABCD;//纯大写命名（不符合驼峰）

    /**在swagger接口属性中，该属性变成了ab*/
    private String AB;//（不符合驼峰）

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAaaCdDe() {
        return aaaCdDe;
    }

    public void setAaaCdDe(String aaaCdDe) {
        this.aaaCdDe = aaaCdDe;
    }

    public String getBbbBbbCdDe() {
        return bbbBbbCdDe;
    }

    public void setBbbBbbCdDe(String bbbBbbCdDe) {
        this.bbbBbbCdDe = bbbBbbCdDe;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getqDate() {
        return qDate;
    }

    public void setqDate(String qDate) {
        this.qDate = qDate;
    }

    public String getADate() {
        return ADate;
    }

    public void setADate(String ADate) {
        this.ADate = ADate;
    }

    public String getAaaBbbCcc() {
        return AaaBbbCcc;
    }

    public void setAaaBbbCcc(String aaaBbbCcc) {
        AaaBbbCcc = aaaBbbCcc;
    }

    public String getABCD() {
        return ABCD;
    }

    public void setABCD(String ABCD) {
        this.ABCD = ABCD;
    }

    public String getAB() {
        return AB;
    }

    public void setAB(String AB) {
        this.AB = AB;
    }





}
