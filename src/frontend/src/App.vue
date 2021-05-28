<template>
  <v-app>
    <v-app-bar absolute dark>
      <v-toolbar-title>CRUD</v-toolbar-title>
    </v-app-bar>
    <v-container class="mt-16">
      <main-content-card class="mb-5" title="ORACLE" type="oracle">
      </main-content-card>
      <main-content-card class="mb-5" title="MYSQL" type="mysql">
      </main-content-card>
      <main-content-card class="mb-5" title="MONGODB" type="mongo">
      </main-content-card>
    </v-container>
  </v-app>
</template>

<script>
// import axios from "axios";
import { mongoApi, oracleApi, mysqlApi } from "@/apis";
import MainContentCard from "./components/main/MainContentCard.vue";

export default {
  components: { MainContentCard },
  data() {
    return {
      inputData: {
        mongo: null,
        mysql: null,
        oracle: null
      },
      apis: {
        mongo: mongoApi,
        mysql: mysqlApi,
        oracle: oracleApi
      }
    };
  },
  computed: {
    currentData() {
      return this.$store.state.currentData;
    }
  },
  methods: {
    async setCurrentData(key) {
      await this.$store.dispatch("setCurrentData", key);
    }
  },
  async created() {
    this.$store.dispatch("resetCurrentData");
  }
};
</script>

<style></style>
