import cache from './cache'
import modal from './modal'
import { VueMarkdownEditor, VueMarkdownPreview } from './markDown'
export default function installPlugins(app: any) {
    app.use(VueMarkdownEditor)
    app.use(VueMarkdownPreview)

    // 缓存对象
    app.config.globalProperties.$cache = cache
    // 模态框对象
    app.config.globalProperties.$modal = modal
}
