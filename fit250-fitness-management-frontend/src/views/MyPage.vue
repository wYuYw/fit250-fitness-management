<template>
  <div class="wrapper">
    <parallax
      class="section page-header header-filter"
      :style="headerStyle"
    ></parallax>
    <div class="main main-raised">
      <div class="section profile-content">
        <div class="container">
          <div class="md-layout">
            <div class="md-layout-item md-size-50 mx-auto">
              <div class="profile">
                <div class="name">
                  <h3 class="title">
                    <router-link
                      to="/editprofile"
                      style="text-decoration: none; color: white"
                    >
                      {{ user.userid }}<md-icon style="color:lightgray">edit</md-icon>
                    </router-link>
                  </h3>
                </div>
              </div>
            </div>
          </div>
          <div class="description text-center ">
            <h6>
              target
            </h6>
            <h3>{{ user.interest1 }}, {{ user.interest2 }}</h3>
          </div>
          <div class="description text-center quote">
            <h6>
              Quote
            </h6>
            <h3>{{ user.quote }}</h3>
          </div>
          <div class="profile-tabs">
            <tabs
              :tab-name="['Dashboard', 'Favorite', 'Recommended']"
              :tab-icon="['grid_view', 'favorite', 'recommend']"
              plain
              nav-pills-icons
              color-button="success"
            >
              <!-- User performance data -->
              <template slot="tab-pane-1">
                <div v-if="user.mounted === 'Y'" class="features text-center">
                  <div class="md-layout md-videos">
                    <div
                      class="md-layout-item md-medium-size-33 md-small-size-100"
                    >
                      <div class="info">
                        <h3>
                          Calorie<md-tooltip md-direction="top"
                            >Total Burned Calories</md-tooltip
                          >
                        </h3>
                        <h1>{{ userPerformance.calorie }}</h1>
                      </div>
                    </div>
                    <div
                      class="md-layout-item md-medium-size-33 md-small-size-100"
                    >
                      <div class="info">
                        <h3>
                          BMI<md-tooltip md-direction="top"
                            >Current BMI</md-tooltip
                          >
                        </h3>
                        <h1>
                          {{ userPerformance.bmi }}
                          <md-tooltip v-if="userPerformance.bmi < 18" md-direction="bottom">Eat well and Go!</md-tooltip>
                          <md-tooltip v-else-if="18 <= userPerformance.bmi < 23" md-direction="bottom">Totally healthy!</md-tooltip>
                          <md-tooltip v-else-if="23 <= userPerformance.bmi < 25" md-direction="bottom">Keep it up!</md-tooltip>
                          <md-tooltip v-else-if="25 <= userPerformance.bmi" md-direction="bottom">You need to see a doctor</md-tooltip>
                        </h1>
                      </div>
                    </div>
                    <div
                      class="md-layout-item md-medium-size-33 md-small-size-100"
                    >
                      <div class="info">
                        <h3>
                          Days<md-tooltip md-direction="top"
                            >Total workout days</md-tooltip
                          >
                        </h3>
                        <h1>{{ userPerformance.days }}</h1>
                      </div>
                    </div>
                    <div
                      class="md-layout-item md-medium-size-33 md-small-size-100"
                    >
                      <div class="info">
                        <h3>
                          Hours<md-tooltip md-direction="top"
                            >Total workout hours</md-tooltip
                          >
                        </h3>
                        <h1>{{ Math.floor(userPerformance.minute / 60) }}</h1>
                      </div>
                    </div>
                  </div>
                </div>

                <div v-else class="features text-center">
                  <div class="md-layout md-videos">
                    <!-- device -->
                    <div
                      class="md-layout-item md-medium-size-33 md-small-size-100"
                    >
                      <div class="wrapper">
                        <div class="info">
                          <img
                            src="../assets/img/device.jpg"
                            alt="Raised Image"
                            class="img-raised rounded"
                            :class="{ 'responsive-image': responsive }"
                          />

                          <h5 class="info-title">Purchase your own device!</h5>
                        </div>
                      </div>
                    </div>
                    <div
                      class="md-layout-item md-medium-size-33 md-small-size-100"
                    >
                      <!-- promote -->
                      <div class="wrapper">
                        <div class="info">
                          <h3 class="title" style="color:gray">
                            Link your tracker
                          </h3>
                          <form
                            novalidate
                            class="md-layout"
                            @submit.prevent="handleSubmit"
                          >
                            <md-field class="md-form-group" slot="inputs">
                              <md-icon>devices_other</md-icon>
                              <label>Submit serial number of your device</label>
                              <md-input v-model="serialNumber"></md-input>
                            </md-field>
                            <md-button
                              slot="footer"
                              type="submit"
                              class="md-simple md-success md-lg"
                            >
                              Connect
                            </md-button>
                          </form>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </template>

              <!-- Favorite (Liked) videos -->
              <template slot="tab-pane-2">
                <div class="features text-center">
                  <div class="md-layout md-videos">
                    <div
                      class="md-layout-item md-medium-size-33 md-small-size-100"
                      v-for="favVideo in videos"
                      :key="favVideo.id"
                    >
                      <videoListDisplay :video="favVideo"></videoListDisplay>
                    </div>
                  </div>
                </div>
              </template>

              <!-- Recommended videos; by interest parts -->
              <template slot="tab-pane-3">
                <div class="features text-center">
                  <div class="md-layout md-videos">
                    <div
                      class="md-layout-item md-medium-size-33 md-small-size-100"
                      v-for="recVideo in mypageRecVideos"
                      :key="recVideo.id"
                    >
                      <videoListDisplay :video="recVideo"></videoListDisplay>
                    </div>
                  </div>
                </div>
              </template>
            </tabs>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { Tabs } from "@/components";
import { mapGetters } from "vuex";
import VideoListDisplay from "./components/VideoListDisplay";
export default {
  components: {
    Tabs,
    VideoListDisplay
  },
  bodyClass: "profile-page",
  data() {
    return {
      serialNumber: null
    };
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/bg/bg_mypage.jpg")
    }
  },
  methods: {
    handleSubmit() {
      if (this.serialNumber) {
        const payload = {
          userId: sessionStorage.getItem("userId")
        };
        // console.log(payload)
        this.$store.dispatch("linkDevice", payload);
        this.$forceUpdate();
        // console.log(user);
      } else {
        alert("Wrtie serial number of your device");
      }
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`
      };
    },
    ...mapGetters(["user"]),
    ...mapGetters(["userPerformance"]),
    ...mapGetters(["videos"]),
    ...mapGetters(["mypageRecVideos"])
  },
  created() {
    let payload = {
      id: sessionStorage.getItem("userId")
    };
    this.$store.dispatch("getUser", payload);
    this.$store.dispatch("getUserPerformance", payload);
    this.$store.dispatch("displayLiked", payload);
    this.$store.dispatch("displayRec", payload);
  }
};
</script>

<style lang="scss" scoped>
.title {
  color: white;
}
.section {
  padding: 0;
}

.profile-tabs::v-deep {
  .md-card-tabs .md-list {
    justify-content: center;
  }

  [class*="tab-pane-"] {
    margin-top: 3.213rem;
    padding-bottom: 50px;

    img {
      margin-bottom: 2.142rem;
    }
  }
}
</style>
