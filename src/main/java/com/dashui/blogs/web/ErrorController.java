package com.dashui.blogs.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
    /**
     * 重新抛出异常
     */
    @RequestMapping("/error/exthrow")
    public void rethrow(HttpServletRequest request) throws Exception {
        throw ((Exception) request.getAttribute("filter.error"));
    }
}
