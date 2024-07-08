package com.dashui.blogs.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 博客标签映射表
 * @TableName blogs_tags_mapping
 */
@TableName(value ="blogs_tags_mapping")
@Data
public class BlogsTagsMapping implements Serializable {
    /**
     * 博客主键
     */
    @TableField(value = "blogs_id")
    private Integer blogsId;

    /**
     * 标签主键
     */
    @TableField(value = "tags_id")
    private Integer tagsId;

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
        BlogsTagsMapping other = (BlogsTagsMapping) that;
        return (this.getBlogsId() == null ? other.getBlogsId() == null : this.getBlogsId().equals(other.getBlogsId()))
            && (this.getTagsId() == null ? other.getTagsId() == null : this.getTagsId().equals(other.getTagsId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBlogsId() == null) ? 0 : getBlogsId().hashCode());
        result = prime * result + ((getTagsId() == null) ? 0 : getTagsId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blogsId=").append(blogsId);
        sb.append(", tagsId=").append(tagsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
