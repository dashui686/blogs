package com.dashui.blogs.web.blogs.web;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.core.web.AjaxResult;
import com.dashui.blogs.common.core.web.BaseController;
import com.dashui.blogs.domain.Blogs;
import com.dashui.blogs.dto.BlogsDto;
import com.dashui.blogs.service.blogs.BlogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 博客表(Blogs)表控制层
 *
 * @author makejava
 * @since 2023-04-12 21:12:42
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("admin/blog/blogs")
public class BlogsController extends BaseController {
    /**
     * 服务对象
     */
    private final BlogsService blogsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param blogs 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public TableDataInfo selectAll(Blogs blogs) {

        // return getDataTable(this.blogsService.list(new QueryWrapper<>(blogs)));
        return null;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return success(this.blogsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogsDto 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody BlogsDto blogsDto) {
        long count = blogsService.count(new QueryWrapper<Blogs>().lambda().eq(Blogs::getTitle, blogsDto.getTitle()));
        if(count>0){
            return error("标题已存在,请重新输入 ");
        }
        return toAjax(this.blogsService.save(blogsDto));
    }

    /**
     * 修改数据
     *
     * @param blogs 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody Blogs blogs) {
        return toAjax(this.blogsService.updateById(blogs));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return toAjax(this.blogsService.removeByIds(idList));
    }
}

