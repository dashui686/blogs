package com.dashui.blogs.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.dashui.blogs.bo.AdminRuleBo;
import com.dashui.blogs.vo.AdminRuleRoute;
import com.dashui.blogs.vo.AdminRuleVo;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import lombok.Data;

/**
 * 菜单和权限规则表
 * @TableName admin_rule
 */
@TableName(value ="admin_rule")
@Data
@AutoMappers({
        @AutoMapper(target = AdminRuleRoute.class),
        @AutoMapper(target = AdminRuleVo.class)
})
public class AdminRule implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 上级菜单
     */
    @TableField(value = "pid")
    private Long pid;

    /**
     * 类型:menu_dir=菜单目录,menu=菜单项,button=页面按钮
     */
    @TableField(value = "type")
    private String type;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 规则名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 路由路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 菜单类型:tab=选项卡,link=链接,iframe=Iframe
     */
    @TableField(value = "menu_type")
    private String menu_type;

    /**
     * Url
     */
    @TableField(value = "url")
    private String url;

    /**
     * 组件路径
     */
    @TableField(value = "component")
    private String component;

    /**
     * 缓存:0=关闭,1=开启
     */
    @TableField(value = "keepalive")
    private Integer keepalive;

    /**
     * 扩展属性:none=无,add_rules_only=只添加为路由,add_menu_only=只添加为菜单
     */
    @TableField(value = "extend")
    private String extend;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 权重
     */
    @TableField(value = "weigh")
    private Integer weigh;

    /**
     * 状态:0=禁用,1=启用
     */
    @TableField(value = "status")
    private String status;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime update_time;

    /**
     * 创建时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime create_time;

    /**
     * 创建人
     */
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private Long create_by;

    /**
     * 更新人
     */
    @TableField(value = "update_by",fill = FieldFill.INSERT_UPDATE)
    private Long update_by;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField(value = "del_flag")
    private String del_flag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdminRule other = (AdminRule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getMenu_type() == null ? other.getMenu_type() == null : this.getMenu_type().equals(other.getMenu_type()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getComponent() == null ? other.getComponent() == null : this.getComponent().equals(other.getComponent()))
            && (this.getKeepalive() == null ? other.getKeepalive() == null : this.getKeepalive().equals(other.getKeepalive()))
            && (this.getExtend() == null ? other.getExtend() == null : this.getExtend().equals(other.getExtend()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getWeigh() == null ? other.getWeigh() == null : this.getWeigh().equals(other.getWeigh()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getCreate_by() == null ? other.getCreate_by() == null : this.getCreate_by().equals(other.getCreate_by()))
            && (this.getUpdate_by() == null ? other.getUpdate_by() == null : this.getUpdate_by().equals(other.getUpdate_by()))
            && (this.getDel_flag() == null ? other.getDel_flag() == null : this.getDel_flag().equals(other.getDel_flag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getMenu_type() == null) ? 0 : getMenu_type().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getComponent() == null) ? 0 : getComponent().hashCode());
        result = prime * result + ((getKeepalive() == null) ? 0 : getKeepalive().hashCode());
        result = prime * result + ((getExtend() == null) ? 0 : getExtend().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getWeigh() == null) ? 0 : getWeigh().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getCreate_by() == null) ? 0 : getCreate_by().hashCode());
        result = prime * result + ((getUpdate_by() == null) ? 0 : getUpdate_by().hashCode());
        result = prime * result + ((getDel_flag() == null) ? 0 : getDel_flag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", type=").append(type);
        sb.append(", title=").append(title);
        sb.append(", name=").append(name);
        sb.append(", path=").append(path);
        sb.append(", icon=").append(icon);
        sb.append(", menu_type=").append(menu_type);
        sb.append(", url=").append(url);
        sb.append(", component=").append(component);
        sb.append(", keepalive=").append(keepalive);
        sb.append(", extend=").append(extend);
        sb.append(", remark=").append(remark);
        sb.append(", weigh=").append(weigh);
        sb.append(", status=").append(status);
        sb.append(", update_time=").append(update_time);
        sb.append(", create_time=").append(create_time);
        sb.append(", create_by=").append(create_by);
        sb.append(", update_by=").append(update_by);
        sb.append(", del_flag=").append(del_flag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
