<template>
    <nav>
        <el-row>
            <el-col :span="24" class="container">
                <div class="logo"><img src="/@/assets/images/logo.png" alt="" /><!-- Logo --></div>
                <div class="mobile-bar"><span></span></div>
                <ul class="nav-menu">
                    <li><a href="/">Home</a></li>
                    <li><a href="/#about">About</a></li>
                    <li><a href="/#hobby">Hobby</a></li>
                    <li><a href="/#blog">Blog</a></li>
                    <li><a href="/#contact">Contact</a></li>
                </ul>
            </el-col>
        </el-row>
    </nav>
</template>

<script setup lang="ts"></script>

<style scoped lang="scss">
@import '/@/styles/homePage.scss';
</style>
