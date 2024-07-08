import createAxios from '@/utils/axios'
import { useUserInfo } from '@/stores/userInfo'
import { AnyARecord } from 'dns'
import { create } from 'domain'

const controllerUrl = '/'

export function index() :ApiPromise {
    return createAxios({
        url: controllerUrl + 'index',
        method: 'get',
    }) as ApiPromise
}


export function blogs(data:anyObj) :TablePromise {
    return createAxios({
        url: controllerUrl + 'index/blogs',
        method: 'get',
        params:data
    }) as TablePromise
}


export function blog(blogId:any) :ApiPromise {
    return createAxios({
        url: controllerUrl + 'index/blog/'+blogId,
        method: 'get',
    }) as ApiPromise
}


export function concat(data:any):ApiPromise{
    return createAxios({
        url: controllerUrl + 'index/concat',
        method: 'post',
        data,
        timeout:30000
    }) as ApiPromise
}