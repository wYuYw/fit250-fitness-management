<template>
  <div class="wrapper">
    <parallax class="section page-header header-filter" :style="headerStyle">
      <div class="container">
        <div class="md-layout">
          <div
            class="md-layout-item md-size-50 md-small-size-70 md-xsmall-size-100"
          >
            <h1 class="title">Your Story Starts From Here.</h1>
            <h4>
              Amazing qaulified fitness guidelines from 45 trainers are here for
              you. Watch them and follow. We also offer personalized fitness
              guideline by tracking your fitness data.
            </h4>
            <br />
            <router-link to="/mypage">
              <md-button class="md-success md-lg">
                <i class="fas fa-play"></i> Track My Data
              </md-button>
            </router-link>
          </div>
        </div>
      </div>
    </parallax>
    <div class="main main-raised">
      <div class="section">
        <div class="container">
          <!-- search bar -->
          <div class="md-layout">
            <div
              class="md-layout-item md-size-66 md-xsmall-size-100 mx-auto text-center"
            >
              <div
                class="md-layout-item-center md-size-25 md-xsmall-size-100 md-small-size-50 md-medium-size-25"
              >
                <md-field class="md-form-group">
                  <md-icon>video_library</md-icon>
                  <md-input
                    placeholder="Search amazing videos"
                    v-model="videoSearchKeyword"
                    @keyup.enter="search"
                  ></md-input>
                </md-field>
              </div>
            </div>
          </div>
          <!-- videos, order: latest upload -->
          <div class="features text-center">
            <div class="md-layout md-videos">
              <div
                class="md-layout-item md-medium-size-33 md-small-size-100"
                v-for="video in videos"
                :key="video.id"
              >
                <videoListDisplay :video="video"></videoListDisplay>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import VideoListDisplay from "./components/VideoListDisplay";
export default {
  bodyClass: "landing-page",
  components: {
    VideoListDisplay
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/bg/bg_video.jpg")
    }
  },
  data() {
    return {
      videoSearchKeyword: null
    };
  },
  methods: {
    search() {
      const payload = {
        keyword: this.videoSearchKeyword
      };
      this.$store.dispatch("getVideos", payload);
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`
      };
    },
    ...mapGetters(["videos"])
  },
  created() {
    this.$store.dispatch("getVideos");
  }
};
</script>

<style lang="scss"></style>
