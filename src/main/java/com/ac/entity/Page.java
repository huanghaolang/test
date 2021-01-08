package com.ac.entity;

import lombok.Data;

@Data
public class Page {


    private int page=1; //页码
    private int size=20;//每页数据多少


    private String sort; //排序方式
    private  String order; //排序字段







}
