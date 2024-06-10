package com.dashui.blogs.common.core.page;

import cn.hutool.http.HttpStatus;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.blogs.common.core.web.AjaxResult;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 *
 * @author Lion Li
 */

@Data
@NoArgsConstructor
public class TableDataInfo<T> extends AjaxResult implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    /** 列表 */
    public static final String LIST_TAG = "list";
    /** 返回信息 */
    public static final String MSG_TAG = "remark";
    /** 数量 */
    public static final String TOTAL_TAG = "total";


    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<T> list, long total) {
        this.data(LIST_TAG,list);
        this.data(TOTAL_TAG,total);
    }

    public TableDataInfo(int code, String msg) {
        super(code, msg);
    }

    /**
     * 初始化分页
     *
     * @param list  列表数据
     * @param total 总记录数
     * @param msg 描述信息
     */
    public static <T> TableDataInfo<T> build(List<T> list, long total,String msg) {
        TableDataInfo<T> tableDataInfo = new TableDataInfo<>(HttpStatus.HTTP_OK,"查询完成");
        tableDataInfo.data(LIST_TAG,list);
        tableDataInfo.data(TOTAL_TAG,total);
        tableDataInfo.data(MSG_TAG,msg);
        return tableDataInfo;
    }

    /**
     * 初始化分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public static <T> TableDataInfo<T> build(List<T> list, long total) {
        TableDataInfo<T> tableDataInfo = new TableDataInfo<>(HttpStatus.HTTP_OK,"查询完成");
        tableDataInfo.data(LIST_TAG,list);
        tableDataInfo.data(TOTAL_TAG,total);
        return tableDataInfo;
    }

    /**
     * 初始化分页
     *
     * @param list  列表数据
     */
    public static <T> TableDataInfo<T> build(List<T> list) {
        TableDataInfo<T> tableDataInfo = new TableDataInfo<>(HttpStatus.HTTP_OK,"查询完成");
        tableDataInfo.data(LIST_TAG,list);
        tableDataInfo.data(TOTAL_TAG,list.size());
        return tableDataInfo;
    }

    /**
     * 初始化分页
     *
     * @param page 列表数据
     */
    public static <T> TableDataInfo<T> build(IPage<T> page) {
        TableDataInfo<T> tableDataInfo = new TableDataInfo<>(HttpStatus.HTTP_OK,"查询完成");
        tableDataInfo.data(LIST_TAG,page.getRecords());
        tableDataInfo.data(TOTAL_TAG,page.getTotal());
        return tableDataInfo;
    }

    /**
     * 初始化分页失败
     *
     */
    public static <T> TableDataInfo<T> fail() {
        return new TableDataInfo<>(HttpStatus.HTTP_BAD_REQUEST,"查询失败");
    }

}
