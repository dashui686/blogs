<template>
    <v-md-preview 
        ref="preview"
        :text="text"
        style="width: 100%;"
    ></v-md-preview>
</template>

<script setup lang="ts" name="BlogInfoPreview">
import {ComponentInternalInstance} from "vue"
const {proxy} = getCurrentInstance() as ComponentInternalInstance;

const props = defineProps({
    text:{
        type: String
    },
    titles:{
        type: Array
    }
});

const emits = defineEmits(['update:titles'])

const {text} = toRefs(props);


const titles = computed({
  get() {
    return props.titles
  },
  set(val){
    emits('update:titles', val)
  }
})
const title = ref<any>([]);
nextTick(()=>{
        let preview = proxy!.$refs!.preview as any;
        const anchors = preview.$el.querySelectorAll('h1,h2,h3,h4,h5,h6');
        title.value = Array.from(anchors).filter((title:any) => !!title.innerText.trim());

        if (!title!.value.length) {
            title!.value = [];
        return;
        }

        const hTags = Array.from(new Set(title!.value.map((title:any) => title.tagName))).sort();

        title!.value = title!.value.map((el:any) => ({
            title: el.innerText,
            lineIndex: el.getAttribute('data-v-md-line'),
            indent: hTags.indexOf(el.tagName),
        }));
        titles.value = title.value
})

const handleAnchorClick=(anchor:any)=> {
      const { preview } = proxy!.$refs as any;
      const { lineIndex } = anchor;

      const heading = preview.$el.querySelector(`[data-v-md-line="${lineIndex}"]`);

      if (heading) {
        preview.scrollToTarget({
          target: heading,
          scrollContainer: window,
          top: 60,
        });
      }
    }


    //暴露state和play方法
defineExpose({
  handleAnchorClick
});
</script>

<style scoped>

</style>