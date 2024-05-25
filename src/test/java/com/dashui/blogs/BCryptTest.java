package com.dashui.blogs;

import cn.dev33.satoken.secure.BCrypt;

/**
 * @Author Administrator$
 * @Date 2024/5/19$
 * @PackageName: com.dashui.blogs$
 * @ClassName: Bycoder$
 * @Description: TODO
 * @Version 1.0
 */
public class BCryptTest {

    public static void main(String[] args) {
        String hashpw = BCrypt.hashpw("123456");
        System.out.println(hashpw);
        System.out.println(hashpw.length());
        System.out.println(BCrypt.checkpw("123456",hashpw));
    }
}
