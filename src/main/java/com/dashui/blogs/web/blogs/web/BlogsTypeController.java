package com.dashui.blogs.web.blogs.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.core.web.BaseController;


import com.dashui.blogs.domain.BlogsType;

import com.dashui.blogs.service.blogs.BlogsTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * 博客类型表(BlogsType)表控制层
 *
 * @author makejava
 * @since 2023-04-15 12:47:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("admin/blog/type")
public class BlogsTypeController extends BaseController {
    /**
     * 服务对象
     */
    private final BlogsTypeService blogsTypeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param blogsType 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public TableDataInfo selectAll(Page<BlogsType> page, BlogsType blogsType) {
        return TableDataInfo.build(this.blogsTypeService.page(page, new QueryWrapper<>(blogsType)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return success(this.blogsTypeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogsType 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody BlogsType blogsType) {
        return toAjax(this.blogsTypeService.save(blogsType));
    }

    /**
     * 修改数据
     *
     * @param blogsType 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody BlogsType blogsType) {
        return toAjax(this.blogsTypeService.updateById(blogsType));
    }

    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("id") Integer id) {
        return toAjax(this.blogsTypeService.removeById(id));
    }
}

