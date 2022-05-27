<template>
  <div class="wrapper">
    <div id="bestVideoCarousel">
      <div class="title">
        <h3>Videos</h3>
      </div>
      <div class="md-layout">
        <div class="md-layout-item md-size-66 mx-auto md-small-size-100">
          <md-card>
            <carousel
              :per-page="1"
              loop
              :speed="700"
              autoplay
              :autoplay-timeout="5000"
              :mouse-drag="false"
              navigationEnabled
              navigationNextLabel="<i class='material-icons'>keyboard_arrow_right</i>"
              navigationPrevLabel="<i class='material-icons'>keyboard_arrow_left</i>"
            >
              <slide v-for="video in videos" :key="video.id">
                <a :href="'http://localhost:8081/videodetail?id=' + video.id">
                  <img :src="video.thumbnail" alt="thumbnail" />
                </a>
              </slide>
            </carousel>
          </md-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: {
    videos: {
      type: Array,
      default: null
    }
  }
};
</script>
