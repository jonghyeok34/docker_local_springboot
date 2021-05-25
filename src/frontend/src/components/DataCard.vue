<template>
  <v-card class="mb-3">
    <v-card-title>
      <v-text-field
        style="font-size:1.5rem"
        :disabled="!item.updatable"
        v-model="item.content"
        rounded
        filled
        dense
      ></v-text-field>
    </v-card-title>
    <v-card-text> </v-card-text>
    <v-card-actions class="pt-0">
      <template v-if="item.updatable == false">
        <v-btn text color="red accent-4" @click="deleteItem(item.id)">
          삭제
        </v-btn>
        <v-btn text color="teal accent-4" @click="changeUpdatable(item)">
          수정
        </v-btn>
      </template>
      <template v-else>
        <v-btn text color="red accent-4" @click="changeUpdatable(item)">
          취소
        </v-btn>
        <v-btn
          text
          color="teal accent-4"
          @click="updateItem(type, item.id, item.content)"
        >
          완료
        </v-btn>
      </template>
    </v-card-actions>
  </v-card>
</template>

<script>
// import axios from "axios";
import { mongoApi, mysqlApi, oracleApi } from "@/apis";

export default {
  props: {
    item: Object,
    type: String,
    setCurrentData: Function
  },
  data() {
    return {
      currentData: []
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
    changeUpdatable(item) {
      if (item.updatable === undefined) {
        item.updatable = true;
      } else {
        item.updatable = !item.updatable;
      }
      console.log(item.updatable);
    },
    async updateItem(type, id, content) {
      console.log(1);
      const api = this.baseApi;

      const data = {
        id: id,
        content: content
      };
      await api.post("/update", data);
      await this.setCurrentData(type);
    },
    async deleteItem(id) {
      const api = this.baseApi;

      const data = {
        id: id
      };
      await api.post("/delete", data);
      await this.setCurrentData(this.type);
    }
  }
};
</script>

<style></style>
