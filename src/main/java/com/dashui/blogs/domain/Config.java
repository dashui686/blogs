package com.dashui.blogs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    private Integer id;

    /**
     * 变量名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 分组
     */
    @TableField(value = "group")
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
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private Long createBy;

    /**
     * 更新人
     */
    @TableField(value = "update_by")
    private Long updateBy;

    /**
     * 是否删除
     */
    @TableField(value = "del_flag")
    private Object delFlag;

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
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
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
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
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
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}