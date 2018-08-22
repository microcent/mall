const util = require('../../../utils/util.js')
const api = require('../../../config/api.js')
//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    orderList: [],
    showType: 0
  },
  onLoad: function() {
    this.getOrders();
  },
  getOrders: function() {
    var that = this;
    util.request(api.OrderUrl, {
      showType: that.data.showType
    }).then(function(res) {
      that.setData({
        orderList: res.data
      });
    });
  },
  switchTab: function(event) {
    let showType = event.currentTarget.dataset.index;
    this.setData({
      showType: showType
    });
    this.getOrders();
  },
})