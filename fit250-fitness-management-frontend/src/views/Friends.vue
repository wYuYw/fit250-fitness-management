<template>
  <div class="wrapper">
    <parallax class="section page-header header-filter" :style="headerStyle">
      <div class="container">
        <div class="md-layout">
          <div
            class="md-layout-item md-size-50 md-small-size-70 md-xsmall-size-100"
          >
            <h1 class="title">Together, further</h1>
            <h4>
              "None of us, including me, ever do great things. But we can all do
              small things, with great love, and together we can do something
              wonderful." – Mother Teresa
            </h4>
          </div>
        </div>
      </div>
    </parallax>
    <div class="main main-raised">
      <div class="section">
        <div class="container">
          <div class="md-layout">
            <div
              class="md-layout-item md-size-66 md-xsmall-size-100 mx-auto text-center"
            >
              <h2 class="title text-center">Your Friends</h2>
            </div>
          </div>
          <!-- friend search bar -->
          <div class="md-layout">
            <div
              class="md-layout-item md-size-66 md-xsmall-size-100 mx-auto text-center"
            >
              <div
                class="md-layout-item-center md-size-25 md-xsmall-size-100 md-small-size-50 md-medium-size-25"
              >
                <md-field class="md-form-group">
                  <md-icon>people</md-icon>
                  <md-input
                    placeholder="Find your friend"
                    v-model="friendSearchKeyword"
                    @keyup.enter="searchFriend"
                  ></md-input>
                </md-field>
              </div>
            </div>
          </div>
          <!-- Friend list -->
          <div
            class="md-layout"
            v-for="friend in friends"
            :key="friend.userTableId2"
          >
            <md-toolbar class="md-info">
              <div class="md-toolbar-row">
                <div class="md-toolbar-section-start">
                  <h3 class="md-title">{{ friend.friendUserid }}</h3>
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
                      <md-list-item href="javascript:void(0)">
                        <md-icon>access_alarm</md-icon>
                        {{ Math.floor(friend.minute / 60) }} Hours
                      </md-list-item>

                      <md-list-item href="javascript:void(0)">
                        <md-icon>grade</md-icon>
                        {{ friend.calorie }} kcal Burned Calorie
                      </md-list-item>

                      <md-list-item
                        href="javascript:void(0)"
                        @click="deleteFriend(friend.userTableId2)"
                      >
                        <md-icon>delete</md-icon>
                        Delete friend
                      </md-list-item>
                    </md-list>
                  </div>
                </div>
              </div>
            </md-toolbar>
          </div>

          <!-- user search bar -->
          <div
            class="md-layout-item md-size-66 md-xsmall-size-100 mx-auto text-center"
          >
            <h2 class="title text-center">Search Other Users</h2>
          </div>
          <div class="md-layout">
            <div
              class="md-layout-item md-size-66 md-xsmall-size-100 mx-auto text-center"
            >
              <div
                class="md-layout-item-center md-size-25 md-xsmall-size-100 md-small-size-50 md-medium-size-25"
              >
                <md-field class="md-form-group">
                  <md-icon>people</md-icon>
                  <md-input
                    placeholder="Search people by id"
                    v-model="userSearchKeyword"
                    @keyup.enter="searchUser"
                  ></md-input>
                </md-field>
              </div>
            </div>
          </div>
          <!-- Searched user list -->
          <div
            class="md-layout"
            v-if="isLoad"
            v-for="user in searchedUsers"
            :key="user.id"
          >
            <md-toolbar class="md-info">
              <div class="md-toolbar-row">
                <div class="md-toolbar-section-start">
                  <h3 class="md-title">{{ user.userid }}</h3>
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
                      <md-list-item
                        href="javascript:void(0)"
                        @click="addFriend(user.id)"
                      >
                        <md-icon>add</md-icon>
                        Add friend
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
export default {
  bodyClass: "landing-page",
  props: {
    header: {
      type: String,
      default: require("@/assets/img/bg/bg_friends.jpg")
    }
  },
  data() {
    return {
      friendSearchKeyword: null,
      userSearchKeyword: null,
      isLoad: false
    };
  },
  methods: {
    searchFriend() {
      const payload = {
        userTableId1: sessionStorage.getItem("userId"),
        userTableId2: this.friendSearchKeyword
      };
      this.$store.dispatch("getFriends", payload);
    },
    searchUser() {
      const payload = {
        userTableId1: sessionStorage.getItem("userId"),
        userTableId2: this.userSearchKeyword
      };
      this.$store.dispatch("getSearchedUsers", payload);
      this.isLoad = true;
    },
    deleteFriend(friendId) {
      const payload = {
        userTableId1: sessionStorage.getItem("userId"),
        userTableId2: friendId
      };
      this.$store.dispatch("deleteFriend", payload);
      this.$forceUpdate();
    },
    addFriend(friendId) {
      const payload = {
        userTableId1: sessionStorage.getItem("userId"),
        userTableId2: friendId
      };
      this.$store.dispatch("addFriend", payload);
      this.userSearchKeyword = null;
      this.isLoad = false;
      this.$forceUpdate();
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`
      };
    },
    ...mapGetters(["friends"]),
    ...mapGetters(["searchedUsers"])
  },
  created() {
    const payload = {
      userTableId1: sessionStorage.getItem("userId")
    };
    this.$store.dispatch("getFriends", payload);
    searchedUsers = null;
    if (!userSearchKeyword) {
      searchedUsers = null;
      this.$forceUpdate();
    }
  }
};
</script>

<style lang="scss" scoped>
.md-card-actions.text-center {
  display: flex;
  justify-content: center !important;
}
.contact-form {
  margin-top: 30px;
}

.md-has-textarea + .md-layout {
  margin-top: 15px;
}
</style>
