package com.dashui.blogs.service.impl.blogs;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.BlogTagMapping;
import com.dashui.blogs.service.blogs.BlogTagMappingService;
import com.dashui.blogs.mapper.blogs.BlogTagMappingMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blog_tag_mapping(博客标签映射表)】的数据库操作Service实现
* @createDate 2025-01-04 04:07:24
*/
@Service
public class BlogTagMappingServiceImpl extends ServiceImpl<BlogTagMappingMapper, BlogTagMapping>
    implements BlogTagMappingService{

}




