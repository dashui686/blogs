package com.dashui.blogs.common.core.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Entity基类
 *
 * @author Lion Li
 */

@Data
public class SearchBaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @JsonIgnore
    @TableField(exist = false)
    private String uuid;

    /**
     * 搜索值
     */
    @JsonIgnore
    @TableField(exist = false)
    private String quickSearch;

    /**
     * 初始化key
     */
    @JsonIgnore
    @TableField(exist = false)
    private String initKey;

    /**
     * 初始化value
     */
    @JsonIgnore
    @TableField(exist = false)
    private String initValue;

    /**
     * 是否下拉选项
     */
    @JsonIgnore
    @TableField(exist = false)
    private String select;


}
