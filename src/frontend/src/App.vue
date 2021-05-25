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
          <v-card>
            <v-card-text>
              <v-text-field
                name="name"
                label="입력값"
                id="id"
                v-model="inputData.oracle"
              ></v-text-field>
            </v-card-text>
            <v-card-actions class="pt-0">
              <v-btn text color="teal accent-4" @click="addItem('oracle')">
                추가
              </v-btn>
            </v-card-actions>
          </v-card>
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
          <v-card>
            <v-card-text>
              <v-text-field
                name="name"
                label="입력값"
                id="id"
                v-model="inputData.mysql"
              ></v-text-field>
            </v-card-text>
            <v-card-actions class="pt-0">
              <v-btn text color="teal accent-4" @click="addItem('mysql')">
                추가
              </v-btn>
            </v-card-actions>
          </v-card>
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

          <v-card>
            <v-card-text>
              <v-text-field
                name="name"
                label="입력값"
                id="id"
                v-model="inputData.mongo"
              ></v-text-field>
            </v-card-text>
            <v-card-actions class="pt-0">
              <v-btn text color="teal accent-4" @click="addItem('mongo')">
                추가
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-card-text>
      </v-card>
    </v-container>
  </v-app>
</template>

<script>
// import axios from "axios";
import { mongoApi, oracleApi, mysqlApi } from "@/apis";
import DataCard from "./components/DataCard.vue";

export default {
  components: { DataCard },
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
    // getAll() {
    //   var api;

    // }
    async addItem(type) {
      const api = await this.getApiByType(type);

      const data = {
        content: this.inputData[type]
      };
      await api.post("/add", data);
      this.setCurrentData(type);
      // const res = await api.get("/all");
      // this.currentData[type] = res.data;
    },
    // changeUpdatable(item) {
    //   if (item.updatable === undefined) {
    //     item.updatable = true;
    //   } else {
    //     item.updatable = !item.updatable;
    //   }
    //   console.log(item.updatable);
    // },
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
      console.log(type);
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
