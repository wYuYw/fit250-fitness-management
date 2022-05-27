<template>
  <div class="wrapper">
    <parallax class="section page-header header-filter" :style="headerStyle">
      <div class="container">
        <div class="md-layout">
          <div
            class="md-layout-item md-size-50 md-small-size-70 md-xsmall-size-100"
          >
            <h1 class="title">
              {{ video.title }}
            </h1>
            <h4>
              #{{ video.channelName }} #{{ video.part }} #LEVEL
              {{ video.level }}
            </h4>
          </div>
        </div>
      </div>
    </parallax>
    <div class="main main-raised">
      <div class="section">
        <div class="container">
          <!-- Iframe -->
          <iframe
            class="main-video"
            align="middle"
            :src="'https://www.youtube.com/embed/' + video.videoid"
            title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
          ></iframe>
          <div class="videodetail-extra-info">
            <h5>{{ video.viewCnt }} views</h5>
            <md-button
              class="md-danger md-just-icon md-round"
              @click="handleClickLike(video.id)"
            >
              <md-tooltip md-direction="left">
                Liked by {{ video.countHeart }} people
              </md-tooltip>
              <md-icon>favorite</md-icon>
            </md-button>
          </div>

          <!-- recommended videos -->
          <div class="features text-center">
            <div class="md-layout md-videos">
              <div
                class="md-layout-item md-medium-size-33 md-small-size-100"
                v-for="v in videos"
                :key="v.id"
              >
                <videoListDisplay :video="v"></videoListDisplay>
              </div>
            </div>
          </div>
          <!-- comments -->
          <!-- comment input -->
          <div class="md-layout">
            <div
              class="md-layout-item md-size-66 md-xsmall-size-100 mx-auto text-center"
            >
              <div
                class="md-layout-item-center md-size-25 md-xsmall-size-100 md-small-size-50 md-medium-size-25"
              >
                <md-field class="md-form-group">
                  <md-icon>chat</md-icon>
                  <md-input
                    placeholder="Leave your comments"
                    v-model="commentContent"
                    @keyup.enter="addCommentContent"
                  ></md-input>
                </md-field>
              </div>
            </div>
          </div>
          <br />
          <!-- users' comments -->
          <div class="md-layout" v-for="comment in comments" :key="comment.id">
            <md-toolbar md-elevation="0" class="md-white">
              <div class="md-toolbar-row">
                <div class="md-toolbar-section-start">
                  <p v-if="isTarget !== comment.id" class="md-title">
                    {{ comment.content }}
                  </p>
                  <md-input
                    v-if="showEditSpace && isTarget === comment.id"
                    v-model="modifiedContent"
                    @keyup.enter="editComment(comment.id)"
                    style="width:500px"
                  ></md-input>
                </div>

                <div class="md-toolbar-section-end">
                  <md-button
                    class="md-just-icon md-simple md-white md-toolbar-toggle"
                  >
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </md-button>

                  <div class="md-collapse">
                    <md-list>
                      <md-list-item>
                        <h5>{{ comment.userid }}</h5>
                      </md-list-item>

                      <md-list-item
                        href="javascript:void(0)"
                        @click="startEditing(comment.id, comment.content)"
                        v-if="currentUserId === comment.userTableId"
                      >
                        <md-icon>edit</md-icon>
                        <md-tooltip md-direction="top">Edit comment</md-tooltip>
                      </md-list-item>

                      <md-list-item
                        href="javascript:void(0)"
                        @click="deleteComment(comment.id)"
                        v-if="currentUserId === comment.userTableId"
                      >
                        <md-icon>delete</md-icon>
                        <md-tooltip md-direction="top"
                          >Delete comment</md-tooltip
                        >
                      </md-list-item>
                    </md-list>
                  </div>
                </div>
              </div>
            </md-toolbar>
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
  props: {
    header: {
      type: String,
      default: require("@/assets/img/bg/bg_video.jpg")
    }
  },
  components: {
    VideoListDisplay
  },
  data() {
    return {
      commentContent: null,
      currentUserId: sessionStorage.getItem("userId"),
      showEditSpace: false,
      isTarget: null,
      modifiedContent: null
    };
  },
  methods: {
    handleClickLike(videoId) {
      if (sessionStorage.getItem("userId")) {
        const payload = {
          userId: sessionStorage.getItem("userId"),
          videoId: videoId
        };
        // console.log(payload)
        this.$store.dispatch("clickLike", payload);
        this.$forceUpdate();
      } else {
        alert("Please login first to like it");
      }
    },
    addCommentContent() {
      if (sessionStorage.getItem("userId")) {
        let url = new URL(window.location.href);
        const payload = {
          userTableId: sessionStorage.getItem("userId"),
          videoTableId: url.searchParams.get("id"),
          content: this.commentContent
        };
        // console.log(payload)
        this.$store.dispatch("addComment", payload);
        this.$forceUpdate();
        this.commentContent = null;
      } else {
        this.commentContent = null;
        alert("Please login first to leave comment");
      }
    },
    deleteComment(commentId) {
      let url = new URL(window.location.href);
      const payload = {
        id: commentId,
        videoTableId: url.searchParams.get("id")
      };
      this.$store.dispatch("deleteComment", payload);
      this.$forceUpdate();
    },
    startEditing(commentId, commentContent) {
      this.isTarget = commentId;
      this.showEditSpace = true;
      this.modifiedContent = commentContent;
    },
    editComment(commentId) {
      let url = new URL(window.location.href);
      this.isTarget = null;
      this.showEditSpace = false;
      const payload = {
        id: commentId,
        content: this.modifiedContent,
        videoTableId: url.searchParams.get("id")
      };
      this.$store.dispatch("modifyComment", payload);
      this.modifiedContent = null;
      this.$forceUpdate();
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`
      };
    },
    ...mapGetters(["videos"]),
    ...mapGetters(["video"]),
    ...mapGetters(["comments"])
  },
  mounted() {
    const url = new URL(window.location.href);
    let payload = {
      id: url.searchParams.get("id")
    };
    this.$store.dispatch("getVideo", payload);
    this.$store.dispatch("getRecRelatedVideos", payload);
    this.$store.dispatch("getComments", payload);
  }
};
</script>

<style lang="scss" scoped>
.main-video {
  height: 500px;
}
.videodetail-extra-info {
  display: flex;
  justify-content: space-between;
}
</style>
