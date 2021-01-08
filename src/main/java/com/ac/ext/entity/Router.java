package com.ac.ext.entity;

import lombok.Data;

import java.util.List;

@Data
public class Router {
    private String id;
    private String path;
    private String component;
    private String redirect;
    private List<Router> children;
    private String name;
    private Meta meta;
    private boolean hidden;
    private String parentId;
}
