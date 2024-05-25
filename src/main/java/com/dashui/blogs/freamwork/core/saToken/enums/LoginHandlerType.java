package com.dashui.blogs.freamwork.core.saToken.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Administrator$
 * @Date 2024/5/10$
 * @PackageName: com.dashui.blogs.freamwork.core.saToken.enums$
 * @ClassName: LoginHandlerType$
 * @Description: TODO
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum LoginHandlerType {

    USER("User"),
    Admin("Admin");

    private final String loginHandlerType;



}
