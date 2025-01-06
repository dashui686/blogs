package com.dashui.blogs.common.core.web;


import com.dashui.blogs.common.core.constants.HttpStatus;
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
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(HttpStatus.SUCCESS);
        rspData.setMsg("查询成功");
        rspData.setList(list);
        rspData.setTotal(list.size());
        return rspData;
    }

    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected R toAjax(int rows) {
        return rows > 0 ? R.success() : R.error();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected R toAjax(boolean result) {
        return result ? R.success() : R.error();
    }

    /**
     * 成功响应返回结果
     *
     * @param data 结果
     * @return 操作结果
     */
    protected R success(Object data) {
        return R.success(data);
    }
    /**
     * 成功响应返回结果
     *
     * @return 操作结果
     */
    protected R success() {
        return R.success(null);
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
    public R error()
    {
        return R.error();
    }


    /**
     * 返回失败消息
     */
    public R error(String message)
    {
        return R.error(message);
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
