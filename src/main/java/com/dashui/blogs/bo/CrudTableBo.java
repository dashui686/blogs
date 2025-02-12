package com.dashui.blogs.bo;

import lombok.Data;

import java.util.List;

@Data
public class CrudTableBo {

    private String uuid;
    private String table;

    private Long page;



    // 连接方式
    private String connection;

    private String samePrefix;
    private String initKey;
    private String quickSearch;
    private String initValue;
    private boolean select;

    // 去除表
    private List<String> excludeTable;
}
