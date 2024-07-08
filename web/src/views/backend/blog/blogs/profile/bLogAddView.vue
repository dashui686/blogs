<template>
    <div>
        <el-drawer
            v-model="blogconfig.config!.showAdd"
            class="blog-drawer"
            direction="rtl"
            :append-to-body="true"
            :close-on-press-escape="false"  
            :close-on-click-modal="false"
            :destroy-on-close="true"
            size="100%"
            :show-close="false"
            :with-header="false"
            :before-close="handleClose"
        >
            <el-row>
                <el-col :span="24">
                    <el-row class="blog-header">
                        <el-col :span="2" :xs="24" class="blog-back" >
                        <el-link  :underline="false" style="display: block;" :icon="Back" @click="closeView" >放弃发表</el-link>
                        </el-col>
                        <el-col :span="14" :xs="24" class="blog-title">
                            <el-input class="blog-input" v-model="blogconfig.formValue.title" >
                            <template #prepend>标题</template>
                            </el-input>
                        </el-col>
                        <el-col :span="2" :xs="24" class="blog-button-content">
                            <el-button class="blog-button" type="danger">
                                保存草稿
                            </el-button>
                        </el-col>
                        <el-col :span="2" :xs="24"  class="blog-button-content" >
                            <el-button class="blog-button" type="success" @click="openSubmit">
                                立即发表
                            </el-button>
                        </el-col>
                        
                        <el-col :span="2" >
                            <el-button class="blog-button" type="warning">
                                定时发表
                            </el-button>
                        </el-col>
                    </el-row>
                </el-col>
                <el-col :span="24">
                    <v-md-editor 
                        v-model="blogconfig.formValue.content"
                        height="93vh"
                        :tab-size="4"
                        :autofocus="true"
                        left-toolbar="undo redo clear | h bold italic strikethrough quote | ul ol table hr | link image code | save | emoji"
                    ></v-md-editor>
                </el-col>
            </el-row>
        </el-drawer>

        <el-dialog 
        v-model="blogconfig.config!.dialogFormVisible" 
        width="50%"
        draggable
        title="发表信息">
            <el-form >
                <el-form-item label="封面" label-width="10%" >
                    <el-input v-model="blogconfig.formValue.cover" autocomplete="off" />
                </el-form-item>
                <el-form-item label="描述" label-width="10%" >
                    <el-input v-model="blogconfig.formValue.description" type="textarea" autocomplete="off" />
                </el-form-item>
                <el-form-item label="状态" label-width="10%" >
                    <el-switch
                        v-model="blogconfig.formValue.disable"
                        :active-value="1"
                        :inactive-value="0"
                    />
                </el-form-item>
                <el-form-item label="置顶" label-width="10%" >
                    <el-switch
                        v-model="blogconfig.formValue.top"
                        :active-value="1"
                        :inactive-value="0"
                    />
                </el-form-item>
                <el-form-item label="分类" label-width="10%" >
                    <el-input v-model="type" autocomplete="off" />
                </el-form-item>
                <el-form-item label="标签" label-width="10%" >
                    <el-input v-model="tag" autocomplete="off" />
                </el-form-item>
                <el-form-item label="排序" label-width="10%" >
                    <el-input v-model="blogconfig.formValue.sort" type="number" autocomplete="off" />
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                <el-button @click="blogconfig.resetFormValue">Cancel</el-button>
                <el-button type="primary" @click="submitForm">
                    Confirm
                </el-button>
                </span>
            </template>
            </el-dialog>
    </div>
</template>

<script setup lang="ts" name="BLogAdd">
import { Back } from '@element-plus/icons-vue'
import { blogConfig } from '@/stores/blog';
import { insertBlog } from '@/api/backend/blog/blogs';
import { ElNotification,ElMessageBox  } from 'element-plus';

const blogconfig = blogConfig();

const type = ref("");
const tag = ref("");

const closeView=()=>{
    blogconfig.changeShowAdd();
}



const submitForm = ()=>{

    insertBlog(blogconfig.formValue).then(res=>{
        ElNotification({
            message: res.msg,
            type: 'success',
        })

        ElMessageBox.confirm('是否清空所有填写数据')
        .then(() => {
            blogconfig.resetFormValue();
        })
    })
}

const openSubmit=()=>{
    if(blogconfig.formValue.title == '' ||  blogconfig.formValue.title.length <= 5){
        ElNotification({
            message: "请输入标题并且标题必须大于五个字符",
            type: 'info',
        })
        return ;
    }
    blogconfig.changeDialogForm();
}

const handleClose = (done: () => void) => {
  ElMessageBox.confirm('Are you sure you want to close this?')
    .then(() => {
      done()
    })
    .catch(() => {
      // catch error
    })
}
</script>

<style scoped>


@media only screen and ((max-width: 768px) or (max-width: 414px)){
    .blog-button-content,.blog-title {
        padding: 0 30px;
        margin: 10px 0
    }

    .blog-back{
        margin: 0 10px;
    }
}


@media only screen and(max-width: 414px){
    .blog-button-content,.blog-title {
        margin: 0 10px
    }
}

.blog-button-content,.blog-title {
    margin: 0 10px
}
.blog-back{
    text-align: center;
    line-height: 40px;
    width: 100%;
}

</style>