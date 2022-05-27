<template>
  <div class="wrapper">
    <div id="nav-tabs">
      <h3>User</h3>
      <div class="md-layout">
        <div class="md-layout-item md-size-50 md-small-size-100">
          <h3>
            <small>{{ users[0].userid }}</small>
          </h3>
          <nav-tabs-card no-label>
            <template slot="content">
              <md-tabs class="md-success" md-alignment="left">
                <md-tab
                  id="tab-home"
                  md-label="Achievement"
                  md-icon="military_tech"
                >
                  <h4><small>220/250 days</small></h4>
                  <md-progress-bar
                    class="md-warning"
                    :md-value="amountUser[0]"
                  ></md-progress-bar>
                  <hr />
                  <h3 class="title">
                    {{ Math.floor(usersPerformaces[0].minute / 60)
                    }}<small> Hours</small>
                  </h3>
                  <hr />
                  <h3 class="title">
                    {{ usersPerformaces[0].calorie }}<small> kcal burned</small>
                  </h3>
                </md-tab>
                <md-tab id="tab-pages" md-label="Quote" md-icon="chat">
                  <h3 class="title" v-if="users[0].quote">
                    <small>{{ users[0].quote }}</small>
                  </h3>
                  <p v-else>{{ users[0].userid }} didn't put quote.</p>
                </md-tab>
              </md-tabs>
            </template>
          </nav-tabs-card>
        </div>
        <div class="md-layout-item md-size-50 md-small-size-100">
          <h3>
            <small>{{ users[1].userid }}</small>
          </h3>
          <nav-tabs-card no-label>
            <template slot="content">
              <md-tabs class="md-info" md-alignment="left">
                <md-tab
                  id="tab-home"
                  md-label="Achievement"
                  md-icon="military_tech"
                >
                  <h4><small>197/250 days</small></h4>
                  <md-progress-bar
                    class="md-warning"
                    :md-value="amountUser[1]"
                  ></md-progress-bar>
                  <hr />
                  <h3 class="title">
                    {{ Math.floor(usersPerformaces[1].minute / 60)
                    }}<small> Hours</small>
                  </h3>
                  <hr />
                  <h3 class="title">
                    {{ usersPerformaces[1].calorie }}<small> kcal burned</small>
                  </h3>
                </md-tab>
                <md-tab id="tab-pages" md-label="Quote" md-icon="chat">
                  <h3 class="title" v-if="users[1].quote">
                    <small>{{ users[1].quote }}</small>
                  </h3>
                  <p v-else>{{ users[1].userid }} didn't put quote.</p>
                </md-tab>
              </md-tabs>
            </template>
          </nav-tabs-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { NavTabsCard } from "@/components";

export default {
  components: {
    NavTabsCard
  },
  data() {
    return {
      amountUser: [88, 78]
    };
  },
  props: {
    users: {
      type: Array,
      default: null
    },
    usersPerformaces: {
      type: Array,
      default: null
    }
  }
};
</script>

<style lang="css"></style>
