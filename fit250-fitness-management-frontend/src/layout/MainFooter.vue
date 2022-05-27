<template>
  <footer
    class="footer"
    :class="{ [`footer-${type}`]: type }"
    :data-background-color="backgroundColor"
  >
    <div class="container">
      <nav>
        <ul>
          <li>
            <router-link to="/tos">
              Terms of service
            </router-link>
          </li>
          <li>
            <router-link to="/privacypolicy">
              privacy policy
            </router-link>
          </li>
        </ul>
      </nav>
      <div class="copyright">&copy; {{ year }} SS & MJ ALL RIGHTS RESERVED</div>
    </div>
  </footer>
</template>
<script>
export default {
  props: {
    backgroundColor: String,
    type: String
  },
  data() {
    return {
      year: new Date().getFullYear()
    };
  }
};
</script>
<style></style>
