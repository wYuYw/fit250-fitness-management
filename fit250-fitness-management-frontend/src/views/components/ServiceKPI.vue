<template>
  <div class="wrapper">
    <div id="images">
      <div class="md-layout">
        <div
          class="md-layout-item md-size-20 md-xsmall-size-100 ml-auto"
          :class="{ 'text-center': responsive }"
        >
          <h3 class="title">10M+<small>kcal burned</small></h3>
          <img
            :src="image1"
            alt="Raised Image"
            class="img-raised rounded"
            :class="{ 'responsive-image': responsive }"
          />
        </div>
        <div
          class="md-layout-item md-size-20 md-xsmall-size-100 ml-auto"
          :class="{ 'text-center': responsive }"
        >
          <h3 class="title">20k+<small>hours workout</small></h3>
          <img
            :src="image2"
            alt="Raised Image"
            class="img-raised rounded"
            :class="{ 'responsive-image': responsive }"
          />
        </div>
        <div
          class="md-layout-item md-size-20 md-xsmall-size-100 ml-auto"
          :class="{ 'text-center': responsive }"
        >
          <h3 class="title">1k+<small>Users</small></h3>
          <img
            :src="image3"
            alt="Raised Image"
            class="img-raised rounded"
            :class="{ 'responsive-image': responsive }"
          />
        </div>
        <div
          class="md-layout-item md-size-20 md-xsmall-size-100 ml-auto"
          :class="{ 'text-center': responsive }"
        >
          <h3 class="title">45<small>Trainers</small></h3>
          <img
            :src="image4"
            alt="Raised Image"
            class="img-raised rounded"
            :class="{ 'responsive-image': responsive }"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      image1: require("@/assets/img/index_kpi/kcal.png"),
      image2: require("@/assets/img/index_kpi/time.png"),
      image3: require("@/assets/img/index_kpi/people.png"),
      image4: require("@/assets/img/index_kpi/trainers.png"),
      responsive: false
    };
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

<style lang="css"></style>
