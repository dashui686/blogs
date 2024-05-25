package com.dashui.blogs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.blogs.domain.Config;
import com.dashui.blogs.service.ConfigService;
import com.dashui.blogs.mapper.ConfigMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【config(系统配置)】的数据库操作Service实现
* @createDate 2024-05-20 11:03:04
*/
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config>
    implements ConfigService{

}




