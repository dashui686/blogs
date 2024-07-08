package com.dashui.blogs.service.blogs;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dashui.blogs.domain.Blogs;
import com.dashui.blogs.dto.BlogsDto;

/**
* @author Administrator
* @description 针对表【blogs(博客表)】的数据库操作Service
* @createDate 2023-04-12 21:38:49
*/

public interface BlogsService extends IService<Blogs> {



    boolean save(BlogsDto blogsDto);
}
