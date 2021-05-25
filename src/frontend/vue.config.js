const path = require("path");

module.exports = {
  outputDir: path.resolve(__dirname, "./build"),

  devServer: {
    overlay: false,
    proxy: {
      "/api": {
        target: process.env.VUE_APP_ADMIN_API_URL,
        ws: true,
        changeOrigin: true
      }
    }
  },
  transpileDependencies: ["vuetify"]
};
