package com.dashui.blogs.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 管理分组表
 * @TableName admin_group
 */
@Data
public class AdminGroupVo implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 上级分组
     */
    private Integer pid;

    /**
     * 组名
     */
    private String name;

    /**
     * 权限规则ID
     */
    private String rules;

    /**
     * 状态:0=禁用,1=启用
     */
    private Object status;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 是否删除
     */
    private Object delFlag;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;

}
