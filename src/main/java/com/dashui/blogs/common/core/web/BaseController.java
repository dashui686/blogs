package com.dashui.blogs.common.core.web;


import com.dashui.blogs.common.core.page.TableDataInfo;
import com.dashui.blogs.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * web层通用数据处理
 *
 * @author ruoyi
 */
public class BaseController
{
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows) {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected AjaxResult toAjax(boolean result) {
        return result ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 成功响应返回结果
     *
     * @param data 结果
     * @return 操作结果
     */
    protected AjaxResult success(Object data) {
        return AjaxResult.success(data);
    }
    /**
     * 成功响应返回结果
     *
     * @return 操作结果
     */
    protected AjaxResult success() {
        return AjaxResult.success(null);
    }
    /**
     * 页面跳转
     */
    public String redirect(String url) {
        return StringUtils.format("redirect:{}", url);
    }


    /**
     * 返回失败消息
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }


    /**
     * 返回失败消息
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }


    // /**
    //  * 响应请求分页数据
    //  */
    // @SuppressWarnings({ "rawtypes", "unchecked" })
    // protected TableDataInfo getDataTable(List<?> list)
    // {
    //     TableDataInfo rspData = new TableDataInfo();
    //
    //     rspData.setCode(HttpStatus.SUCCESS);
    //     rspData.setRows(list);
    //     rspData.setMsg("查询成功");
    //     rspData.setTotal(new PageInfo(list).getTotal());
    //     return rspData;
    // }
    //
    // /**
    //  * Es响应请求分页数据
    //  */
    // @SuppressWarnings({ "rawtypes", "unchecked" })
    // protected TableDataInfo getDataTable(List<?> list,long total)
    // {
    //     TableDataInfo rspData = new TableDataInfo();
    //     rspData.setCode(HttpStatus.SUCCESS);
    //     rspData.setRows(list);
    //     rspData.setMsg("查询成功");
    //     rspData.setTotal(total);
    //     return rspData;
    // }
}
