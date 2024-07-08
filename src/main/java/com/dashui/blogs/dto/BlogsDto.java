package com.dashui.blogs.dto;

import com.dashui.blogs.domain.BlogsTagsMapping;
import com.dashui.blogs.domain.BlogsTypeMapping;
import lombok.Data;

import java.util.List;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/16 0:58
 * @PackageName: com.dashui.blogs.domain.dto
 * @ClassName: BlogsDto
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class BlogsDto {




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
     * 内容
     */
    private String content;

    /**
     * 类型
     */
    private List<BlogsTypeMapping> type;

    /**
     * 标签
     */
    private List<BlogsTagsMapping> tag;
}
