package com.dashui.blogs.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.dashui.blogs.service.admin.AdminCrudService;
import lombok.Data;

/**
 * CRUD记录表
 * @TableName crud_log
 */
@TableName(value ="crud_log")
@Data
public class AdminCrud implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 数据表名
     */
    @TableField(value = "table_name")
    private String tableName;

    /**
     * 数据表数据
     */
    @TableField(value = "table")
    private String table;

    /**
     * 字段数据
     */
    @TableField(value = "fields")
    private String fields;

    /**
     * 状态:delete=已删除,success=成功,error=失败,start=生成中
     */
    @TableField(value = "status")
    private Object status;

    /**
     * 数据库连接配置标识
     */
    @TableField(value = "connection")
    private String connection;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Long create_time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdminCrud other = (AdminCrud) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()))
            && (this.getTable() == null ? other.getTable() == null : this.getTable().equals(other.getTable()))
            && (this.getFields() == null ? other.getFields() == null : this.getFields().equals(other.getFields()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getConnection() == null ? other.getConnection() == null : this.getConnection().equals(other.getConnection()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        result = prime * result + ((getTable() == null) ? 0 : getTable().hashCode());
        result = prime * result + ((getFields() == null) ? 0 : getFields().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getConnection() == null) ? 0 : getConnection().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tableName=").append(tableName);
        sb.append(", table=").append(table);
        sb.append(", fields=").append(fields);
        sb.append(", status=").append(status);
        sb.append(", connection=").append(connection);
        sb.append(", create_time=").append(create_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
