package com.dashui.blogs.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;


import com.dashui.blogs.freamwork.core.mapstructplus.StringAsList;
import com.dashui.blogs.vo.AdminGroupInfoVo;
import com.dashui.blogs.vo.AdminGroupVo;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMappers;
import io.github.linpeilie.annotations.AutoMapping;
import lombok.Data;

/**
 * 管理分组表
 * @TableName admin_group
 */
@TableName(value ="admin_group")
@Data
@AutoMappers({
        @AutoMapper(target = AdminGroupInfoVo.class,uses = StringAsList.class),
        @AutoMapper(target = AdminGroupVo.class)
})
public class AdminGroup implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 上级分组
     */
    @TableField(value = "pid")
    private Long pid;

    /**
     * 组名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 权限规则ID
     */
    @TableField(value = "rules")
    // @AutoMapping(targetClass = AdminGroupDto.class, target = "rules", expression = "java(java.lang.String.join(\",\", source.getEducationList()))")
    @AutoMapping(targetClass = AdminGroupInfoVo.class, target = "rules", qualifiedByName = "stringToListString")
    private String rules;

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

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

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
        AdminGroup other = (AdminGroup) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRules() == null ? other.getRules() == null : this.getRules().equals(other.getRules()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getCreate_by() == null ? other.getCreate_by() == null : this.getCreate_by().equals(other.getCreate_by()))
            && (this.getUpdate_by() == null ? other.getUpdate_by() == null : this.getUpdate_by().equals(other.getUpdate_by()))
            && (this.getDel_flag() == null ? other.getDel_flag() == null : this.getDel_flag().equals(other.getDel_flag()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRules() == null) ? 0 : getRules().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getCreate_by() == null) ? 0 : getCreate_by().hashCode());
        result = prime * result + ((getUpdate_by() == null) ? 0 : getUpdate_by().hashCode());
        result = prime * result + ((getDel_flag() == null) ? 0 : getDel_flag().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", rules=").append(rules);
        sb.append(", status=").append(status);
        sb.append(", update_time=").append(update_time);
        sb.append(", create_time=").append(create_time);
        sb.append(", create_by=").append(create_by);
        sb.append(", update_by=").append(update_by);
        sb.append(", del_flag=").append(del_flag);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
