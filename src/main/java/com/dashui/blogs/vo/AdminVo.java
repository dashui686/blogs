package com.dashui.blogs.vo;

import com.dashui.blogs.domain.Admin;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author Administrator$
 * @Date 2024/5/19$
 * @PackageName: com.dashui.blogs.vo$
 * @ClassName: AdminVo$
 * @Description: TODO
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@AutoMapper(target = Admin.class)
public class AdminVo {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 密码
     */
    @JsonIgnore
    @JsonProperty
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 备注
     */
    private String motto;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 创建时间
     */
    private LocalDateTime update_time;

    /**
     * 分组ID
     */
    private List<Long> groupArr;


    /**
     * 分组名称
     */
    private List<String> groupNameArr;

}
