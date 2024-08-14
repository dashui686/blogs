package com.dashui.blogs.freamwork.core.saToken.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户登录对象
 *
 * @author Lion Li
 */

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginBody implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 验证码ID
     */
    private String captchaId;

    /**
     * 验证码信息
     */
    private String captchaInfo;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid;

    private boolean keep;


    public LoginBody(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
