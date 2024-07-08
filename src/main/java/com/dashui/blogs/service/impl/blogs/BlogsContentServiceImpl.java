package com.dashui.blogs.service.impl.blogs;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.BlogsContent;
import com.dashui.blogs.mapper.blogs.BlogsContentMapper;
import com.dashui.blogs.service.blogs.BlogsContentService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【blogs_content(博客内容)】的数据库操作Service实现
* @createDate 2023-04-16 13:08:20
*/
@Service
public class BlogsContentServiceImpl extends ServiceImpl<BlogsContentMapper, BlogsContent>
    implements BlogsContentService {

}




