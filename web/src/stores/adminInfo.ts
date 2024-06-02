import { defineStore } from 'pinia'
import { ADMIN_INFO } from '/@/stores/constant/cacheKey'
import type { AdminInfo } from '/@/stores/interface'

export const useAdminInfo = defineStore('adminInfo', {
    state: (): AdminInfo => {
        return {
            id: 0,
            username: '',
            nickname: '',
            avatar: '',
            lastLoginTime: '',
            token: '',
            refreshToken: '',
            // 是否是superAdmin，用于判定是否显示终端按钮等，不做任何权限判断
            super: false,
        }
    },
    actions: {
        dataFill(state: AdminInfo) {
            this.$state = { ...this.$state, ...state }
        },
        removeToken() {
            this.token = ''
            this.refreshToken = ''
        },
        setToken(token: string, type: 'auth' | 'refresh') {
            const field = type == 'auth' ? 'token' : 'refreshToken'
            this[field] = token
        },
        getToken(type: 'auth' | 'refresh' = 'auth') {
            return type === 'auth' ? this.token : this.refreshToken
        },
        setSuper(val: boolean) {
            this.super = val
        },
    },
    persist: {
        key: ADMIN_INFO,
    },
})
