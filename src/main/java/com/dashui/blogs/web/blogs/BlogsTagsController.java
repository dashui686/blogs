package com.dashui.blogs.web.blogs;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.common.core.web.BaseController;

import com.dashui.blogs.domain.BlogTag;
import com.dashui.blogs.service.blogs.BlogTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * 博客标签表(BlogTag)表控制层
 *
 * @author makejava
 * @since 2023-04-15 12:47:37
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("admin/blog/tag")
public class BlogsTagsController extends BaseController {
    /**
     * 服务对象
     */
    private final BlogTagService blogTagsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param BlogTag 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public TableDataInfo selectAll(Page<BlogTag> page, BlogTag BlogTag) {
        return TableDataInfo.build(this.blogTagsService.page(page, new QueryWrapper<>(BlogTag)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogTagsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param BlogTag 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogTag BlogTag) {
        return toAjax(this.blogTagsService.save(BlogTag));
    }

    /**
     * 修改数据
     *
     * @param BlogTag 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BlogTag BlogTag) {
        return toAjax(this.blogTagsService.updateById(BlogTag));
    }

    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("id") Integer id) {
        return toAjax(this.blogTagsService.removeById(id));
    }
}

