package com.dashui.blogs.common.utils;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.dashui.blogs.common.core.crud.domain.InputType;
import com.dashui.blogs.common.core.crud.domain.MenuButton;
import com.dashui.blogs.domain.AdminCrud;
import com.dashui.blogs.service.admin.AdminCrudService;

import java.util.*;

public class CrudHelper {

    private static final AdminCrudService adminCrudService = SpringUtils.getBean(AdminCrudService.class);


    /**
     * 内部保留词
     */
    protected static final String[] reservedKeywords = new String[]{
            "abstract", "and", "array", "as", "break", "callable", "case", "catch", "class", "clone",
            "const", "continue", "declare", "default", "die", "do", "echo", "else", "elseif", "empty",
            "enddeclare", "endfor", "endforeach", "endif", "endswitch", "endwhile", "eval", "exit", "extends",
            "final", "for", "foreach", "function", "global", "goto", "if", "implements", "include", "include_once",
            "instanceof", "insteadof", "interface", "isset", "list", "namespace", "new", "or", "print", "private",
            "protected", "public", "require", "require_once", "return", "static", "switch", "throw", "trait", "try",
            "unset", "use", "var", "while", "xor", "yield", "match", "readonly", "fn"
    };

    /**
     * 预设控制器和模型文件位置
     */
    protected static final Map<String, Map<String, String[]>> parseNamePresets = new HashMap<>() {{
        Map<String, String[]> controllerPresets = new HashMap<>();
        controllerPresets.put("user", new String[]{"user", "user"});
        controllerPresets.put("admin", new String[]{"auth", "admin"});
        controllerPresets.put("admin_group", new String[]{"auth", "group"});
        controllerPresets.put("attachment", new String[]{"routine", "attachment"});
        controllerPresets.put("admin_rule", new String[]{"auth", "rule"});

        Map<String, String[]> modelPresets = new HashMap<>();
        // Add model presets here if needed

        Map<String, String[]> validatePresets = new HashMap<>();
        // Add validate presets here if needed

        put("controller", controllerPresets);
        put("model", modelPresets);
        put("validate", validatePresets);
    }};

    /**
     * 子级菜单数组(权限节点)
     */
    protected static final List<MenuButton> menuChildren = new ArrayList<>() {{
        add(new MenuButton("button", "查看", "/index", "1"));
        add(new MenuButton("button", "添加", "/add", "1"));
        add(new MenuButton("button", "编辑", "/edit", "1"));
        add(new MenuButton("button", "删除", "/del", "1"));
        add(new MenuButton("button", "快速排序", "/sortable", "1"));
    }};

    /**
     * 输入框类型的识别规则
     */
    protected static final List<InputType> inputTypeRule = new ArrayList<>(){{
        // 开关组件
        add(new InputType(new String[]{"tinyint", "int", "enum"}, new String[]{"switch", "toggle"}, "switch"));
        add(new InputType(new String[]{"tinyint(1)", "char(1)", "tinyint(1) unsigned"}, new String[]{"switch", "toggle"}, "switch"));

        // 富文本
        add(new InputType(new String[]{"longtext", "text", "mediumtext", "smalltext", "tinytext", "bigtext"}, new String[]{"content", "editor"}, "editor"));

        // textarea
        add(new InputType(new String[]{"varchar"}, new String[]{"textarea", "multiline", "rows"}, "textarea"));

        // Array
        add(new InputType(null, new String[]{"array"}, "array"));

        // 时间选择器
        add(new InputType(new String[]{"int"}, new String[]{"time", "datetime"}, "timestamp"));
        add(new InputType(new String[]{"datetime", "timestamp"}, null, "datetime"));
        add(new InputType(new String[]{"date"}, null, "date"));
        add(new InputType(new String[]{"year"}, null, "year"));
        add(new InputType(new String[]{"time"}, null, "time"));

        // 单选select
        add(new InputType(null, new String[]{"select", "list", "data"}, "select"));

        // 多选select
        add(new InputType(null, new String[]{"selects", "multi", "lists"}, "selects"));

        // 远程select
        add(new InputType(null, new String[]{"_id"}, "remoteSelect"));

        // 远程selects
        add(new InputType(null, new String[]{"_ids"}, "remoteSelects"));

        // 城市选择器
        add(new InputType(null, new String[]{"city"}, "city"));

        // 单图上传
        add(new InputType(null, new String[]{"image", "avatar"}, "image"));

        // 多图上传
        add(new InputType(null, new String[]{"images", "avatars"}, "images"));

        // 文件上传
        add(new InputType(null, new String[]{"file"}, "file"));

        // 多文件上传
        add(new InputType(null, new String[]{"files"}, "files"));

        // icon选择器
        add(new InputType(null, new String[]{"icon"}, "icon"));

        // 单选框
        add(new InputType(new String[]{"tinyint(1)", "char(1)", "tinyint(1) unsigned"}, new String[]{"status", "state", "type"}, "radio"));

        // 数字输入框
        add(new InputType(null, new String[]{"number", "int", "num"}, "number"));
        add(new InputType(new String[]{"bigint", "int", "mediumint", "smallint", "tinyint", "decimal", "double", "float"}, null, "number"));

        // 富文本-低权重
        add(new InputType(new String[]{"longtext", "text", "mediumtext", "smalltext", "tinytext", "bigtext"}, null, "textarea"));

        // 单选框-低权重
        add(new InputType(new String[]{"enum"}, null, "radio"));

        // 多选框
        add(new InputType(new String[]{"set"}, null, "checkbox"));

        // 颜色选择器
        add(new InputType(null, new String[]{"color"}, "color"));
    }};

