<template>
    <div class="default-main">
  
      <el-row class="table-header">
        <el-col>
          <el-button type="primary" @click="openDialogForm(undefined!)">添加</el-button>
        </el-col>
      </el-row>
      <el-table
        v-loading="tableLoading"
        :data="tableData"
        style="width: 100%"
      >
        <el-table-column prop="name" label="角色名称"  />
        <el-table-column prop="remark" label="描述" show-overflow-tooltip  />
        <el-table-column label="操作"  width="170" >
          <template #default="scope">
            <el-button type="success" @click="openDialogForm(scope.row.id)">修改</el-button>
            <el-popconfirm title="Are you sure to delete this?"  @confirm="remove(scope.row.id)">
              <template #reference>
                <el-button type="danger">删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
  
  
      <el-dialog
      class="ba-operate-dialog" 
      v-model="dialogFormVisible" 
      draggable
      >
      <template #header>
              <div class="title">
                  {{ form.id?'更新类型':'添加类型' }}
              </div>
          </template>
        <el-scrollbar v-loading="formLoading" class="ba-table-form-scrollbar">
          <div
                  class="ba-operate-form"
                  :style="'width: calc(100% - ' + formLabelWidth! / 2 + 'px)'"
              >
              <el-form :model="form" :rules="rules" ref="ruleFormRef">
                <el-form-item label="类型名称" prop="name" :label-width="formLabelWidth">
                  <el-input v-model="form.name" autocomplete="off" placeholder="请输入分类名" />
                </el-form-item>
                <el-form-item label="排序" prop="sort" :label-width="formLabelWidth">
                  <el-input v-model="form.sort" type="number" autocomplete="off" placeholder="请输入菜单标题" />
                </el-form-item>
                <el-form-item label="备注" prop="remark" :label-width="formLabelWidth">
                  <el-input type="textarea" v-model="form.remark" autocomplete="off" placeholder="描述备注" />
                </el-form-item>
              </el-form>
  
          </div>
  
        </el-scrollbar>
        <template #footer>
              <div :style="'width: calc(100% - ' + formLabelWidth! / 1.8 + 'px)'">
                  <el-button @click="closeDialogForm">关闭</el-button>
                  <el-button :loading="submitLoading" @click="submitForm(ruleFormRef)" type="primary">
                      {{ form.id?'更新类型':'添加类型'  }}
                  </el-button>
              </div>
          </template>
      </el-dialog>
    </div>
  </template>
  
  <script lang="ts" setup name="BlogTag">
  import { getById,getTagList,insertTag,updateTag,deleteTag } from '@/api/backend/blog/tag';
  import {FormInstance,ElNotification,ElForm,FormRules} from "element-plus"
  import {onResetForm} from "@/utils/common";
  
  const tableData = ref([]);
  const total =ref();
  
  const formLabelWidth = 150;
  const submitLoading = ref(false)
  const srcList = ref<any>([]);
  const formLoading = ref(false);
  const tableLoading =ref(false);
  const dialogFormVisible = ref(false);
  const ruleFormRef = ref<InstanceType<typeof ElForm>>()
  
  const form = ref({
    id:undefined,
    name:"",
    remark:"",
    sort:undefined,
  });
  
  // 表单验证规则
  const rules = reactive<FormRules>({
      name: [
          { required: true, message: '请输入名称', trigger: 'blur' },
      ],
      sort: [
          {
          required: true,
          message: '请输入排序',
          trigger: 'blur',
          },
      ],
  })
  
  const getList=()=>{
    tableLoading.value = true;
    getTagList().then(e=>{
        tableData.value = e.rows;
        srcList.value = tableData.value.map((e:any)=>{
          return e.avatar;
        })
        total.value = e.total;
        tableLoading.value = false;
    })
  }
  
  
  const remove=(rowId:any )=>{
    tableLoading.value = true;
    deleteTag(rowId).then(e=>{
      ElNotification({
            message: e.msg,
            type: 'success',
        })
        getList();
      }).finally(()=>{
        tableLoading.value = false;
      })
  }
  
  const openDialogForm=(rowId:number)=>{
    dialogFormVisible.value = true;
    resetForm();

    if(rowId){
      getById(rowId).then(e=>{
        form.value = e.data;
      })
    }
  }
  
  const closeDialogForm=()=>{
    dialogFormVisible.value = false;
    resetForm();
  }
  
  
  const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
      if (valid) {
  
        formLoading.value = true;
        submitLoading.value = true;
  
        (!form.value.id?insertTag(form.value):updateTag(form.value))
        .then(e=>{
            ElNotification({
                message: e.msg,
                type: 'success',
            })
            getList();
          }).finally(()=>{
            formLoading.value = false;
            submitLoading.value = false;
            closeDialogForm();
          })
      } else {
        console.log('error submit!', fields)
      }
    })
  }
  
  const resetForm=()=>{
    form.value.id=undefined;
    onResetForm(ruleFormRef.value);
  }
  
  
  
  
  getList();
  </script>
  
  
  <style scoped lang="scss">
  
  </style>