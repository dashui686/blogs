package com.dashui.blogs.generetor;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

public class FastAutoGeneratorTest {

    public static void main(String[] args) {
        // 使用 FastAutoGenerator 快速配置代码生成器
        FastAutoGenerator.create("jdbc:mysql://lidashui.top:3806/buildadmin?serverTimezone=GMT%2B8", "root", "123456")

                // 全局配置
                .globalConfig(builder -> {
                    builder.author("DaShui") // 设置作者
                            // .enableKotlin() 开启 Kotlin 模式 默认值: false
                            // swagger3
                            .enableSpringdoc()
                            // .enableSwagger() //开启 Swagger 模式	默认值: false
                            .disableOpenDir() // 禁止自动打开输出目录 默认值: true
                            .dateType(DateType.TIME_PACK) // 设置时间类型策略	DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                            .commentDate("yyyy-MM-dd hh:mm:ss") // 设置注释日期格式	默认值: yyyy-MM-dd
                            .outputDir("src\\main\\java"); // 输出目录 默认值: Windows: D:// Linux/Mac: /tmp

                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("com.dashui.test") // 设置父包名
                            // .moduleName() //设置父包模块名	默认值: 无
                            .entity("domain") // 设置实体类包名
                            .mapper("mapper") // 设置 Mapper 接口包名
                            .service("service") // 设置 Service 接口包名
                            .serviceImpl("service.impl") // 设置 Service 实现类包名
                            .controller("controller") // 设置 Controller 包名	默认值: controller
                            // .pathInfo() 设置路径配置信息	Collections.singletonMap(OutputFile.mapperXml, "D://")
                            .xml("mappers"); // 设置 Mapper XML 文件包名
                })
                // 注入配置
                .injectionConfig(builder -> {
                    builder.beforeOutputFile((tableInfo, stringObjectMap) -> {
                        System.out.println("准备生成文件信息: " + tableInfo.getCommonFields());
                        // 可以在这里添加自定义逻辑，如修改 objectMap 中的配置
                        System.out.println("准备生成文件的数据: " + stringObjectMap);
                        stringObjectMap.entrySet().forEach(stringObjectEntry -> {
                            System.out.print("key: " + stringObjectEntry.getKey() + ";");
                            System.out.print("       ");
                            System.out.print("value: " + stringObjectEntry.getValue() + ";");
                            System.out.println();

                        });
                    }).build();
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder
                            // 前缀
                            .addTablePrefix("ba_")
                            .addInclude("ba_area") // 设置需要生成的表名
                    ;

                    // 模板配置
                    builder
                            .serviceBuilder()
                            .serviceTemplate("templates/service.java")
                            .serviceImplTemplate("templates/serviceImpl.java")
                            .enableFileOverride()
                            .entityBuilder()
                            .javaTemplate("templates/entity.java")
                             // lombok 默认 false
                            .enableLombok()
                             // 链式模式
                            .enableChainModel()
                            .enableTableFieldAnnotation()
                            .enableActiveRecord()
                            .versionColumnName("version")
                            .versionPropertyName("version")
                            .logicDeleteColumnName("del_flag")
                            .logicDeletePropertyName("del_flag")
                            .addTableFills(new Column("create_time", FieldFill.INSERT),new Column("create_by", FieldFill.INSERT),new Column("update_time", FieldFill.INSERT_UPDATE),new Column("update_by", FieldFill.INSERT_UPDATE))
                            .enableFileOverride()
                            .controllerBuilder()
                            .enableRestStyle()
                            .template("templates/controller.java")
                            .enableFileOverride()
                            .mapperBuilder()
                            .mapperTemplate("templates/mapper.java")
                            .mapperXmlTemplate("templates/mapper.xml")
                            // 基础列
                            .enableBaseColumnList()
                            // 基础列返回结果映射map
                            .enableBaseResultMap()
                            .enableFileOverride()
                    ;
                })
                .templateEngine(new VelocityTemplateEngine()) // 使用 Velocity 模板引擎
                .execute(); // 执行生成
    }
    {

    }
}
