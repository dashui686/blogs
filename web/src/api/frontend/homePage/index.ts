import createAxios from '/@/utils/axios'

const controllerUrl = '/'

export function index(): ApiPromise {
    return createAxios({
        url: controllerUrl + 'index',
        method: 'get',
    }) as ApiPromise
}

export function blogs(data: anyObj): ApiTableDataPromise {
    return createAxios({
        url: controllerUrl + 'index/blogs',
        method: 'get',
        params: data,
    })
}

export function blog(blogId: any): ApiPromise {
    return createAxios({
        url: controllerUrl + 'index/blog/' + blogId,
        method: 'get',
    }) as ApiPromise
}

export function concat(data: any): ApiPromise {
    return createAxios({
        url: controllerUrl + 'index/concat',
        method: 'post',
        data,
        timeout: 30000,
    }) as ApiPromise
}
