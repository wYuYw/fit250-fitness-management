<template>
  <div class="wrapper">
    <div class="info">
      <a :href="'http://localhost:8081/videodetail?id=' + video.id">
        <img
          :src="video.thumbnail"
          alt="Raised Image"
          class="img-raised rounded"
          :class="{ 'responsive-image': responsive }"
        />
      </a>

      <h4 class="info-title">{{ video.title }}</h4>
      <p>
        {{ video.description }}
      </p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      responsive: false
    };
  },
  props: {
    video: {
      type: Object,
      default: null
    }
  },
  methods: {
    onResponsiveInverted() {
      if (window.innerWidth < 600) {
        this.responsive = true;
      } else {
        this.responsive = false;
      }
    }
  },
  mounted() {
    this.onResponsiveInverted();
    window.addEventListener("resize", this.onResponsiveInverted);
  },
  beforeDestroy() {
    window.removeEventListener("resize", this.onResponsiveInverted);
  }
};
</script>

<style lang="scss" scoped>
.md-videos {
  display: flex;
  flex-wrap: wrap;
}
.info {
  width: 350px;
}
</style>
