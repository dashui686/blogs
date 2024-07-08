<template>
    <section class="contact-section spad" id="contact">
        <div class="container">
            <div class="section-title">
                <h2>保持联系</h2>
                <p>留个联系方式，可以互相帮助代码人代码魂！留个好友位，方便内推讨论</p>
            </div>
            <el-row>
                <el-col :md="10">
                    <ul class="con-info">
                        <li>
                            <i class="iconfont icon-dianhua"></i> 
                            <span>QQ/微信</span>
                            <p>1327674904</p>
                        </li>
                        <li>
                            <i class="iconfont icon-youjian"></i> 
                            <span>电子邮件</span>
                            <p>li1327674904@163.com</p>
                        </li>
                        <li>
                            <i class="iconfont icon-daohangdizhi"></i> 
                            <span>地址</span>
                            <p>武汉</p>
                            <p>郑州</p>
                        </li>
                    </ul>
                </el-col>
                <el-col :md="14" class="contact-left">
                    <div id="form-chack"></div>
                    <!-- Contact Form -->
                    <form  id="contact-form" autocomplete="off" @submit.prevent="submit" >
                        <input type="text" name="name"  id="name"  placeholder="你的名字*">
                        <input type="email" name="email"  id="email"  placeholder="你的邮件*">
                        <div class="send-btn-div">
                            <textarea id="massage" name="massage"   placeholder="您的按摩*"></textarea>
                            <button  class="send-btn" type="submit" ><i class="iconfont icon-zhifeiji"></i> </button>
                        </div>
                    </form>
                </el-col>
            </el-row>
        </div>
    </section>
</template>

<script setup lang="ts">
import { ta } from 'element-plus/es/locale';
import {concat} from "@/api/frontend/homePage/index"
import { getCurrentInstance } from 'vue';
import { ElLoading,ElNotification } from 'element-plus';

const submit = (target:Event)=>{
    const name = document.getElementById("name") as any;
    const email = document.getElementById("email") as any;
    const message = document.getElementById("massage") as any;
    if(name.value == ""){
        name.focus();
        return;
    }
    if(email.value == ""){
        email.focus();
        return;
    }
    if(message.value == ""){
        message.focus();
        return;
    }

    const fromData = new FormData();
    fromData.append("name",name.value)
    fromData.append("email",email.value)
    fromData.append("message",message.value)
    
    ElNotification({
        type: 'success',
        message: "提交成功",
    })
    // const loadingInstance1 = ElLoading.service({ fullscreen: true,text:"发送中....",body:true,lock:true })
    concat(fromData).then(res=>{
        name.value = "";
        email.value = "";
        message.value = "";
        ElNotification({
            type: 'success',
            message: "发送成功",
        })
    }).finally(()=>{
        // loadingInstance1.close();
    })

    return false;
}
</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";

</style>