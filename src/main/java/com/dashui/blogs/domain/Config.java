package com.dashui.blogs.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 系统配置
 * @TableName config
 */
@TableName(value ="config")
@Data
public class Config implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 变量名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 分组
     */
    @TableField(value = "`group`")
    private String group;

    /**
     * 变量标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 变量描述
     */
    @TableField(value = "tip")
    private String tip;

    /**
     * 变量输入组件类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 变量值
     */
    @TableField(value = "value")
    private String value;

    /**
     * 字典数据
     */
    @TableField(value = "content")
    private String content;

    /**
     * 验证规则
     */
    @TableField(value = "rule")
    private String rule;

    /**
     * 扩展属性
     */
    @TableField(value = "extend")
    private String extend;

    /**
     * 允许删除:0=否,1=是
     */
    @TableField(value = "allow_del")
    private Integer allowDel;

    /**
     * 权重
     */
    @TableField(value = "weigh")
    private Integer weigh;

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
    private Object del_flag;

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
        Config other = (Config) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGroup() == null ? other.getGroup() == null : this.getGroup().equals(other.getGroup()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTip() == null ? other.getTip() == null : this.getTip().equals(other.getTip()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getRule() == null ? other.getRule() == null : this.getRule().equals(other.getRule()))
            && (this.getExtend() == null ? other.getExtend() == null : this.getExtend().equals(other.getExtend()))
            && (this.getAllowDel() == null ? other.getAllowDel() == null : this.getAllowDel().equals(other.getAllowDel()))
            && (this.getWeigh() == null ? other.getWeigh() == null : this.getWeigh().equals(other.getWeigh()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGroup() == null) ? 0 : getGroup().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTip() == null) ? 0 : getTip().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getRule() == null) ? 0 : getRule().hashCode());
        result = prime * result + ((getExtend() == null) ? 0 : getExtend().hashCode());
        result = prime * result + ((getAllowDel() == null) ? 0 : getAllowDel().hashCode());
        result = prime * result + ((getWeigh() == null) ? 0 : getWeigh().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", group=").append(group);
        sb.append(", title=").append(title);
        sb.append(", tip=").append(tip);
        sb.append(", type=").append(type);
        sb.append(", value=").append(value);
        sb.append(", content=").append(content);
        sb.append(", rule=").append(rule);
        sb.append(", extend=").append(extend);
        sb.append(", allowDel=").append(allowDel);
        sb.append(", weigh=").append(weigh);
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
