<template>
    <section>
        <Nav  class="subpage-nav" />
            <section class="single-section spad">
                <div class="container">
                    
                    <el-backtop :right="50" :bottom="100" />
                    <div class="el-backtop catalogue" style="right: 50px;bottom:150px" @click="open" >
                    目录
                    </div>
                    <el-row :offset="2" class="single-blogpost">
                        <el-col :md="14" :sm="12" class="no-pad by-admin">
                            <h5> <el-icon><UserFilled /></el-icon>由 {{ data.blog.createBy }} 发布 |  <el-icon><Timer /></el-icon> {{ data.blog.createTime }} | <el-icon><Comment /></el-icon> {{ data.comments?data.comments.length:0 }} 评论</h5>
                        </el-col>
                        <el-col :md="10" :sm="12" class=" no-pad single-social">
                            <a href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"><i class="iconfont icon-chakan"></i> {{ data.blog.browse }}</a>
                            <a href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"><i class="iconfont icon-dianzan"></i> {{ data.blog.praise }}</a>
                            <!-- <a href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"><i class="fa fa-tumblr"></i> 195</a>
                            <a href="https://www.jq22.com/demo/jquerydyweb201908160049/single-blog.html#"><i class="fa fa-twitter"></i> 65</a> -->
                        </el-col>
                        <div class="post-img">
                            <el-image style="width: 100%;height: 500px;" :src="data.blog.cover" fit="cover" />
                        </div>	
                        <!-- <h2 class="title-heading">{{ data.blog.title }}</h2> -->
                        
    
                        <BlogInfoPreview ref="blogInfoPreview" v-if="data.content" v-model:titles='titles' :text="data.content"/>
                            
                        <!-- <v-md-preview-html :html="data.content" preview-class="vuepress-markdown-body"></v-md-preview-html> -->
                        <!-- Post Comments -->
                        <BlogInfoComment   :comments="data.comments"/>
                    </el-row>		
                </div>
            </section>
        <Footer />


        <el-drawer 
        v-model="drawer.isOpen" 
        :append-to-body="true"
        :lock-scroll="true"
        direction="rtl">
            <template #header>
            <h4>目录</h4>
            </template>
            <template #default>
            <div>
                <div
                v-for="anchor in titles"
                @click="handleAnchorClick(anchor)"
                :style="{ padding: `10px 0 10px ${anchor.indent * 20}px` }"
                >
                    <a style="cursor: pointer" >{{ anchor.title }}</a>
                </div>
            </div>
            </template>
            <template #footer>
            <div style="flex: auto">
                
            </div>
            </template>
        </el-drawer>
    </section>
</template>

<script setup lang="ts">
import Footer from '../common/footer.vue';
import Nav from '../common/nav.vue';
import { useRoute } from 'vue-router';
import { blog } from '@/api/frontend/homePage';
import { UserFilled,Comment,Timer } from '@element-plus/icons-vue';
import {ComponentInternalInstance} from "vue"
import { setTitle } from '@/utils/common';
import BlogInfoPreview from "./profile/preview.vue"
import BlogInfoComment from "./profile/comment.vue"
const drawer = reactive({
    isOpen:false
})
const {proxy} = getCurrentInstance() as ComponentInternalInstance;
const route = useRoute();
const data =ref<any>({
    blog:{
        browse: 0,
        cover: "",
        createBy: "",
        createTime: "",
        description: "",
        disable: 1,
        id: 0,
        praise: 0,
        sort: 0,
        title: "",
        top: 0
    },
    comments:[],
    content:undefined,
});

const titles = ref<any>([]);
onBeforeMount(()=>{
    blog(route.params.id).then(res=>{
        data.value = res.data;
        setTitle(res.data.blog.title)
    })
})

const open=()=>{
    drawer.isOpen = true
    return false;
}

const handleAnchorClick=(anchor:any)=> {
    const preview = proxy?.$refs.blogInfoPreview as any; 
    preview.handleAnchorClick(anchor)
}
</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";
.el-backtop{
    right: 100px;
    z-index: 100 !important;
    background-color: rgb(255, 255, 255);
}
.catalogue{
    position: fixed !important;
    bottom: 500 !important;
}
.subpage-nav{
    position: fixed !important;
}
</style>