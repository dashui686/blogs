package com.dashui.blogs.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dashui.blogs.domain.Blog;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 博客表
 * @TableName blog
 */
@EqualsAndHashCode
@Data
@AutoMapper(target = Blog.class)
public class BlogVo implements Serializable {
    /**
     * 主键自增
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 封面
     */
    private String cover;

    /**
     * 摘要
     */
    private String description;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 置顶
     */
    private Integer top;

    /**
     * 点赞
     */
    private Integer praise;

    /**
     * 浏览
     */
    private Integer browse;

    /**
     * 禁止观看
     */
    private Integer disable;

    /**
     * 发布时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    @Serial
    private static final long serialVersionUID = 1L;
}
