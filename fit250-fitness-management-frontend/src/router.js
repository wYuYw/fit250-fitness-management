import Vue from "vue";
import Router from "vue-router";
import Index from "./views/Index.vue";
import Videos from "./views/Videos.vue";
import VideoDetail from "./views/VideoDetail.vue";
import Friends from "./views/Friends.vue";
import MyPage from "./views/MyPage.vue";
import EditProfile from "./views/EditProfile.vue";
import Login from "./views/Login.vue";
import SignUp from "./views/SignUp.vue";
import ToS from "./views/ToS.vue";
import PrivacyPolicy from "./views/PrivacyPolicy.vue";
import MainNavbar from "./layout/MainNavbar.vue";
import MainFooter from "./layout/MainFooter.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "index",
      components: { default: Index, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: "black" }
      }
    },
    {
      path: "/videos",
      name: "videos",
      components: { default: Videos, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: "black" }
      }
    },
    {
      path: "/videodetail",
      name: "videodetail",
      components: {
        default: VideoDetail,
        header: MainNavbar,
        footer: MainFooter
      },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: "black" }
      }
    },
    {
      path: "/friends",
      name: "friends",
      components: { default: Friends, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: "black" }
      },
      beforeEnter: function(to, from, next) {
        if (sessionStorage.getItem("token")) {
          next();
        } else {
          next("/login");
        }
      }
    },
    {
      path: "/mypage",
      name: "mypage",
      components: { default: MyPage, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: "black" }
      },
      beforeEnter: function(to, from, next) {
        if (sessionStorage.getItem("token")) {
          next();
        } else {
          next("/login");
        }
      }
    },
    {
      path: "/editprofile",
      name: "editprofile",
      components: {
        default: EditProfile,
        header: MainNavbar,
        footer: MainFooter
      },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: "black" }
      },
      beforeEnter: function(to, from, next) {
        if (sessionStorage.getItem("token")) {
          next();
        } else {
          next("/login");
        }
      }
    },
    {
      path: "/login",
      name: "login",
      components: { default: Login, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 }
      }
    },
    {
      path: "/signup",
      name: "signup",
      components: { default: SignUp, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 }
      }
    },
    {
      path: "/tos",
      name: "tos",
      components: { default: ToS, header: MainNavbar, footer: MainFooter },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: "black" }
      }
    },
    {
      path: "/privacypolicy",
      name: "privacypolicy",
      components: {
        default: PrivacyPolicy,
        header: MainNavbar,
        footer: MainFooter
      },
      props: {
        header: { colorOnScroll: 400 },
        footer: { backgroundColor: "black" }
      }
    }
  ],
  scrollBehavior: to => {
    if (to.hash) {
      return { selector: to.hash };
    } else {
      return { x: 0, y: 0 };
    }
  }
});
