<template>
    <section class="about-section spad" id="about">
        <div class="container">
            <el-row>
                <Transition appear name="right">
                    <el-col :md="12" :sm="24">
                        <!-- <el-image   src="@/assets/images/psc.jpg" lazy /> -->
                        <img src="@/assets/images/psc.jpg" style="width: 100%;" />
                    </el-col >
                </Transition>
                <Transition appear name="left">
                    <el-col :md="12" :sm="24">

                            <div class="about-text">
                                <h3>关于我。</h3>
                                <p>我是一个对编程充满热爱的JAVA后端开发程序员，这个项目是我再工作之余写出来的一个个人博客项目，主页面是借鉴了设计大佬个人主页面，界面优雅简洁非常适合不会写页面的后端，目前在一家跨境贸易公司上班，下面是我的熟练度。</p>
                            </div>

            
                            <div class="skills"><!-- Skills -->
                                <div class="single-progress-item">
                                    <h4>Java</h4>
                                    <el-progress :text-inside="true" color="#222222" :stroke-width="18" :percentage="70" />
                                </div>
                                <div class="single-progress-item">
                                    <h4>Spring SpringMVC Mybatis</h4>
                                    <el-progress :text-inside="true" color="#222222" :stroke-width="18" :percentage="70" />
                                </div>
                                <div class="single-progress-item">
                                    <h4>SpringBoot</h4>
                                    <el-progress :text-inside="true" color="#222222" :stroke-width="18" :percentage="70" />
                                </div>
                                <div class="single-progress-item">
                                    <h4>SpringCloud</h4>
                                    <el-progress :text-inside="true" color="#222222" :stroke-width="18" :percentage="30" />
                                </div>
                                <div class="single-progress-item">
                                    <h4>Vue</h4>
                                    <el-progress :text-inside="true" color="#222222" :stroke-width="18" :percentage="65" />
                                </div>
                            </div>
                    </el-col>
                </Transition>

            </el-row>
        </div>
    </section>
</template>

<script setup lang="ts" name="About">
 // 在元素被插入到 DOM 之前被调用
    // 用这个来设置元素的 "enter-from" 状态
    const onBeforeEnter=(el:any)=>{

    }
</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";



</style>