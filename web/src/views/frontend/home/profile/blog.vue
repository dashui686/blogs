<template>
    <section class="blog-section spad" id="blog">
        <div class="container">
            <div class="section-title">
				<h2>最新博客</h2>
                <el-image />
				<p>学习过程所写的笔记，当然多半是搬运工，便于自己观看，侵必删，陆续整理添加中.......</p>
			</div>
            <el-row>
                <el-col :md="8" v-if="loading" class="blog-item"
                    v-for="item in (blogs as any)"
                >
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
                <el-col :md="8" v-else class="blog-item"
                    v-for="item in (defaultBlogs as any)"
                >                 
                    <el-skeleton
                            animated
                            :throttle="500"
                        >
                            <template #template>
                                <div>
                                    <el-skeleton-item variant="image" style="width: 100%; height: 224px" />
                                    <div class="blog-item-text">
                                        <el-skeleton-item variant="h3"/>
                                        <el-skeleton-item variant="p"/>
                                        <el-skeleton-item variant="p"/>
                                        <el-skeleton-item variant="h3"/>
                                    </div>
                                </div>
                            </template>
                    </el-skeleton>
                </el-col>
            </el-row>
            <div class="text-center mt20">
                    <router-link to="/blogPage" class="site-button" >LOAD MORE.</router-link>
            </div>
        </div>
    </section>
</template>

<script setup lang="ts">
import { Picture as IconPicture } from '@element-plus/icons-vue'

const props = defineProps({
    blogs:{
        type: Array
    }
});

const {blogs} = toRefs(props);
const defaultBlogs = ref([0,1,2])


const loading = computed(()=>{
    console.log(blogs!.value!.length);
    if(blogs!.value != null && blogs!.value != undefined && blogs!.value!.length > 0){return true;}
    
    return false;

});

</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";



.demo-image__error .block {
  padding: 30px 0;
  text-align: center;
  border-right: solid 1px var(--el-border-color);
  display: inline-block;
  width: 49%;
  box-sizing: border-box;
  vertical-align: top;
}
.demo-image__error .demonstration {
  display: block;
  color: var(--el-text-color-secondary);
  font-size: 14px;
  margin-bottom: 20px;
}
.demo-image__error .el-image {
  padding: 0 5px;
  width: 100%;
  max-height: 300px;
  width: 100%;
  height: 300px;
}

.demo-image__error .image-slot {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background: var(--el-fill-color-light);
  color: var(--el-text-color-secondary);
  font-size: 30px;
}
.demo-image__error .image-slot .el-icon {
  font-size: 30px;
}

</style>