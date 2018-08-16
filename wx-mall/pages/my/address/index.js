//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    addressList: [],
  },
  onLoad: function() {
    this.setData({
      addressList: [{
        id: 1,
        name: '陈开慧',
        mobile: '13510627353',
        detailedAddress: '广东省深圳市龙岗区布吉街道龙珠花园B区6栋2A'
      }, {
        id: 2,
        name: '田兴文',
        mobile: '18617333732',
        detailedAddress: '广东省深圳市罗湖区鸿隆世纪广场B座11E'
      }]
    });
  },
  addressAddOrUpdate: function() {
    wx.navigateTo({
      url: '/pages/my/address/add/index'
    });
  }
})