package com.dashui.blogs.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.dashui.blogs.domain.AdminGroup;
import com.dashui.blogs.domain.AdminRule;
import com.dashui.blogs.freamwork.core.mapstructplus.StringAsList;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AutoMapper(target = AdminRule.class)
public class AdminRuleDto {

    private Long id;

    /**
     * 快速查询
     */
    private String quickSearch;

    /**
     * 上级菜单
     */
    private Integer pid;

    /**
     * 类型:menu_dir=菜单目录,menu=菜单项,button=页面按钮
     */
    private String type;

    /**
     * 标题
     */
    private String title;

    /**
     * 规则名称
     */
    private String name;

    /**
     * 路由路径
     */
    private String path;

    /**
     * 图标
     */
    private String icon;

    /**
     * 菜单类型:tab=选项卡,link=链接,iframe=Iframe
     */
    private String menu_type;

    /**
     * Url
     */
    private String url;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 缓存:0=关闭,1=开启
     */
    private Integer keepalive;

    /**
     * 扩展属性:none=无,add_rules_only=只添加为路由,add_menu_only=只添加为菜单
     */
    private String extend;

    /**
     * 备注
     */
    private String remark;

    /**
     * 权重
     */
    private Integer weigh;

    /**
     * 状态:0=禁用,1=启用
     */
    private String status;
}
