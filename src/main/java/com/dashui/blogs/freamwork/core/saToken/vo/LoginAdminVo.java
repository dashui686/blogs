package com.dashui.blogs.freamwork.core.saToken.vo;

import com.dashui.blogs.common.core.constants.UserConstants;
import com.dashui.blogs.common.utils.StringUtils;
import com.dashui.blogs.freamwork.core.saToken.domain.LoginAdmin;
import com.dashui.blogs.vo.AdminVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 登录验证信息
 *
 * @author Michelle.Chung
 */
@Data
@NoArgsConstructor
public class LoginAdminVo implements Serializable {

    /**
     * 授权令牌
     */
    // json 序列化 名称
    @JsonProperty("token")
    private String token;

    /**
     * 刷新令牌
     */
    private String refreshToken;

    /**
     * 管理员ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 最后登录时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;

    /**
     * 是否是超级管理员
     */
    private boolean isSuper;

    public LoginAdminVo(AdminVo adminVo){
        this.setId(adminVo.getId());
        this.setUsername(adminVo.getUsername());
        this.setNickname(adminVo.getNickname());
        this.setAvatar(adminVo.getAvatar());
        this.setLastLoginTime(adminVo.getLastLoginTime());
        this.setSuper(UserConstants.SUPER_ADMIN_ID.equals(adminVo.getId()));
    }

    public LoginAdminVo(LoginAdmin loginAdmin) {
        this.setId(loginAdmin.getId());
        this.setUsername(loginAdmin.getUsername());
        this.setNickname(loginAdmin.getNickname());
        this.setAvatar(loginAdmin.getAvatar());
        this.setLastLoginTime(loginAdmin.getLoginTime());
        this.setSuper(UserConstants.SUPER_ADMIN_ID.equals(loginAdmin.getId()));
    }
}
