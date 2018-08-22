const util = require('../../../utils/util.js')
const api = require('../../../config/api.js')
//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    addressList: [],
  },
  onLoad: function() {
    var that = this;
    util.request(api.AddressUrl).then(function(res) {
      that.setData({
        addressList: res.data
      });
    });
  },
  addressAddOrUpdate: function() {
    wx.navigateTo({
      url: '/pages/my/address/add/index'
    });
  }
})