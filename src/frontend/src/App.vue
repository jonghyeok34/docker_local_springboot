<template>
  <v-app>
    <v-app-bar absolute dark>
      <v-toolbar-title>CRUD</v-toolbar-title>
    </v-app-bar>
    <v-container class="mt-16">
      <v-card class="mb-5" flat>
        <v-card-title>ORACLE</v-card-title>
        <v-card-text>
          <v-card
            class="mb-3"
            v-for="item in currentData['oracle']"
            :key="item.id"
          >
            <v-card-title>{{ item.content }} </v-card-title>
            <v-card-text></v-card-text>
            <v-card-actions class="pt-0">
              <!-- <v-btn text color="red accent-4">
                삭제
              </v-btn>
              <v-btn text color="teal accent-4">
                수정
              </v-btn> -->
            </v-card-actions>
          </v-card>
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
          <v-card
            class="mb-3"
            v-for="item in currentData['mysql']"
            :key="item.id"
          >
            <v-card-title>{{ item.content }} </v-card-title>
            <v-card-text></v-card-text>
            <v-card-actions class="pt-0">
              <!-- <v-btn text color="red accent-4">
                삭제
              </v-btn>
              <v-btn text color="teal accent-4">
                수정
              </v-btn> -->
            </v-card-actions>
          </v-card>
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
          <v-card
            class="mb-3"
            v-for="item in currentData['mongo']"
            :key="item.id"
          >
            <v-card-title>{{ item.content }} </v-card-title>
            <v-card-text></v-card-text>
            <v-card-actions class="pt-0">
              <!-- <v-btn text color="red accent-4">
                삭제
              </v-btn>
              <v-btn
                text
                color="teal accent-4"
                @click="updateItem('mongo', item.id, item.content)"
              >
                수정
              </v-btn> -->
            </v-card-actions>
          </v-card>
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
import axios from "axios";

export function setInterceptors(instance) {
  instance.interceptors.request.use(
    function(config) {
      config.headers["Access-Control-Allow-Origin"] = "*";
      return config;
    },
    function(error) {
      return Promise.reject(error);
    }
  );

  instance.interceptors.response.use(
    function(response) {
      return response;
    },
    function(error) {
      return Promise.reject(error);
    }
  );
  return instance;
}

function createInstance(url) {
  return setInterceptors(
    axios.create({
      baseURL: `${process.env.VUE_APP_API_URL}${url}`
    })
  );
}
const mongoApi = createInstance("/mongo");
const oracleApi = createInstance("/oracle");
const mysqlApi = createInstance("/mysql");

export default {
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
      console.log(data);
      await api.post("/add", data);
      const res = await api.get("/all");
      this.currentData[type] = res.data;
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
    }
  },
  async created() {
    const arr = ["mongo", "mysql", "oracle"];
    arr.forEach(key => {
      var api = this.getApiByType(key);
      this.currentData[key] = api.get("/all");
    });
  }
};
</script>

<style></style>
