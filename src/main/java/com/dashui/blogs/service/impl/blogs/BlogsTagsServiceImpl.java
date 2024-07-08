package com.dashui.blogs.service.impl.blogs;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.BlogsTags;
import com.dashui.blogs.mapper.blogs.BlogsTagsMapper;
import com.dashui.blogs.service.blogs.BlogsTagsService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blogs_tags(博客标签表)】的数据库操作Service实现
* @createDate 2023-04-16 13:08:20
*/
@Service
public class BlogsTagsServiceImpl extends ServiceImpl<BlogsTagsMapper, BlogsTags>
    implements BlogsTagsService {

}




