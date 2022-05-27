<template>
  <div class="wrapper">
    <div class="section page-header header-filter" :style="headerStyle">
      <div class="container">
        <div class="md-layout">
          <div
            class="md-layout-item md-size-33 md-small-size-66 md-xsmall-size-100 md-medium-size-40 mx-auto"
          >
            <form novalidate class="md-layout" @submit.prevent="handleSubmit">
              <login-card header-color="green">
                <h4 slot="title" class="card-title">Edit your profile</h4>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>face</md-icon>
                  <label>Your id</label>
                  <md-input v-model="user.userid"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>email</md-icon>
                  <label>Your email</label>
                  <md-input v-model="user.email" type="email"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>lock_outline</md-icon>
                  <label>Your password</label>
                  <md-input v-model="user.pw" type="password"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>chat</md-icon>
                  <label>Write your resolution or any quote</label>
                  <md-input v-model="user.quote"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>flag</md-icon>
                  <label for="targets">Target body parts 1</label>
                  <md-select
                    v-model="user.interest1"
                    name="targets"
                    id="targets1"
                  >
                    <md-option value="upper">Upper</md-option>
                    <md-option value="lower">Lower</md-option>
                    <md-option value="whole">Whole</md-option>
                    <md-option value="general">General</md-option>
                  </md-select>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>flag</md-icon>
                  <label for="targets">Target body parts 2</label>
                  <md-select
                    v-model="user.interest2"
                    name="targets"
                    id="targets2"
                  >
                    <md-option value="upper">Upper</md-option>
                    <md-option value="lower">Lower</md-option>
                    <md-option value="whole">Whole</md-option>
                    <md-option value="general">General</md-option>
                  </md-select>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>remove_moderator</md-icon>
                  <label for="privacys">Make dashboard public</label>
                  <md-tooltip md-direction="left"
                    >Limited services if private</md-tooltip
                  >
                  <md-select v-model="user.privacy" name="privacy">
                    <md-option value="N">public</md-option>
                    <md-option value="Y">private</md-option>
                  </md-select>
                </md-field>
                <md-button
                  slot="footer"
                  type="submit"
                  class="md-simple md-success md-lg"
                >
                  Save your change
                </md-button>
              </login-card>
            </form>
            <p style="color: lightgray">
              To delete your account, please contact us by +8201010
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { LoginCard } from "@/components";
import { mapGetters } from "vuex";

export default {
  components: {
    LoginCard
  },
  bodyClass: "login-page",
  data() {
    return {
      user: this.$store.getters.user,
      targetList: ["upper", "lower", "whole", "general"]
    };
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/bg/bg_signup.jpg")
    }
  },
  methods: {
    handleSubmit() {
      const payload = {
        id: sessionStorage.getItem("userId"),
        userid: this.user.userid,
        email: this.user.email,
        pw: this.user.pw,
        quote: this.user.quote,
        interest1: this.user.interest1,
        interest2: this.user.interest2,
        privacy: this.user.privacy
      };
      if(payload.id && payload.userid && payload.email && payload.pw && payload.privacy) {
        this.$store.dispatch("modifyProfile", payload);
        this.$router.push("/mypage");
      } else {
        alert("Write whole properties")
      }
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`,
        height: "100vh"
      };
    },
    ...mapGetters(["user"])
  },
  created() {
    let payload = {
      id: sessionStorage.getItem("userId")
    };
    this.$store.dispatch("getUser", payload);
  }
};
</script>

<style lang="css"></style>
