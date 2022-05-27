<template>
  <md-toolbar
    id="toolbar"
    md-elevation="0"
    class="md-transparent md-absolute"
    :class="extraNavClasses"
    :color-on-scroll="colorOnScroll"
  >
    <div class="md-toolbar-row md-collapse-lateral">
      <div class="md-toolbar-section-start">
        <router-link to="/">
          <img
            src="../assets/img/logo.png"
            alt="fit250 logo"
            style="height:40px;"
          />
        </router-link>
      </div>
      <div class="md-toolbar-section-end">
        <md-button
          class="md-just-icon md-simple md-toolbar-toggle"
          :class="{ toggled: toggledClass }"
          @click="toggleNavbarMobile()"
        >
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </md-button>

        <div class="md-collapse">
          <div class="md-collapse-wrapper">
            <mobile-menu nav-mobile-section-start="false">
              <!-- Here you can add your items from the section-start of your toolbar -->
            </mobile-menu>
            <md-list v-if="!userToken">
              <md-list-item>
                <router-link to="/videos">
                  <i class="material-icons">view_carousel</i>
                  <p>Videos</p>
                </router-link>
              </md-list-item>

              <md-list-item>
                <router-link to="/login">
                  <i class="material-icons">login</i>
                  <p>Login</p>
                </router-link>
              </md-list-item>
            </md-list>
            <md-list v-if="userToken">
              <md-list-item>
                <router-link to="/videos">
                  <i class="material-icons">view_carousel</i>
                  <p>Videos</p>
                </router-link>
              </md-list-item>

              <md-list-item>
                <router-link to="/friends">
                  <i class="material-icons">people</i>
                  <p>Friends</p>
                </router-link>
              </md-list-item>

              <md-list-item>
                <router-link to="/mypage">
                  <i class="material-icons">dashboard</i>
                  <p>MyPage</p>
                </router-link>
              </md-list-item>

              <md-list-item>
                <a href="javascript:void(0)" @click="handleClick">
                  <i class="material-icons">logout</i>
                  <p>Logout</p>
                </a>
              </md-list-item>
            </md-list>
          </div>
        </div>
      </div>
    </div>
  </md-toolbar>
</template>

<script>
let resizeTimeout;
function resizeThrottler(actualResizeHandler) {
  // ignore resize events as long as an actualResizeHandler execution is in the queue
  if (!resizeTimeout) {
    resizeTimeout = setTimeout(() => {
      resizeTimeout = null;
      actualResizeHandler();

      // The actualResizeHandler will execute at a rate of 15fps
    }, 66);
  }
}

import MobileMenu from "@/layout/MobileMenu";
import { mapGetters } from "vuex";
export default {
  components: {
    MobileMenu
  },
  props: {
    type: {
      type: String,
      default: "white",
      validator(value) {
        return [
          "white",
          "default",
          "primary",
          "danger",
          "success",
          "warning",
          "info"
        ].includes(value);
      }
    },
    colorOnScroll: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      extraNavClasses: "",
      toggledClass: false
    };
  },
  methods: {
    handleClick() {
      sessionStorage.removeItem("token");
      sessionStorage.removeItem("userId");
      this.$store.dispatch("userToken", null);
      this.$store.dispatch("userId", null);
      alert("Well done!\nRemember today is the youngest you’ll ever be again.\nNever give up, now is the best time.")
      this.$router.push("/");
    },
    bodyClick() {
      let bodyClick = document.getElementById("bodyClick");

      if (bodyClick === null) {
        let body = document.querySelector("body");
        let elem = document.createElement("div");
        elem.setAttribute("id", "bodyClick");
        body.appendChild(elem);

        let bodyClick = document.getElementById("bodyClick");
        bodyClick.addEventListener("click", this.toggleNavbarMobile);
      } else {
        bodyClick.remove();
      }
    },
    toggleNavbarMobile() {
      this.NavbarStore.showNavbar = !this.NavbarStore.showNavbar;
      this.toggledClass = !this.toggledClass;
      this.bodyClick();
    },
    handleScroll() {
      let scrollValue =
        document.body.scrollTop || document.documentElement.scrollTop;
      let navbarColor = document.getElementById("toolbar");
      this.currentScrollValue = scrollValue;
      if (this.colorOnScroll > 0 && scrollValue > this.colorOnScroll) {
        this.extraNavClasses = `md-${this.type}`;
        navbarColor.classList.remove("md-transparent");
      } else {
        if (this.extraNavClasses) {
          this.extraNavClasses = "";
          navbarColor.classList.add("md-transparent");
        }
      }
    },
    scrollListener() {
      resizeThrottler(this.handleScroll);
    },
    scrollToElement() {
      let element_id = document.getElementById("downloadSection");
      if (element_id) {
        element_id.scrollIntoView({ block: "end", behavior: "smooth" });
      }
    }
  },
  mounted() {
    document.addEventListener("scroll", this.scrollListener);
  },
  beforeDestroy() {
    document.removeEventListener("scroll", this.scrollListener);
  },
  computed: {
    ...mapGetters(["userToken"])
  }
};
</script>
