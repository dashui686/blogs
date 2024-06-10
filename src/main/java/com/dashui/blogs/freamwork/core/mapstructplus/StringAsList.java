package com.dashui.blogs.freamwork.core.mapstructplus;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.dashui.blogs.common.core.constants.StringConstants;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StringAsList {
    @Named("stringToListString")
    public List<String> stringToListString(String str) {
        return StrUtil.split(str, StringConstants.SEPARATOR);
    }
    @Named("listStringToString")
    public String listStringToString(List<String> str) {
        if(CollUtil.isNotEmpty(str)){
            return str.stream().collect(Collectors.joining(StringConstants.SEPARATOR));
        }
        return StringConstants.EMPTY;
    }
}
