<template>
    <div class="default-main">
      <el-row class="table-header">
        <el-col>
          <el-button type="primary" @click="openDialogForm(undefined!)">写文章</el-button>
        </el-col>
      </el-row>
      <el-table
        v-loading="tableLoading"
        :data="tableData"
        style="width: 100%"
      >
        <el-table-column prop="title" label="标题"  width="250"  show-overflow-tooltip />
        <el-table-column prop="description" label="概要" show-overflow-tooltip  />
        <el-table-column prop="top" label="置顶" width="65" align="center"  >
          <template #default="scope">
            <el-switch
              v-model="scope.row.top"
              :active-value="1"
              :inactive-value="0"
            />
          </template>
        </el-table-column>
        <el-table-column prop="disable" label="状态" width="65" align="center"  >
          <template #default="scope">
            <el-switch
              v-model="scope.row.disable"
              :active-value="1"
              :inactive-value="0"
            />
          </template>
        </el-table-column>
        <el-table-column prop="browse" label="浏览量" width="70" align="center"  />
        <el-table-column prop="praise" label="点赞量"  width="70" align="center"   />
        <el-table-column prop="createDate" label="创建时间"  width="170"  />
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


    
      
    </div>
  </template>
  
  <script lang="ts" setup name="Blog">
  import { getBlogList,getById,updateBlog,insertBlog,deleteBlog } from '@/api/backend/blog/blogs';
  import {FormInstance,ElNotification,ElForm,FormRules} from "element-plus"
  import { blogConfig } from '@/stores/blog';

  const blogconfig = blogConfig();


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
    roleCode:"",
    name:"",
    status:"1",
    remark:"",
  });
  
  // 表单验证规则
  const rules = reactive<FormRules>({
      title: [
          { required: true, message: '请输入标题', trigger: 'blur' },
      ],
      path: [
          {
          required: true,
          message: '请输入路径',
          trigger: 'blur',
          },
      ],
  })
  
  const getList=()=>{
    tableLoading.value = true;
    getBlogList().then(e=>{
        tableData.value = e.rows;
        srcList.value = tableData.value.map((e:any)=>{
          return e.cover;
        })||[];
        total.value = e.total;
        tableLoading.value = false;
    })
  }
  
  
  const remove=(rowId:any )=>{
    tableLoading.value = true;
    deleteBlog(rowId).then(e=>{
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
    blogconfig.changeShowAdd();
  }
  

  
  
  
  
  
  
  getList();
  </script>
  
  
  <style scoped lang="scss">


  </style>