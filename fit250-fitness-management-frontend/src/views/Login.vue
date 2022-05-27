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
                <h4 slot="title" class="card-title">Login</h4>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>face</md-icon>
                  <label>ID...</label>
                  <md-input v-model="id"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>email</md-icon>
                  <label>Email...</label>
                  <md-input v-model="email" type="email"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>lock_outline</md-icon>
                  <label>Password...</label>
                  <md-input v-model="password" type="password"></md-input>
                </md-field>
                <md-button
                  slot="footer"
                  type="submit"
                  class="md-simple md-success md-lg"
                >
                  Sign In
                </md-button>

                <md-button slot="footer" class="md-simple md-success md-lg">
                  <router-link to="/signup" style="color:lightgreen">
                    Sign Up
                  </router-link>
                </md-button>
              </login-card>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { LoginCard } from "@/components";
import axios from "axios";

export default {
  name: "Login",
  components: {
    LoginCard
  },
  bodyClass: "login-page",
  data() {
    return {
      id: null,
      email: null,
      password: null
    };
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/bg/bg_login.jpg")
    }
  },
  methods: {
    async handleSubmit() {
      const response = await axios.post("login", {
        userid: this.id,
        email: this.email,
        pw: this.password
      });

      console.log(response);
      if (response.data.message !== "fail") {
        sessionStorage.setItem("token", response.data["access-token"]);
        sessionStorage.setItem("userId", response.data["userId"]);
        this.$store.dispatch("userToken", response.data["access-token"]);
        this.$store.dispatch("userId", response.data["userId"]);
        this.$router.push("/");
      } else {
        alert("Wrong info! If you're not a member, please sign up first.");
        this.$router.push("/login");
      }
    }
  },
  computed: {
    headerStyle() {
      return {
        backgroundImage: `url(${this.header})`,
        height: "100vh"
      };
    }
  }
};
</script>

<style lang="css"></style>
