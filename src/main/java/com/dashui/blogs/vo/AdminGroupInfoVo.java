package com.dashui.blogs.vo;

import com.dashui.blogs.domain.AdminGroup;
import com.dashui.blogs.freamwork.core.mapstructplus.StringAsList;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 管理分组表
 * @TableName admin_group
 */
@Data
@AutoMapper(target = AdminGroup.class,uses = StringAsList.class)
public class AdminGroupInfoVo implements Serializable {
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
    @AutoMapping(target = "rules",qualifiedByName = "listStringToString")
    private List<String> rules;

    /**
     * 状态:0=禁用,1=启用
     */
    private String status;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private Long createBy;

    private List<AdminGroupInfoVo> children;


    private static final long serialVersionUID = 1L;

}
