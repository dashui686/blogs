import VueMarkdownEditor from './mdEditor'
import VueMarkdownPreview from './mdPreview'
import Prism from 'prismjs'

// vuepress 主题
import vuepressTheme from '@kangc/v-md-editor/lib/theme/vuepress.js'
import '@kangc/v-md-editor/lib/theme/style/vuepress.css'

// 行号高亮 ``` java{1,3} 标识 1、3行 高亮
import createHighlightLinesPlugin from '@kangc/v-md-editor/lib/plugins/highlight-lines/index'
import '@kangc/v-md-editor/lib/plugins/highlight-lines/highlight-lines.css'
// 快速复制
import createCopyCodePlugin from '@kangc/v-md-editor/lib/plugins/copy-code/index'
import '@kangc/v-md-editor/lib/plugins/copy-code/copy-code.css'
// 任务列表 - [x] Task    x标识对号
import createTodoListPlugin from '@kangc/v-md-editor/lib/plugins/todo-list/index'
import '@kangc/v-md-editor/lib/plugins/todo-list/todo-list.css'
// 流程图
// import createMermaidPlugin from '@kangc/v-md-editor/lib/plugins/mermaid/cdn';
// import '@kangc/v-md-editor/lib/plugins/mermaid/mermaid.css';
// cdn 引入 mermaid 资源
// loadJs("https://unpkg.com/mermaid/dist/mermaid.min.js");

// 行号
import createLineNumbertPlugin from '@kangc/v-md-editor/lib/plugins/line-number/index'
// emoji 表情
import createEmojiPlugin from '@kangc/v-md-editor/lib/plugins/emoji/index'
// 内容定位
// import createAlignPlugin from '@kangc/v-md-editor/lib/plugins/align';

// 国际化
// import enUS from '@kangc/v-md-editor/lib/lang/en-US';
// VueMarkdownEditor.lang.use('en-US', enUS);
// 修改默认文案
// 简体中文	zh-CN
// 繁體中文（台）	zh-TW
// 英语	en-US
// 德语	de-DE
// 韩文	ko-KR
// 西班牙语	es-ES
// 波兰语	pl-PL
// 法语	fr-FR
// 俄罗斯语	ru-RU
// VueMarkdownEditor.lang.add({
//     'zh-CN': {
//       h1: {
//         toolbar: '标题1',
//       },
//     },
//   });

VueMarkdownEditor.use(vuepressTheme, {
  Prism,
  // codeHighlightExtensionMap：key 为要扩展的名称，value 为代码高亮支持的语言。
  // codeHighlightExtensionMap: {
  //     vue: 'html',
  //   },
  // extend(md:any) {
  // md为 markdown-it 实例，可以在此处进行修改配置,并使用 plugin 进行语法扩展
  // md.set(option).use(plugin);
  // },
})

VueMarkdownPreview.use(vuepressTheme, {
  Prism,
  // codeHighlightExtensionMap：key 为要扩展的名称，value 为代码高亮支持的语言。
  // codeHighlightExtensionMap: {
  //     vue: 'html',
  //   },
  // extend(md:any) {
  // md为 markdown-it 实例，可以在此处进行修改配置,并使用 plugin 进行语法扩展
  // md.set(option).use(plugin);
  // },
})

VueMarkdownEditor.use(createEmojiPlugin())
VueMarkdownEditor.use(createLineNumbertPlugin())
VueMarkdownEditor.use(createHighlightLinesPlugin())
VueMarkdownEditor.use(createCopyCodePlugin())
// VueMarkdownEditor.use(createAlignPlugin());
VueMarkdownEditor.use(createTodoListPlugin())
// VueMarkdownEditor.use(createMermaidPlugin());

VueMarkdownPreview.use(createEmojiPlugin())
VueMarkdownPreview.use(createLineNumbertPlugin())
VueMarkdownPreview.use(createHighlightLinesPlugin())
VueMarkdownPreview.use(createCopyCodePlugin())
VueMarkdownPreview.use(createTodoListPlugin())

/**
 * 可以省略掉 preview
 */
export { VueMarkdownPreview, VueMarkdownEditor }
