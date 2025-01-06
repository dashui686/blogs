<template>
  <footer>
    <div class="container">
      <Link />
      <p>©2023 lidashui All rights reserved Create by lidashui</p>
      <p>
        <a href="http://www.beian.gov.cn/portal/registerSystemInfo?spm=5176.27804673.J_9220772140.51.11997365DTLMia" target="_blank">
          <img
            data-src="//img.alicdn.com/tfs/TB1..50QpXXXXX7XpXXXXXXXXXX-40-40.png"
            class="ali-report-img"
            src="https://img.alicdn.com/tfs/TB1..50QpXXXXX7XpXXXXXXXXXX-40-40.png"
            data-spm-anchor-id="5176.27804673.J_9220772140.i1.11997365DTLMia"
          />
        </a>
        <a href="https://beian.miit.gov.cn/" target="_blank">豫ICP备2022028012号-1</a>
      </p>
    </div>
  </footer>
</template>

<script setup lang="ts">
import Link from '../home/profile/link.vue'
</script>

<style scoped lang="scss">
@import "/@/styles/homePage.scss";

.ali-report-img {
    width: 20px;
    display: inline-block;
    height: 20px;
    margin-right: 12px;
    vertical-align: top;
}
</style>
