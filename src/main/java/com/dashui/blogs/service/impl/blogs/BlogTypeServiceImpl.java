package com.dashui.blogs.service.impl.blogs;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.BlogType;
import com.dashui.blogs.service.blogs.BlogTypeService;
import com.dashui.blogs.mapper.blogs.BlogTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blog_type(博客类型表)】的数据库操作Service实现
* @createDate 2025-01-04 04:07:24
*/
@Service
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType>
    implements BlogTypeService{

}




