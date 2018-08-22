const util = require('../../../utils/util.js')
const api = require('../../../config/api.js')
//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    collectList: []
  },
  onLoad: function() {
    var that = this;
    util.request(api.CollectUrl).then(function(res) {
      that.setData({
        collectList: res.data
      });
    });
  }
})