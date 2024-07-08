package com.dashui.blogs.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 博客类型映射表
 * @TableName blogs_type_mapping
 */
@TableName(value ="blogs_type_mapping")
@Data
public class BlogsTypeMapping implements Serializable {
    /**
     * 博客主键
     */
    @TableField(value = "blogs_id")
    private Integer blogsId;

    /**
     * 类型主键
     */
    @TableField(value = "type_id")
    private Integer typeId;

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
        BlogsTypeMapping other = (BlogsTypeMapping) that;
        return (this.getBlogsId() == null ? other.getBlogsId() == null : this.getBlogsId().equals(other.getBlogsId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBlogsId() == null) ? 0 : getBlogsId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blogsId=").append(blogsId);
        sb.append(", typeId=").append(typeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
