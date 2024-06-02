package com.dashui.blogs.freamwork.core.saToken.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态
 *
 * @author ruoyi
 */
@Getter
@AllArgsConstructor
public enum UserStatus {

    /**
     * 停用
     */
    DISABLE("0", "停用"),
    /**
     * 正常
     */
    OK("1", "正常"),
    /**
     * 删除
     */
    DELETED("2", "删除");

    private final String code;
    private final String info;

}
