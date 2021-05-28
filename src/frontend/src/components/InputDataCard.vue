<template>
  <v-card>
    <v-card-text>
      <v-text-field
        name="name"
        label="입력값"
        id="id"
        v-model="inputData"
      ></v-text-field>
    </v-card-text>
    <v-card-actions class="pt-0">
      <v-btn text color="teal accent-4" @click="addItem">
        추가
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  props: {
    type: String
  },
  data() {
    return {
      inputData: null
    };
  },
  methods: {
    async addItem() {
      const data = {
        type: this.type,
        content: this.inputData
      };
      this.$store.dispatch("addItem", data);
      this.inputData = null;
    }
  }
};
</script>

<style></style>
