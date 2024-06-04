package com.dashui.blogs.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 管理分组表
 * @TableName admin_group
 */
@Data
public class AdminGroupBo implements Serializable {

    /**
     * 是否树结构
     */
    private boolean isTree;

    /**
     * 绝对身份验证
     */
    private Long absoluteAuth;

    /**
     * 初始化键
     */
    private String initKey;

    /**
     * 初始化 value
     */
    private Long[] initValue;

    /**
     * 是否开启查询
     */
    private boolean select;

    /**
     * 快速查询
     */
    private String quickSearch;

}
