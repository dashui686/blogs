package com.dashui.blogs.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 博客表
 * @TableName blogs
 */
@TableName(value ="blogs")
@Data
public class Blogs implements Serializable {
    /**
     * 主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 封面
     */
    @TableField(value = "cover")
    private String cover;

    /**
     * 摘要
     */
    @TableField(value = "description")
    private String description;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 置顶
     */
    @TableField(value = "top")
    private Integer top;

    /**
     * 点赞
     */
    @TableField(value = "praise")
    private Integer praise;

    /**
     * 浏览
     */
    @TableField(value = "browse")
    private Integer browse;

    /**
     * 禁止观看
     */
    @TableField(value = "disable")
    private Integer disable;

    /**
     * 发布时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime create_time;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private LocalDateTime update_time;

    /**
     * 创建人
     */
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private String create_by;

    /**
     * 更新人
     */
    @TableField(value = "update_by",fill = FieldFill.UPDATE)
    private String update_by;

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
        Blogs other = (Blogs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getCover() == null ? other.getCover() == null : this.getCover().equals(other.getCover()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getTop() == null ? other.getTop() == null : this.getTop().equals(other.getTop()))
            && (this.getPraise() == null ? other.getPraise() == null : this.getPraise().equals(other.getPraise()))
            && (this.getBrowse() == null ? other.getBrowse() == null : this.getBrowse().equals(other.getBrowse()))
            && (this.getDisable() == null ? other.getDisable() == null : this.getDisable().equals(other.getDisable()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()))
            && (this.getCreate_by() == null ? other.getCreate_by() == null : this.getCreate_by().equals(other.getCreate_by()))
            && (this.getUpdate_by() == null ? other.getUpdate_by() == null : this.getUpdate_by().equals(other.getUpdate_by()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCover() == null) ? 0 : getCover().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getTop() == null) ? 0 : getTop().hashCode());
        result = prime * result + ((getPraise() == null) ? 0 : getPraise().hashCode());
        result = prime * result + ((getBrowse() == null) ? 0 : getBrowse().hashCode());
        result = prime * result + ((getDisable() == null) ? 0 : getDisable().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        result = prime * result + ((getCreate_by() == null) ? 0 : getCreate_by().hashCode());
        result = prime * result + ((getUpdate_by() == null) ? 0 : getUpdate_by().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", cover=").append(cover);
        sb.append(", description=").append(description);
        sb.append(", sort=").append(sort);
        sb.append(", top=").append(top);
        sb.append(", praise=").append(praise);
        sb.append(", browse=").append(browse);
        sb.append(", disable=").append(disable);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", create_by=").append(create_by);
        sb.append(", update_by=").append(update_by);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
