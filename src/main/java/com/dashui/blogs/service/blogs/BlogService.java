package com.dashui.blogs.service.blogs;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.blogs.bo.BlogBo;
import com.dashui.blogs.common.core.page.PageQuery;
import com.dashui.blogs.domain.Blog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dashui.blogs.vo.BlogVo;

/**
* @author Administrator
* @description 针对表【blog(博客表)】的数据库操作Service
* @createDate 2025-01-04 04:07:24
*/
public interface BlogService extends IService<Blog> {

    Page<BlogVo> selectPagePostList(BlogBo blogBo, PageQuery pageQuery);
}
