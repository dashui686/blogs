package com.dashui.blogs.vo;

import lombok.Data;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/6/29 18:21
 * @PackageName: com.dashui.blogs.domain.wx
 * @ClassName: WxUserVo
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class WxUserVo {

    /**
     *
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;


    /**
     * 签名
     */
    private String motto;


    /**
     * 备注
     */
    private String remark;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 性别
     */
    private String sex;
}
