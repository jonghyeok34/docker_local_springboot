<template>
  <v-app>
    <v-app-bar absolute dark>
      <v-toolbar-title>CRUD</v-toolbar-title>
    </v-app-bar>
    <v-container class="mt-16">
      <v-card class="mb-5" flat>
        <v-card-title>ORACLE</v-card-title>
        <v-card-text>
          <data-card
            type="oracle"
            class="mb-3"
            v-for="item in currentData['oracle']"
            :key="item.id"
            :item="item"
            :setCurrentData="setCurrentData"
          ></data-card>
          <input-data-card
            type="oracle"
            :setCurrentData="setCurrentData"
          ></input-data-card>
        </v-card-text>
      </v-card>
      <v-card class="mb-5" flat>
        <v-card-title>MYSQL</v-card-title>
        <v-card-text>
          <data-card
            type="mysql"
            class="mb-3"
            v-for="item in currentData['mysql']"
            :key="item.id"
            :item="item"
            :setCurrentData="setCurrentData"
          ></data-card>
          <input-data-card
            type="mysql"
            :setCurrentData="setCurrentData"
          ></input-data-card>
        </v-card-text>
      </v-card>
      <v-card class="mb-5" flat>
        <v-card-title>MONGODB</v-card-title>
        <v-card-text>
          <data-card
            type="mongo"
            class="mb-3"
            v-for="item in currentData['mongo']"
            :key="item.id"
            :item="item"
            :setCurrentData="setCurrentData"
          ></data-card>

          <input-data-card
            type="mongo"
            :setCurrentData="setCurrentData"
          ></input-data-card>
        </v-card-text>
      </v-card>
    </v-container>
  </v-app>
</template>

<script>
// import axios from "axios";
import { mongoApi, oracleApi, mysqlApi } from "@/apis";
import DataCard from "./components/DataCard.vue";
import InputDataCard from "./components/InputDataCard.vue";

export default {
  components: { DataCard, InputDataCard },
  data() {
    return {
      inputData: {
        mongo: null,
        mysql: null,
        oracle: null
      },
      currentData: {
        mongo: [],
        mysql: [],
        oracle: []
      }
    };
  },
  methods: {
    async addItem(type) {
      const api = await this.getApiByType(type);
      const data = {
        content: this.inputData[type]
      };
      await api.post("/add", data);
      this.setCurrentData(type);
    },
    async updateItem(type, id, content) {
      const api = await this.getApiByType(type);
      const data = {
        id: id,
        content: content
      };
      console.log(data);
      await api.post("/update", data);
      const res = await api.get("/all");
      this.currentData[type] = res.data;
    },
    async getApiByType(type) {
      var api;
      if (type === "mongo") api = mongoApi;
      if (type === "mysql") api = mysqlApi;
      if (type === "oracle") api = oracleApi;
      return api;
    },
    async setCurrentData(key) {
      const api = await this.getApiByType(key);
      const res = await api.get("/all");
      this.currentData[key] = [];
      for (const item of res.data) {
        item.updatable = false;
        this.currentData[key].push(item);
      }
    }
  },
  async created() {
    const arr = ["mongo", "mysql", "oracle"];

    for (const key of arr) {
      this.setCurrentData(key);
    }
  }
};
</script>

<style></style>
