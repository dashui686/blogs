package com.dashui.blogs.web.blogs;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.common.core.web.BaseController;


import com.dashui.blogs.domain.BlogType;
import com.dashui.blogs.service.blogs.BlogTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * 博客类型表(BlogType)表控制层
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
    private final BlogTypeService blogTypeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param BlogType 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public TableDataInfo selectAll(Page<BlogType> page, BlogType BlogType) {
        return TableDataInfo.build(this.blogTypeService.page(page, new QueryWrapper<>(BlogType)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogTypeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param BlogType 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogType BlogType) {
        return toAjax(this.blogTypeService.save(BlogType));
    }

    /**
     * 修改数据
     *
     * @param BlogType 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody BlogType BlogType) {
        return toAjax(this.blogTypeService.updateById(BlogType));
    }

    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("id") Integer id) {
        return toAjax(this.blogTypeService.removeById(id));
    }
}