    /**
     * 预设WEB端文件位置
     */
    protected static final Map<String, Map<String, String[]>> parseWebDirPresets = new HashMap<>(){{
        Map<String, String[]> viewsPresets = new HashMap<>();
        viewsPresets.put("user", new String[]{"user", "user"});
        viewsPresets.put("admin", new String[]{"auth", "admin"});
        viewsPresets.put("admin_group", new String[]{"auth", "group"});
        viewsPresets.put("attachment", new String[]{"routine", "attachment"});
        viewsPresets.put("admin_rule", new String[]{"auth", "rule"});

        put("lang", new HashMap<>()); // empty map for 'lang'
        put("views", viewsPresets);
    }};


    /**
     * 添加时间字段
     */
    protected static String createTimeField = "create_time";

    /**
     * 更新时间字段
     */
    protected static String updateTimeField = "update_time";

    /**
     * 属性的类型对照表
     */
    protected static final Map<String, Map<String, String>> attrType = new HashMap<>(){{
        Map<String, String> controllerTypes = new HashMap<>();
        controllerTypes.put("preExcludeFields", "array|string");
        controllerTypes.put("quickSearchField", "string|array");
        controllerTypes.put("withJoinTable", "array");
        controllerTypes.put("defaultSortField", "string|array");

        put("controller", controllerTypes);
    }};


    /**
     * 获取字段字典数据
     *
     * @param dict              存储字典数据的 Map
     * @param field             字段数据
     * @param lang              语言
     * @param translationPrefix 翻译前缀
     * @return 更新后的字典数据
     */
    public static Map<String, String> getDictData(Map<String, String> dict, Map<String, String> field, String lang, String translationPrefix) {
        if (field == null || !field.containsKey("comment") || field.get("comment") == null || field.get("comment").isEmpty()) {
            return dict;
        }

        String comment = field.get("comment").replace("，", ",").replace("：", ":");
        if (comment.contains(":") && comment.contains(",") && comment.contains("=")) {
            String[] parts = comment.split(":");
            String fieldTitle = parts[0].trim();
            String item = parts[1].trim();
            dict.put(translationPrefix + field.get("name"), lang.equals("en") ? field.get("name") : fieldTitle);

            List<String> itemList = CollUtil.newArrayList(item.split(","));
            for (String v : itemList) {
                String[] valArr = v.split("=");
                if (valArr.length == 2) {
                    String key = valArr[0].trim();
                    String value = valArr[1].trim();
                    dict.put(translationPrefix + field.get("name") + " " + key, lang.equals("en") ? field.get("name") + " " + key : value);
                }
            }
        } else {
            dict.put(translationPrefix + field.get("name"), lang.equals("en") ? field.get("name") : comment);
        }

        return dict;
    }


    /**
     * 记录CRUD状态
     * @param data CRUD记录数据
     * @return 记录ID
     */
    public Long recordCrudStatus(AdminCrud data) {
        if (data.getId() != null) {
            // 如果有ID，使用更新方法
            adminCrudService.update(new LambdaUpdateWrapper<AdminCrud>().eq(AdminCrud::getId,data.getId()).set(AdminCrud::getStatus,data.getStatus()));
            return data.getId();
        } else {
            // 如果没有ID，使用插入方法
            adminCrudService.save(data);
            return data.getId();
        }
    }
}