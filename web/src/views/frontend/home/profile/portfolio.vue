<template>
    <section class="portfolios-section spad" id="portfolio">
        <div class="container">
            <div class="section-title">
                <h2>我的旅程</h2>
                <p>出乎意料的是，舒适感并不明显。表妹们分分钟高兴起来。天才已经看尽激怒了春天。</p>
            </div>
            <ul class="portfolio-filter">
			    <li class="filter" data-filter="*">全部</li>
			    <li class="filter" data-filter=".ill">插图</li>
			    <li class="filter" data-filter=".brand">品牌推广</li>
			    <li class="filter" data-filter=".fs">时尚</li>
		    </ul>
            <el-row class="portfolio_container" style="position: relative; height: 841.937px;">
                <el-col class="grid-item" :md="8" :sm="8" :xs="24" style="position: absolute; left: 0px; top: 0px;">
                  <div class="work-item">
                    <img src="@/assets/images/1.jpg" alt="">
                    <div class="work-inner">
                      <a class="work-zoom" href="#workID-1">
                        <i class="iconfont icon-sousuo"></i>
                      </a>
                    </div>
                  </div>
                  <div id="workID-1" class="mfp-hide work-popup" style="display: none;">
                              <img src="@/assets/images/1.jpg" alt="">
                              <div class="work-popup-content">
                                <h3>Project Title</h3>
                                <p>In media, which includes textual, audio, and visual content, free licensing schemes such as some of the licenses made by Creative Commons have allowed for the dissemination of works under a clear set of legal permissions.</p>
                            </div>
                  </div> 
				        </el-col>
                <el-col class="grid-item"  :md="8" :sm="8" :xs="24"  style="position: absolute; left: 390px; top: 0px;">
					<div class="work-item">
						<img src="@/assets/images/2.jpg" alt="">
						<div class="work-inner">
							<a class="work-zoom" href="#workID-2"><i class="iconfont icon-sousuo"></i></a>
						</div>
					</div>
					<div id="workID-2" class="work-popup mfp-hide" style="display: none;">
	                  	<img src="@/assets/images/2.jpg" alt="">
	                  	<div class="work-popup-content">
		                    <h3>项目名称</h3>
		                    <p>在包括文本、音频和视觉内容的媒体中，免费许可方案（例如知识共享许可所制定的某些许可）允许在一组明确的法律许可下传播作品。</p>
		                </div>
	              	</div> 
                </el-col>
                <el-col class="grid-item" :md="8" :sm="8" :xs="24"  style="position: absolute; left: 780px; top: 0px;">
					<div class="work-item">
						<img src="@/assets/images/3.jpg" alt="">
						<div class="work-inner">
							<a class="work-zoom" href="#workID-3"><i class="iconfont icon-sousuo"></i></a>
						</div>
					</div>
					<div id="workID-3" class="work-popup mfp-hide" style="display: none;">
	                  	<img src="@/assets/images/3.jpg" alt="">
	                  	<div class="work-popup-content">
		                    <h3>Project Title</h3>
		                    <p>In media, which includes textual, audio, and visual content, free licensing schemes such as some of the licenses made by Creative Commons have allowed for the dissemination of works under a clear set of legal permissions.</p>
		                </div>
	              	</div> 
                </el-col>
                <el-col class="grid-item" :md="8" :sm="8" :xs="24"  style="position: absolute; left: 0px; top: 473px;">
					<div class="work-item">
						<img src="@/assets/images/5.jpg" alt="">
						<div class="work-inner">
							<a class="work-zoom" href="#workID-5"><i class="iconfont icon-sousuo"></i></a>
						</div>
					</div>
					<div id="workID-5" class="mfp-hide work-popup" style="display: none;">
	                  	<img src="@/assets/images/5.jpg" alt="">
	                  	<div class="work-popup-content">
		                    <h3>Project Title</h3>
		                    <p>In media, which includes textual, audio, and visual content, free licensing schemes such as some of the licenses made by Creative Commons have allowed for the dissemination of works under a clear set of legal permissions.</p>
		                </div>
	              	</div>
                </el-col>
                <el-col class="grid-item" :md="8" :sm="8" :xs="24" style="position: absolute; left: 390px; top: 390px;">
					<div class="work-item">
						<img src="@/assets/images/4.jpg" alt="">
						<div class="work-inner">
							<a class="work-zoom" href="#workID-4"><i class="iconfont icon-sousuo"></i></a>
						</div>
					</div>
					<div id="workID-4" class="work-popup mfp-hide" style="display: none;">
	                  	<img src="@/assets/images/4.jpg" alt="">
	                  	<div class="work-popup-content">
		                    <h3>Project Title</h3>
		                    <p>In media, which includes textual, audio, and visual content, free licensing schemes such as some of the licenses made by Creative Commons have allowed for the dissemination of works under a clear set of legal permissions.</p>
		                </div>
	              	</div>
                </el-col>
                <el-col class="grid-item" :md="8" :sm="8" :xs="24" style="position: absolute; left: 780px; top: 501px;">
					<div class="work-item">
						<img src="@/assets/images/6.jpg" alt="">
						<div class="work-inner">
							<a class="work-zoom" href="#workID-6"><i class="iconfont icon-sousuo"></i></a>
						</div>
					</div>
					<div id="workID-6" class="work-popup mfp-hide" style="display: none;">
	                  	<img src="@/assets/images/6.jpg" alt="">
	                  	<div class="work-popup-content">
		                    <h3>Project Title</h3>
		                    <p>In media, which includes textual, audio, and visual content, free licensing schemes such as some of the licenses made by Creative Commons have allowed for the dissemination of works under a clear set of legal permissions.</p>
		                </div>
	              	</div>
                </el-col>
            </el-row>
        </div>
    </section>
</template>

<script setup lang="ts" name="Portfolio">

</script>

<style scoped lang="scss">
@import "@/styles/homePage.scss";



</style>