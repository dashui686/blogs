<template>
    <div class="comment">
        <h3>留言</h3>
        <ul v-if="comments!.length > 0" class="comment-list">
            <li v-for="item in (comments as any)" class="reply-has">
                <img src="@/assets/images/comment-1.jpg" alt="">
                <div class="comment-info">
                    <h4>{{ item.operator }}</h4>
                    <p>{{ item.message }}</p>
                    <el-link  class="reply"  :underline="false">Reply</el-link>
                </div>
                <ul v-if="item.children" class="reply-comment-list" >
                    <li v-for="reitem in item.children">
                        <img src="@/assets/images/comment-1.jpg" alt="">
                        <div class="comment-info">
                            <h4>{{ reitem.operator }}</h4>
                            <p>{{ reitem.message }}</p>
                            <el-link  class="reply"  :underline="false">Reply</el-link>
                        </div>
                    </li>
                </ul>
            </li>
        </ul>
        <div v-else>无</div>
        <!-- Comment Form -->
        <form :md="12" class="comment-form send-message">
            <h3 class="subtitle">Leave a Reply</h3>
            <el-form>
                <el-row>
                    <!--Name-->
                    <el-col :md="12">
                        <input type="text" placeholder="Name">
                    </el-col>
                    <!--Email-->
                    <el-col :md="12">
                        <input type="text" placeholder="Email">
                    </el-col>
                    <!--Message-->
                    <el-col :md="24">
                        <textarea name="con_message" placeholder="Message" rows="8"></textarea>
                    </el-col>
                </el-row>
            </el-form>
            
                <button class="site-button" type="submit">SEND A MESSAGE</button>
        </form>
    </div>
</template>

<script setup lang="ts" name="BlogInfoComment">
const props = defineProps({
    comments:{
        type: Array
    }
});
const {comments} = toRefs(props);
</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";
</style>