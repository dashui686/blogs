package com.dashui.blogs.service.impl.blogs;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.Blogs;
import com.dashui.blogs.domain.BlogsContent;
import com.dashui.blogs.domain.BlogsTagsMapping;
import com.dashui.blogs.domain.BlogsTypeMapping;
import com.dashui.blogs.dto.BlogsDto;
import com.dashui.blogs.mapper.blogs.BlogsMapper;
import com.dashui.blogs.service.blogs.BlogsContentService;
import com.dashui.blogs.service.blogs.BlogsService;
import com.dashui.blogs.service.blogs.BlogsTagsMappingService;
import com.dashui.blogs.service.blogs.BlogsTypeMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Administrator
* @description 针对表【blogs(博客表)】的数据库操作Service实现
* @createDate 2023-04-12 21:38:49
*/
@Service
@RequiredArgsConstructor
public class BlogsServiceImpl extends ServiceImpl<BlogsMapper, Blogs>
    implements BlogsService {

    private final BlogsContentService contentService;
    private final BlogsTypeMappingService typeMappingService;
    private final BlogsTagsMappingService tagsMappingService;

    @Override
    @Transactional
    public boolean save(BlogsDto blogsDto) {
        Blogs blogs = new Blogs();
        List<BlogsTagsMapping> tag = blogsDto.getTag();
        List<BlogsTypeMapping> type = blogsDto.getType();
        BlogsContent blogsContent = new BlogsContent();
        BeanUtil.copyProperties(blogsDto, blogs);
        BeanUtil.copyProperties(blogsDto, blogsContent);
        this.save(blogs);
        blogsContent.setBlogsId(blogs.getId());
        contentService.save(blogsContent);
        tag.forEach(e -> e.setBlogsId(blogs.getId()));
        type.forEach(e -> e.setBlogsId(blogs.getId()));
        tagsMappingService.remove(new QueryWrapper<BlogsTagsMapping>().eq("blogs_id", blogs.getId()));
        typeMappingService.remove(new QueryWrapper<BlogsTypeMapping>().eq("blogs_id", blogs.getId()));
        tagsMappingService.saveBatch(tag);
        typeMappingService.saveBatch(type);
        return true;
    }
}




