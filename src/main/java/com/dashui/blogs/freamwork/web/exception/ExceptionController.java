package com.dashui.blogs.freamwork.web.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.dashui.blogs.common.core.constants.HttpStatus;
import com.dashui.blogs.common.core.web.R;
import com.dashui.blogs.freamwork.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;


/**
 * @Author Administrator$
 * @Date 2024/5/1$
 * @PackageName: com.dashui.blogs.freamwork.web$
 * @ClassName: ExceptionController$
 * @Description: TODO
 * @Version 1.0
 */
@RestControllerAdvice
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    /**
     * 校验异常
     */
    @ExceptionHandler(BindException.class)
    public R handleBindException(BindException e)
    {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return R.error(message);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public R handleBindException(ServiceException e)
    {
        log.error(e.getMessage(), e);
        return R.error(e.getMessage());
    }

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public R handleBindException(RuntimeException e)
    {
        log.error(e.getMessage(), e);
        return R.error(e.getMessage());
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        log.error(e.getMessage(), e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return R.error(message);
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                          HttpServletRequest request)
    {
        log.error("请求地址'{}',不支持'{}'请求", request.getRequestURI(), e.getMethod());
        return R.error(e.getMessage());
    }


    /**
     * 认证失败
     */
    @ExceptionHandler(NotLoginException.class)
    public R handleNotLoginException(NotLoginException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();

        log.error("请求地址'{}',认证失败'{}',无法访问系统资源", requestURI, e.getMessage());
        return R.error(Arrays.asList(NotLoginException.TOKEN_TIMEOUT,NotLoginException.TOKEN_FREEZE).contains(e.getType())?HttpStatus.FORBIDDEN:HttpStatus.UNAUTHORIZED, "认证失败，无法访问系统资源");
    }



}
