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
          brands: res.data.brands,
          newGoods: res.data.news,
          hotGoods: res.data.hots,
          topics:res.data.topics,
          floorGoods:res.data.floors
        });
      }
    });
    this.setData({
      groupons: [{
        groupon_price: 59,
        groupon_member: 99,
        goods: {
          id: 1,
          name: '100年传世珐琅锅 全家系列',
          counterPrice: 398,
          picUrl: 'http://yanxuan.nosdn.127.net/c39d54c06a71b4b61b6092a0d31f2335.png'
        }
      }, {
        groupon_price: 99,
        groupon_member: 99,
        goods: {
          id: 1,
          name: '色织华夫格夏凉被',
          counterPrice: 299,
          picUrl: 'http://yanxuan.nosdn.127.net/07376e78bf4fb8a5aa8e6a0b1437c3ad.png'
        }
      }]
    });
  }
})