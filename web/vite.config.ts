import vue from '@vitejs/plugin-vue'
// 配置@别名
import { resolve } from 'path'
import { loadEnv } from 'vite'
import type { UserConfig, ConfigEnv, ProxyOptions } from 'vite'
import { isProd, customHotUpdate } from '/@/utils/vite'
import { svgBuilder } from '/@/components/icon/svg/index'
import eslintPlugin from 'vite-plugin-eslint'
// 自动导入vue中hook reactive ref等
import AutoImport from 'unplugin-auto-import/vite'
// 自动导入ui-组件 比如说ant-design-vue  element-plus等
import Components from 'unplugin-vue-components/vite'
// element
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
const pathResolve = (dir: string): any => {
    return resolve(__dirname, '.', dir)
}

// https://vitejs.cn/config/
const viteConfig = ({ mode }: ConfigEnv): UserConfig => {
    const { VITE_PORT, VITE_OPEN, VITE_BASE_PATH, VITE_OUT_DIR, VITE_PROXY_URL, VITE_BASE_API } = loadEnv(mode, process.cwd())

    const alias: Record<string, string> = {
        '/@': pathResolve('./src'),
        assets: pathResolve('./src/assets'),
        'vue-i18n': isProd(mode) ? 'vue-i18n/dist/vue-i18n.cjs.prod.js' : 'vue-i18n/dist/vue-i18n.cjs.js',
    }

    let proxy: Record<string, string | ProxyOptions> = {}
    if (VITE_PROXY_URL) {
        proxy = {
            VITE_BASE_API: {
                // 匹配请求路径，
                target: VITE_PROXY_URL, // 代理的目标地址
                // 开发模式，默认的127.0.0.1,开启后代理服务会把origin修改为目标地址
                changeOrigin: true,
                // secure: true, // 是否https接口
                // ws: true, // 是否代理websockets

                // 路径重写，**** 如果你的后端有统一前缀(如:/api)，就不开启；没有就开启
                // 简单来说，就是是否改路径 加某些东西
                rewrite: (path) => path.replace(`/^\/` + VITE_BASE_API + `/`, ''),
            },
        }
    }

    return {
        plugins: [
            vue(),
            eslintPlugin({
                // 配置
                cache: false, // 禁用 eslint 缓存
            }),
            svgBuilder('./src/assets/icons/'),
            AutoImport({
                // 安装两行后你会发现在组件中不用再导入ref，reactive等
                imports: ['vue', 'vue-router'],
                // 存放的位置
                dts: 'src/auto-import.d.ts',
                // Generate corresponding .eslintrc-auto-import.json file.
                // eslint globals Docs - https://eslint.org/docs/user-guide/configuring/language-options#specifying-globals
                eslintrc: {
                    enabled: false, // Default `false`
                    filepath: './.eslintrc-auto-import.json', // Default `./.eslintrc-auto-import.json`
                    globalsPropValue: true, // Default `true`, (true | false | 'readonly' | 'readable' | 'writable' | 'writeable')
                },
                // element
                resolvers: [ElementPlusResolver()],
            }),
            Components({
                // 引入组件的,包括自定义组件
                // 存放的位置
                dts: 'src/components.d.ts',
                resolvers: [ElementPlusResolver()],
            }),
            customHotUpdate(),
        ],
        root: process.cwd(),
        resolve: { alias },
        base: VITE_BASE_PATH,
        server: {
            port: parseInt(VITE_PORT),
            open: VITE_OPEN != 'false',
            proxy: proxy,
        },
        build: {
            cssCodeSplit: false,
            sourcemap: false,
            outDir: VITE_OUT_DIR,
            emptyOutDir: true,
            chunkSizeWarningLimit: 1500,
            rollupOptions: {
                output: {
                    manualChunks: {
                        // 分包配置，配置完成自动按需加载
                        vue: ['vue', 'vue-router', 'pinia', 'vue-i18n', 'element-plus'],
                        echarts: ['echarts'],
                    },
                },
            },
        },
    }
}

export default viteConfig
