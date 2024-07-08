package com.dashui.blogs.service.impl.blogs;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.BlogsType;
import com.dashui.blogs.mapper.blogs.BlogsTypeMapper;
import com.dashui.blogs.service.blogs.BlogsTypeService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blogs_type(博客类型表)】的数据库操作Service实现
* @createDate 2023-04-16 13:08:20
*/
@Service
public class BlogsTypeServiceImpl extends ServiceImpl<BlogsTypeMapper, BlogsType>
    implements BlogsTypeService {

}




