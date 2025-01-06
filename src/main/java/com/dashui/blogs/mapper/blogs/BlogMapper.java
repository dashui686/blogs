package com.dashui.blogs.mapper.blogs;

import com.dashui.blogs.domain.Blog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dashui.blogs.freamwork.core.mybatisplus.mapper.BaseMapperPlus;
import com.dashui.blogs.vo.BlogVo;

/**
* @author Administrator
* @description 针对表【blog(博客表)】的数据库操作Mapper
* @createDate 2025-01-04 04:07:24
* @Entity com.dashui.blogs.domain.Blog
*/
public interface BlogMapper extends BaseMapperPlus<Blog, BlogVo> {

}




