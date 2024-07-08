<template>
    <section>
        <Nav  class="subpage-nav" />
        <section class="blog-section spad">
            <div class="container">
                <div class="section-title">
                    <h2>LATEST BLOGS</h2>
                    <p>Out believe has request not how comfort evident. Up delight cousins we feeling<br>minutes. Genius has looked end piqued spring.</p>
                </div>
                <el-row>
                    <!-- single-post -->
                    <transition-group name="fade">
                        
                            <el-col :md="8" :key="item.id" v-for="item in blogArray" class="blog-item"  >
                                <div>
                                    <router-link :to="{path:'/blogInfo/'+item.id}"  >
                                    
                                            <el-image :src="'https://lidashui.oss-cn-beijing.aliyuncs.com/blogConver.png'">
                                                    <template #error>
                                                        <div class="image-slot">
                                                            <el-icon><icon-picture /></el-icon>
                                                        </div>
                                                    </template>
                                                </el-image>
                                            <div class="blog-item-text">
                                                <h3>{{item.title}}</h3>
                                                <p>{{ item.description }}</p>
                                                <h5>{{ item.createTime }} / 由{{item.createBy}}发布</h5>
                                            </div>
                                    </router-link>
                                </div>
                            </el-col>
      
                    </transition-group>
                    <!-- single-post -->
<!--                     <el-col :md="8">
                        <a href="single-blog.html" class="blog-item">
                            <img src="@/assets/images/blog1.jpg" alt="">
                            <div class="blog-item-text">
                                <h3>Out believe has request not how</h3>
                                <p>Quick six blind smart out burst. Perfectly on furniture dejection determine my depending an to. Add short water court fat.</p>
                                <h5>7 February 2017 / POSTED BY ADMIN</h5>
                            </div>
                        </a>
                    </el-col> -->
                </el-row>
                <div class="text-center mt20">
                    <el-button class="site-button" @click="getLIst()">LOAD MORE.</el-button>
                </div>
            </div>
        </section>
        <Footer/>
    </section>
</template>

<script setup lang="ts">
import Footer from '../common/footer.vue';
import Nav from '../common/nav.vue';
import {blogs} from "@/api/frontend/homePage"
import { reject } from 'lodash';
import { setTimeOutAsync } from '@/utils/Thread';
import { ElNotification } from 'element-plus';

onBeforeMount(()=>{
    getLIst();
})

const data = reactive({
    queryForm:{
        pageNum:1,
        pageSize:9,
    },
    blogArray:<any[]>[],
    blogCount:<any>undefined
})

const {blogCount,queryForm,blogArray} = toRefs(data);

const getLIst=()=>{

    if(blogCount.value != undefined && ( blogArray.value.length < 0 || blogArray.value.length >= blogCount.value )){
        ElNotification({
            message: "已经到底了",
            type: 'info',
        })
        return
    }

    console.log(queryForm.value)
    blogs(queryForm.value).then(res=>{
        blogArray.value.push(...res.rows)
        blogCount.value = res.total
        queryForm.value.pageNum += 1;
    })
}

</script>
 
<style scoped lang="scss">
@import "@/styles/homePage.scss";

.subpage-nav{
    position: fixed !important;
}

.fade-enter-active,
.fade-leave-active {
    transition: all .8s ease;
}

.fade-enter-from,
.fade-leave-to {
    transform: translateY(200px);
    opacity: 0;
}


</style>