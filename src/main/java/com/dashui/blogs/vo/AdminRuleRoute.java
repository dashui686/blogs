package com.dashui.blogs.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.dashui.blogs.domain.AdminRule;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 菜单和权限规则表
 * @TableName admin_rule
 */
@Data
@NoArgsConstructor
public class AdminRuleRoute implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 上级菜单
     */
    private Integer pid;

    /**
     * 类型:menu_dir=菜单目录,menu=菜单项,button=页面按钮
     */
    private Object type;

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
    private Object menuType;

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
    private Object extend;

    private List<AdminRuleRoute> children;


    private static final long serialVersionUID = 1L;

    public AdminRuleRoute(AdminRule adminRule){
        this.id = adminRule.getId();
        this.pid = adminRule.getPid();
        this.type = adminRule.getType();
        this.title = adminRule.getTitle();
        this.name = adminRule.getName();
        this.path = adminRule.getPath();
        this.icon = adminRule.getIcon();
        this.menuType = adminRule.getMenuType();
        this.url = adminRule.getUrl();
        this.component = adminRule.getComponent();
        this.keepalive = adminRule.getKeepalive();
        this.extend = adminRule.getExtend();
    }

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
            && (this.getMenuType() == null ? other.getMenuType() == null : this.getMenuType().equals(other.getMenuType()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getComponent() == null ? other.getComponent() == null : this.getComponent().equals(other.getComponent()))
            && (this.getKeepalive() == null ? other.getKeepalive() == null : this.getKeepalive().equals(other.getKeepalive()))
            && (this.getExtend() == null ? other.getExtend() == null : this.getExtend().equals(other.getExtend()));
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
        result = prime * result + ((getMenuType() == null) ? 0 : getMenuType().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getComponent() == null) ? 0 : getComponent().hashCode());
        result = prime * result + ((getKeepalive() == null) ? 0 : getKeepalive().hashCode());
        result = prime * result + ((getExtend() == null) ? 0 : getExtend().hashCode());
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
        sb.append(", menuType=").append(menuType);
        sb.append(", url=").append(url);
        sb.append(", component=").append(component);
        sb.append(", keepalive=").append(keepalive);
        sb.append(", extend=").append(extend);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
