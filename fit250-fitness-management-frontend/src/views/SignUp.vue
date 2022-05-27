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
                <h4 slot="title" class="card-title">Sign Up</h4>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>face</md-icon>
                  <label>Your ID</label>
                  <md-input type="text" v-model="id"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>email</md-icon>
                  <label>Your email</label>
                  <md-input type="email" v-model="email"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>lock_outline</md-icon>
                  <label>Your password</label>
                  <md-input v-model="password" type="password"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>chat</md-icon>
                  <label>Write your resolution or any quote</label>
                  <md-input type="text" v-model="quote"></md-input>
                </md-field>
                <md-field class="md-form-group" slot="inputs">
                  <md-icon>flag</md-icon>
                  <label for="targets">Target body parts 1</label>
                  <md-select
                    v-model="selectedTarget1"
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
                    v-model="selectedTarget2"
                    name="targets"
                    id="targets2"
                  >
                    <md-option value="upper">Upper</md-option>
                    <md-option value="lower">Lower</md-option>
                    <md-option value="whole">Whole</md-option>
                    <md-option value="general">General</md-option>
                  </md-select>
                </md-field>
                <md-button
                  slot="footer"
                  type="submit"
                  class="md-simple md-success md-lg"
                >
                  Create Account
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
  name: "SingUp",
  components: {
    LoginCard
  },
  bodyClass: "login-page",
  data() {
    return {
      id: null,
      email: null,
      password: null,
      quote: null,
      selectedTarget1: null,
      selectedTarget2: null
    };
  },
  props: {
    header: {
      type: String,
      default: require("@/assets/img/bg/bg_signup.jpg")
    }
  },
  methods: {
    async handleSubmit() {
      const response = await axios.post("signup", {
        userid: this.id,
        email: this.email,
        pw: this.password,
        quote: this.quote,
        interest1: this.selectedTarget1,
        interest2: this.selectedTarget2
      });

      console.log(response);
      this.$router.push("./login");
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
