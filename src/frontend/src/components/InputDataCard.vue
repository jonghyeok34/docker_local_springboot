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
import { mongoApi, mysqlApi, oracleApi } from "@/apis";
export default {
  props: {
    type: String,
    setCurrentData: Function
  },
  data() {
    return {
      inputData: null
    };
  },
  computed: {
    baseApi() {
      const type = this.type;
      var api;
      if (type === "mongo") api = mongoApi;
      if (type === "mysql") api = mysqlApi;
      if (type === "oracle") api = oracleApi;
      return api;
    }
  },
  methods: {
    async addItem() {
      const api = this.baseApi;
      const data = {
        content: this.inputData
      };
      await api.post("/add", data);
      this.setCurrentData(this.type);
    }
  }
};
</script>

<style></style>
