<template>
        <section class="intro-section" id="home" >
            <div class="intro-content">
                <Transition appear name="left">
                    <h1 >Li Da Shui Blog.</h1>
                </Transition>
                <Transition appear name="right">
                    <p style="color: white;letter-spacing: 10px;margin: 10px 0;">只要朝着一个方向努力，一切都会变得得心应手</p>
                </Transition>
                <Transition appear name="right">
                    <Link/>
                </Transition>
            </div>
        </section>
</template>

<script setup lang="ts" name="Intro">
import Link from "./link.vue";



</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";


</style>