package com.dashui.blogs.common.core.web;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpStatus;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author 13276
 * @Description TODO
 * @Date 2023/3/18 10:37
 * @Version 1.0
 * @since 1.8
 */
public class AjaxResult extends HashMap<String, Object> implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String MSG_TAG = "msg";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /** 时间对象 */
    public static final String TIME_TAG = "time";

    /**
     * 返回数据名
     */
    public static final String ROW_TAG = "row";
    public static final String GROUP_TAG = "group";
    public static final String LIST_TAG = "list";
    public static final String OPTIONS_TAG = "options";

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public AjaxResult()
    {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     */
    public AjaxResult(int code, String msg)
    {
        super.put(CODE_TAG, code);
        super.put(TIME_TAG, new Date().getTime());
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg 返回内容
     * @param data 数据对象
     */
    public AjaxResult(int code, String msg, Object data)
    {

        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        super.put(TIME_TAG, new Date().getTime());
        if (ObjectUtil.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static AjaxResult success()
    {
        return AjaxResult.success("操作成功");
    }

    /**
     * 构建row
     *
     * @return 成功消息
     */
    public static AjaxResult options(Object data)
    {
        return AjaxResult.success().data(OPTIONS_TAG, data);
    }

    /**
     * 构建row
     *
     * @return 成功消息
     */
    public static AjaxResult group(Object data,Object list)
    {
        return AjaxResult.success().data(GROUP_TAG, data).data(LIST_TAG, list);
    }

    /**
     * 构建row
     *
     * @return 成功消息
     */
    public static AjaxResult list(Object list)
    {
        return AjaxResult.success().data(LIST_TAG, list);
    }

    /**
     * 构建row
     *
     * @return 成功消息
     */
    public static AjaxResult row(Object data)
    {
        return AjaxResult.success().data(ROW_TAG, data);
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static AjaxResult success(Object data)
    {
        return AjaxResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg)
    {
        return AjaxResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static AjaxResult success(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.HTTP_OK, msg, data);
    }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    // public static AjaxResult warn(String msg)
    // {
    //     return AjaxResult.warn(msg, null);
    // }

    /**
     * 返回警告消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    // public static AjaxResult warn(String msg, Object data)
    // {
    //     return new AjaxResult(HttpStatus.WARN, msg, data);
    // }

    /**
     * 返回错误消息
     *
     * @return 错误消息
     */
    public static AjaxResult error()
    {
        return AjaxResult.error("操作失败");
    }
    public static AjaxResult error(Integer code, String message)
    {
        return new AjaxResult(code,message);
    }


    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 错误消息
     */
    public static AjaxResult error(String msg)
    {
        return AjaxResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @param data 数据对象
     * @return 错误消息
     */
    public static AjaxResult error(String msg, Object data)
    {
        return new AjaxResult(HttpStatus.HTTP_BAD_REQUEST, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg 返回内容
     * @return 错误消息
     */
    // public static AjaxResult error(int code, String msg)
    // {
    //     return new AjaxResult(code, msg, null);
    // }

    /**
     * 是否为成功消息
     *
     * @return 结果
     */
    public boolean isSuccess()
    {
        return Objects.equals(HttpStatus.HTTP_OK, this.get(CODE_TAG));
    }

    /**
     * 是否为错误消息
     *
     * @return 结果
     */
    public boolean isError()
    {
        return !isSuccess();
    }

    /**
     * 方便链式调用
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public AjaxResult put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }

    /**
     * 数据存储调用
     *
     * @param key
     * @param value
     * @return
     */
    public AjaxResult data(String key, Object value)
    {
        Map<String,Object> o = (HashMap<String, Object>) super.get(DATA_TAG);
        if(o == null){
            o = new HashMap<String,Object>();
        }
        if(o instanceof HashMap){
            o.put(key,value);
            super.put(DATA_TAG,o);
        }
        return this;
    }
}
