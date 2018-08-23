const util = require('../../utils/util.js');
const api = require('../../config/api.js');
//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    newGoods: [],
    hotGoods: [],
    topics: [],
    brands: [],
    groupons: [],
    floorGoods: [],
    banner: [],
    channel: []
  },
  onLoad: function() {
    var that = this;
    util.request(api.IndexUrl).then(function(res) {
      if (res.code === 0) {
        that.setData({
          banner: res.data.banners,
          channel: res.data.channels,
          groupons:res.data.groupons,
          brands: res.data.brands,
          newGoods: res.data.news,
          hotGoods: res.data.hots,
          topics:res.data.topics,
          floorGoods:res.data.floors
        });
      }
    });
  }
})