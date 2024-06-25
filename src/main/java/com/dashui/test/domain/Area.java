package com.dashui.test.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 省份地区表
 * </p>
 *
 * @author DaShui
 * @since 2024-06-25 11:30:36
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("ba_area")
@Schema(name = "Area", description = "省份地区表")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "父id")
    @TableField("pid")
    private Integer pid;

    @Schema(description = "简称")
    @TableField("shortname")
    private String shortname;

    @Schema(description = "名称")
    @TableField("name")
    private String name;

    @Schema(description = "全称")
    @TableField("mergename")
    private String mergename;

    @Schema(description = "层级:1=省,2=市,3=区/县")
    @TableField("level")
    private Byte level;

    @Schema(description = "拼音")
    @TableField("pinyin")
    private String pinyin;

    @Schema(description = "长途区号")
    @TableField("code")
    private String code;

    @Schema(description = "邮编")
    @TableField("zip")
    private String zip;

    @Schema(description = "首字母")
    @TableField("first")
    private String first;

    @Schema(description = "经度")
    @TableField("lng")
    private String lng;

    @Schema(description = "纬度")
    @TableField("lat")
    private String lat;
}
