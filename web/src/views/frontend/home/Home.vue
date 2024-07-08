<template>
    <div>
        <Nav />
        <Intro/>
        <About id="about"/>
        <Hobby id="hobby"/>
        <!-- <Protfolio/> -->
        <!-- <Hobby/> -->
        <Blog :blogs="data.blogs" id="blog"/>
        <Contact id="contact"/>
        <Footer />
    </div>
</template>

<script setup lang="ts" name="Home">
import Intro from './profile/intro.vue';
import Hobby from './profile/hobby.vue';
import About from './profile/about.vue';
import Protfolio from './profile/portfolio.vue';
import Blog from './profile/blog.vue';
import Contact from './profile/contact.vue';
import Footer from '../common//footer.vue';
import { index } from '@/api/frontend/homePage';
import Nav from '../common/nav.vue';
import { useRouter, useRoute } from 'vue-router'

const data = reactive({
    blogs:[],
})
const a = computed(()=>{
    const dataArray = <any>[]

    for(let i = 0 ;i<=1000;i++){
        dataArray.push({
            id:i
        })
    }

    return dataArray;
})


index().then(res=>{
    data.blogs = res.data.blogs;
})


</script>

<style lang="scss" scoped>
</style>