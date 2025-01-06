package com.dashui.blogs.service.impl.blogs;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.BlogTag;
import com.dashui.blogs.service.blogs.BlogTagService;
import com.dashui.blogs.mapper.blogs.BlogTagMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blog_tag(博客标签表)】的数据库操作Service实现
* @createDate 2025-01-04 04:07:24
*/
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag>
    implements BlogTagService{

}




