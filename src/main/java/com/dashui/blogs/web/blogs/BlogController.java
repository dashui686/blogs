package com.dashui.Blog.web.Blog;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.common.core.web.BaseController;
import com.dashui.blogs.domain.Blog;
import com.dashui.blogs.dto.BlogDto;
import com.dashui.blogs.service.blogs.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 博客表(Blog)表控制层
 *
 * @author makejava
 * @since 2023-04-12 21:12:42
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("admin/blog")
public class BlogController extends BaseController {
    /**
     * 服务对象
     */
    private final BlogService blogService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param Blog 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public TableDataInfo selectAll(Blog Blog) {

        // return getDataTable(this.blogService.list(new QueryWrapper<>(Blog)));
        return null;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.blogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param blogsDto 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody BlogDto blogsDto) {
        long count = blogService.count(new QueryWrapper<Blog>().lambda().eq(Blog::getTitle, blogsDto.getTitle()));
        if(count>0){
            return error("标题已存在,请重新输入 ");
        }
        // return toAjax(this.blogService.save(blogsDto));
        return toAjax(1);
    }

    /**
     * 修改数据
     *
     * @param Blog 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Blog Blog) {
        return toAjax(this.blogService.updateById(Blog));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return toAjax(this.blogService.removeByIds(idList));
    }
}

