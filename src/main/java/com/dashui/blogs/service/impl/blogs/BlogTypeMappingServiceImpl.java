package com.dashui.blogs.service.impl.blogs;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.BlogTypeMapping;
import com.dashui.blogs.service.blogs.BlogTypeMappingService;
import com.dashui.blogs.mapper.blogs.BlogTypeMappingMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blog_type_mapping(博客类型映射表)】的数据库操作Service实现
* @createDate 2025-01-04 04:07:24
*/
@Service
public class BlogTypeMappingServiceImpl extends ServiceImpl<BlogTypeMappingMapper, BlogTypeMapping>
    implements BlogTypeMappingService{

}




