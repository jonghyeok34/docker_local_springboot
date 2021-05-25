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
export const mongoApi = createInstance("/mongo");
export const oracleApi = createInstance("/oracle");
export const mysqlApi = createInstance("/mysql");
