import type { RouteRecordRaw } from 'vue-router'

/**
 * 后台基础路由路径
 */
export const blogsBaseRoutePath = '/blogs'

/*
 * 后台基础静态路由
 */
const adminBaseRoute: RouteRecordRaw = {
    path: blogsBaseRoutePath,
    name: 'blogs',
    component: () => import('/@/layouts/backend/index.vue'),
    // 直接重定向到 loading 路由
    redirect: blogsBaseRoutePath + '/loading',
    meta: {
        title: `pagesTitle.admin`,
    },
    children: [
        {
            path: '/blogPage',
            name: 'blogPage',
            //使用import可以路由懒加载，如果不使用，太多组件一起加载会造成白屏
            component: () => import('/@/views/frontend/blog/blogPage.vue'),
            meta: {
                title: `pagesTitle.loading`,
            },
        },
        {
            path: '/blogInfo/:id(\\d+)',
            name: 'blogInfo',
            sensitive: true ,
            //使用import可以路由懒加载，如果不使用，太多组件一起加载会造成白屏
            component: () => import('/@/views/frontend/blog/blogInfo.vue'),
            meta: {
                title: `pagesTitle.loading`,
            },
        },
        {
            path: 'loading/:to?',
            name: 'adminMainLoading',
            component: () => import('/@/layouts/common/components/loading.vue'),
            meta: {
                title: `pagesTitle.loading`,
            },
        },
    ],
}

export default adminBaseRoute
