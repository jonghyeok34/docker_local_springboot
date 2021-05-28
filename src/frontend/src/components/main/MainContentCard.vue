<template>
  <v-card flat>
    <v-card-title>{{ title }}</v-card-title>
    <v-card-text>
      <data-card
        :type="type"
        class="mb-3"
        v-for="item in currentDataByType"
        :key="item.id"
        :item="item"
      ></data-card>
      <input-data-card :type="type"></input-data-card>
    </v-card-text>
  </v-card>
</template>

<script>
import DataCard from "@/components/DataCard.vue";
import InputDataCard from "@/components/InputDataCard.vue";
export default {
  props: {
    title: String,
    type: String
  },
  computed: {
    currentDataByType() {
      return this.$store.state.currentData[this.type];
    }
  },
  components: { DataCard, InputDataCard }
};
</script>

<style></style>
