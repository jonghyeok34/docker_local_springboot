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
import MainContentCard from "./components/main/MainContentCard.vue";

export default {
  components: { MainContentCard },
  async created() {
    this.$store.dispatch("resetCurrentData");
  }
};
</script>

<style></style>
