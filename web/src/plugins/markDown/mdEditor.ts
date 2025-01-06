// v-md start

// 编辑模式
import VueMarkdownEditor from '@kangc/v-md-editor'
import '@kangc/v-md-editor/lib/style/base-editor.css'

export default VueMarkdownEditor

// 方法
// focus
// 使编辑器聚焦。
// insert(getInsertContent: Function)
// 向编辑其中插入文本。例如：
// // selected 为当前选中的文本
// editor.insert((selected) => {
//   const prefix = '**';
//   const suffix = '**';
//   const content = selected || '粗体';
//   return {
//     // 要插入的文本
//     text: `${prefix}${content}${suffix}`,
//     // 插入后要选中的文本
//     selected: content,
//   };
// });

// 事件
// change
// 回调参数：(text, html)
// 内容变化时触发的事件。text 为输入的内容，html 为解析之后的 html 字符串。

// blur
// 回调参数：(event)
// 编辑器失去焦点时触发。

// #save
// 回调参数：(text, html)
// 点击 save toolbar 时触发的事件。

// #image-click
// 回调参数：(images, currentIndex)
// 点击图片时触发的事件。

// #fullscreen-change
// 回调参数：(isFullscreen)
// 切换全屏状态时触发的事件。

// #upload-image
// 回调参数：(event, insertImage)
// toolbar 中使用上传图片之后，用户触发图片上传动作时会触发该事件（例如：选择图片上传，拖拽图片到编辑器中，截图后粘贴到编辑器中）。

// 调用方法将 markdown 转换成 html 并使用 xss 过滤
// // Vue2
// const html = xss.process(VueMarkdownEditor.themeConfig.markdownParser.render('### 标题'));
// // Vue3
// const html = xss.process(VueMarkdownEditor.vMdParser.themeConfig.markdownParser.render('### 标题'));

// 属性
/*
        <v-md-editor
            // 宽度
            height="100%"
            // 制表符空格数
            :tab-size="4"
            // 页面初始化自动获取焦点 true|false
            :autofocus="true"
            // 需要解析预览的 markdown 字符串。只有预览组件支持该属性。
            :text="123213"
            // 双向绑定
            v-model="text"
            // 模式。可选值：edit(纯编辑模式) editable(编辑与预览模式,默认值) preview(纯预览模式)。
            mode="editable"
            // 目录导航是否在右侧。 true|false
            :toc-nav-position-right="true"
            // 是否默认显示目录导航。 true|false
            :default-show-toc="true"
            // 备注
            placeholder
            // 是否默认开启全屏。 true|false
            default-fullscreen
            // 目录导航生成时包含的标题。默认包含 2 级、3 级标题。 [2, 3, 4.....]
            include-level
            // 左侧工具栏 undo redo clear | h bold italic strikethrough quote | ul ol table hr | link image code | save
            left-toolbar
            // 右侧工具栏 preview toc sync-scroll fullscreen
            right-toolbar
            // 自定义工具栏配置，如下 值：Object
            toolbar
            // 内置 toolbar 的一些配置。 Object
            toolbar-config
            // 禁用的菜单。默认值为 image 工具栏下的上传本地图片菜单。示例：h/h1 （禁用标题工具栏下的 h1 标题菜单）。 Object  默认：['image/upload-image']
            disabled-menus
            // 上传本地图片的相关配置 Object 默认 { accept: 'image/*' }  同 img 标签的 accept 属性
            upload-image-config
            // 在预览解析前触发的函数，配置此属性后必须要调用 next 方法并传入需要渲染的 md 文本，否则 preview 组件将不会进行渲染。
            before-preview-change
            //初始化 Codemirror 的配置。将会与内部的默认的配置合并。 可用属性:https://codemirror.net/doc/manual.html#config
            codemirror-config
            是否对 codemirror 编辑器的部分样式进行优化。若关闭，则会恢复 codemirror 编辑器默认的样式。 true | false
            codemirror-style-reset
        >

        </v-md-editor>
*/

// 左侧工具栏
// undo 	    撤销
// redo	        重做
// clear	    清空
// h	        标题
// bold	        粗体
// italic	    斜体
// strikethrough中划线
// quote	    引用
// ul	        无序列表
// ol	        有序列表
// table	    表格
// hr	        分割线
// link	        链接
// image	    插入图片
// code	        代码块
// save	        保存，点击后触发save事件

// 左侧工具栏
// preview	    预览
// toc	        目录导航
// sync-scroll	同步滚动
// fullscreen	全屏

// 自定义
// toolbar: {
//     customToolbar: {
//         icon: 'toolbar图标类名',
//         title: 'hover时显示的标题',
//         action(editor) {
//         // toolbar点击时触发的函数
//              editor.insert(function (selected) { // selected 为当前选中的文本
//              const prefix = '(((';
//              const suffix = ')))';
//              const placeholder = '请输入文本';
//              const content = selected || placeholder;

//              return {
//                  // 要插入的文本
//                  text: `${prefix}${content}${suffix}`,
//                  // 插入后要选中的文本
//                  selected: content,
//              };
//              }
//         },
//     },
// customToolbar2: {
//     title: '工具栏菜单',
//     icon: 'v-md-icon-tip',
//       模式 面板 默认下拉框
//       mode: 'panel',
//       每个宽度
//       itemWidth: '56px',
//       每行最大数量
//       rowNum: 5,
//     menus: [
//       {
//         name: 'menu1',
//         text: '菜单1',
//         action() {
//           console.log('你点击了菜单1');
//         },
//       },
//       {
//         name: 'menu2',
//         text: '菜单2',
//         action() {
//           console.log('你点击了菜单2');
//         },
//       },
//     ],
//   },
// },

//  tool-config
// {
//     'image-link': {
//       // 是否在插入图片链接的时候默认带上width height 属性，默认值：false
//       insertWithSize: false
//     }
// }

/**
 *
 *
 *
 * 流程图用法
    ```mermaid
    graph LR
    A --- B
    B-->C[fa:fa-ban forbidden]
    B-->D(fa:fa-spinner);
    ```

 */
