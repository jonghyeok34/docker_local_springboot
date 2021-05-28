import { mongoApi, mysqlApi, oracleApi } from "@/apis";
import Vue from "vue";
import Vuex from "vuex";
Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    inputData: {
      mongo: null,
      mysql: null,
      oracle: null
    },
    currentData: {
      mongo: [],
      mysql: [],
      oracle: []
    },
    apis: {
      mongo: mongoApi,
      mysql: mysqlApi,
      oracle: oracleApi
    }
  },
  mutations: {},
  actions: {
    async addItem({ state, dispatch }, { type, content }) {
      const api = state.apis[type];
      const data = {
        // content: state.inputData[type]
        content: content
      };
      await api.post("/add", data);
      dispatch("setCurrentData", type);
    },
    async updateItem({ state, dispatch }, { type, id, content }) {
      // type, id, content
      const api = state.apis[type];
      const reqData = {
        id: id,
        content: content
      };
      console.log(reqData);
      await api.post("/update", reqData);
      dispatch("setCurrentData", type);
    },
    async deleteItem({ state, dispatch }, { type, id }) {
      // type, id, content
      const api = state.apis[type];
      const reqData = {
        id: id
      };
      await api.post("/delete", reqData);
      dispatch("setCurrentData", type);
    },
    async setCurrentData({ state }, key) {
      const api = state.apis[key];
      const res = await api.get("/all");
      state.currentData[key] = [];
      for (const item of res.data) {
        item.updatable = false;
        state.currentData[key].push(item);
      }
    },
    async resetCurrentData({ state, dispatch }) {
      for (var key in state.currentData) {
        dispatch("setCurrentData", key);
      }
    }
  }
  //   modules: {}
});
