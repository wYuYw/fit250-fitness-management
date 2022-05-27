import axios from "axios";
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

const REST_API = `http://localhost:8080/api`;

const state = {
  userToken: null,
  userId: null,
  user: null,
  userPerformance: null,
  users: null,
  usersPerformaces: null,
  searchedUsers: null,
  friends: null,
  videos: null,
  mypageRecVideos: null,
  video: null,
  comments: null
};

const store = new Vuex.Store({
  state,
  getters: {
    userToken: state => {
      if (sessionStorage.getItem("token")) {
        state.userToken = sessionStorage.getItem("token");
      } else {
        state.userToken = null;
      }
      return state.userToken;
    },
    userId: state => {
      if (sessionStorage.getItem("userId")) {
        state.userId = sessionStorage.getItem("userId");
      } else {
        state.userId = null;
      }
      return state.userId;
    },
    user: state => {
      return state.user;
    },
    userPerformance: state => {
      return state.userPerformance;
    },
    users: state => {
      return state.users;
    },
    usersPerformaces: state => {
      return state.usersPerformaces;
    },
    searchedUsers: state => {
      return state.searchedUsers;
    },
    friends: state => {
      return state.friends;
    },
    videos: state => {
      return state.videos;
    },
    mypageRecVideos: state => {
      return state.mypageRecVideos;
    },
    video: state => {
      return state.video;
    },
    comments: state => {
      return state.comments;
    }
  },
  actions: {
    userToken(context, useToken) {
      context.commit("mutateUserToken", useToken);
    },
    userId(context, userId) {
      context.commit("mutateUserId", userId);
    },
    getVideos({ commit }, payload) {
      let API_URL = `${REST_API}/video`;

      if (payload) {
        API_URL = `${REST_API}/video/${payload.keyword}`;
      }

      axios({
        url: API_URL,
        method: "GET"
      })
        .then(res => {
          // console.log(res);
          commit("GET_VIDEOS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getVideo({ commit }, payload) {
      const API_URL = `${REST_API}/videodetail/${payload.id}`;

      axios({
        url: API_URL,
        method: "GET"
      })
        .then(res => {
          console.log(res);
          commit("GET_VIDEO", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getRecRelatedVideos({ commit }, payload) {
      const API_URL = `${REST_API}/videoLevelRec`;

      axios({
        url: API_URL,
        method: "POST",
        data: payload
      })
        .then(res => {
          console.log(res);
          commit("GET_VIDEOS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    videoWeeklyTop3({ commit }, payload) {
      const API_URL = `${REST_API}/videoWeeklyTop3`;

      axios({
        url: API_URL,
        method: "GET"
      })
        .then(res => {
          console.log(res);
          commit("GET_VIDEOS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    clickLike({ commit }, payload) {
      const API_URL = `${REST_API}/videoHeart`;

      axios({
        url: API_URL,
        method: "POST",
        data: payload,
        headers: {
          "access-token": sessionStorage.getItem("token")
        }
      })
        .then(res => {
          console.log(res);
          commit("GET_VIDEO", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    displayLiked({ commit }, payload) {
      const API_URL = `${REST_API}/userHeart/${payload.id}`;

      axios({
        url: API_URL,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("token")
        }
      })
        .then(res => {
          console.log(res);
          commit("GET_VIDEOS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    displayRec({ commit }, payload) {
      const API_URL = `${REST_API}/userInterest/${payload.id}`;

      axios({
        url: API_URL,
        method: "GET",
        headers: {
          "access-token": sessionStorage.getItem("token")
        }
      })
        .then(res => {
          console.log(res);
          commit("GET_MYPAGERECVIDEOS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getUser({ commit }, payload) {
      const API_URL = `${REST_API}/user/${payload.id}`;

      axios({
        url: API_URL,
        method: "GET"
      })
        .then(res => {
          console.log(res);
          commit("GET_USER", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getUserPerformance({ commit }, payload) {
      const API_URL = `${REST_API}/userPerformance/${payload.id}`;

      axios({
        url: API_URL,
        method: "GET"
      })
        .then(res => {
          console.log(res);
          commit("GET_USERPERFORMANCE", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    linkDevice({ commit }, payload) {
      const API_URL = `${REST_API}/mounted/${payload.userId}`;

      axios({
        url: API_URL,
        method: "PUT"
      })
        .then(res => {
          console.log(res);
          commit("GET_USER", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    modifyProfile({ commit }, payload) {
      const API_URL = `${REST_API}/user/${payload.id}`;

      axios({
        url: API_URL,
        method: "PUT",
        data: payload
      })
        .then(res => {
          console.log(res);
          commit("GET_USER", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getBestUsersPerformaces({ commit }, payload) {
      const API_URL = `${REST_API}/monthlyTop2Performance`;

      axios({
        url: API_URL,
        method: "GET"
      })
        .then(res => {
          console.log(res);
          commit("GET_USERSPERFORMANCES", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getBestUsers({ commit }, payload) {
      const API_URL = `${REST_API}/monthlyTop2`;

      axios({
        url: API_URL,
        method: "GET"
      })
        .then(res => {
          console.log(res);
          commit("GET_USERS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getFriends({ commit }, payload) {
      const API_URL = `${REST_API}/friend`;

      axios({
        url: API_URL,
        method: "POST",
        data: payload
      })
        .then(res => {
          // console.log(res);
          commit("GET_FRIENDS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getSearchedUsers({ commit }, payload) {
      const API_URL = `${REST_API}/notfriend`;

      axios({
        url: API_URL,
        method: "POST",
        data: payload
      })
        .then(res => {
          console.log(res);
          commit("GET_SEARCHEDUSERS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    deleteFriend({ commit }, payload) {
      const API_URL = `${REST_API}/removefriend`;

      axios({
        url: API_URL,
        method: "POST",
        data: payload
      })
        .then(res => {
          console.log(res);
          commit("GET_FRIENDS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    addFriend({ commit }, payload) {
      const API_URL = `${REST_API}/addfriend`;

      axios({
        url: API_URL,
        method: "POST",
        data: payload
      })
        .then(res => {
          console.log(res);
          commit("GET_FRIENDS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    getComments({ commit }, payload) {
      const API_URL = `${REST_API}/comment/${payload.id}`;

      axios({
        url: API_URL,
        method: "GET"
      })
        .then(res => {
          console.log(res);
          commit("GET_COMMENTS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    addComment({ commit }, payload) {
      const API_URL = `${REST_API}/comment`;

      axios({
        url: API_URL,
        method: "POST",
        data: payload
      })
        .then(res => {
          console.log(res);
          commit("GET_COMMENTS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    deleteComment({ commit }, payload) {
      const API_URL = `${REST_API}/removecomment`;
      console.log(API_URL);

      axios({
        url: API_URL,
        method: "POST",
        data: payload
      })
        .then(res => {
          console.log(res);
          commit("GET_COMMENTS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    modifyComment({ commit }, payload) {
      const API_URL = `${REST_API}/modifycomment`;
      console.log(API_URL);

      axios({
        url: API_URL,
        method: "POST",
        data: payload
      })
        .then(res => {
          console.log(res);
          commit("GET_COMMENTS", res.data);
        })
        .catch(err => {
          console.log(err);
        });
    }
  },
  mutations: {
    mutateUserToken(state, userToken) {
      state.userToken = userToken;
    },
    mutateUserId(state, userId) {
      state.userId = userId;
    },
    GET_VIDEOS(state, payload) {
      state.videos = payload;
    },
    GET_MYPAGERECVIDEOS(state, payload) {
      state.mypageRecVideos = payload;
    },
    GET_VIDEO(state, payload) {
      state.video = payload;
    },
    GET_USER(state, payload) {
      state.user = payload;
    },
    GET_USERPERFORMANCE(state, payload) {
      state.userPerformance = payload;
    },
    GET_SEARCHEDUSERS(state, payload) {
      state.searchedUsers = payload;
    },
    GET_USERS(state, payload) {
      state.users = payload;
    },
    GET_USERSPERFORMANCES(state, payload) {
      state.usersPerformaces = payload;
    },
    GET_FRIENDS(state, payload) {
      state.friends = payload;
    },
    GET_COMMENTS(state, payload) {
      state.comments = payload;
    }
  }
});

export default store;
