<template>
  <div class="wrapper">
    <parallax class="page-header header-filter" :style="headerStyle">
      <div class="md-layout">
        <div class="md-layout-item">
          <div class="image-wrapper">
            <div class="brand">
              <h1>Fit250</h1>
              <h3>Stay consistent, move forward.</h3>
            </div>
          </div>
        </div>
      </div>
    </parallax>
    <div class="main main-raised">
      <div class="section section-best">
        <div class="container">
          <div class="title">
            <h2 class="title">Weekly Best</h2>
            <h4>
              Here are the best top 3 videos and highest performed users of last week!<br />
              Give them a big hand and challenge yourself to be the best!
              <h5>※Be aware that you cannot be on the list, if you set your privacy state to private.</h5>
            </h4>
          </div>
          <bestVideoCarousel :videos="videos"></bestVideoCarousel>
          <bestUserSection
            :users="users"
            :usersPerformaces="usersPerformaces"
          ></bestUserSection>
        </div>
      </div>
      <div class="section section-kpi">
        <div class="container">
          <div class="title">
            <h2 class="title">
              Rate 4.8<small>/5</small>
              <h4>
                The best place to get quality exercise management.<br />
                Meet your trainer, change the world from changing yourself.
              </h4>
            </h2>
          </div>
          <serviceKPI></serviceKPI>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import BestVideoCarousel from "./components/BestVideoCarousel";
import BestUserSection from "./components/BestUserSection";
import ServiceKPI from "./components/ServiceKPI";
import { mapGetters } from "vuex";

export default {
  components: {
    BestVideoCarousel,
    BestUserSection,
    ServiceKPI
  },
  name: "index",
  bodyClass: "index-page",
  props: {
    image: {
      type: String,
      default: require("@/assets/img/bg/bg_index.jpg")
    }
  },
  methods: {},
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.image})`
      };
    },
    ...mapGetters(["videos"]),
    ...mapGetters(["users"]),
    ...mapGetters(["usersPerformaces"])
  },
  created() {
    this.$store.dispatch("videoWeeklyTop3");
    this.$store.dispatch("getBestUsers");
    this.$store.dispatch("getBestUsersPerformaces");
  }
};
</script>
<style lang="scss">
.section-download {
  .md-button + .md-button {
    margin-left: 5px;
  }
}

@media all and (min-width: 991px) {
  .btn-container {
    display: flex;
  }
}
</style>
