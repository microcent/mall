//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    userInfo: {}
  },
  onLoad: function() {

  },
  onShow: function() {
    var that = this;
    let userInfo = wx.getStorageSync('userInfo');
    let token = wx.getStorageSync('token');

    // 页面显示
    if (userInfo && token) {
      app.globalData.userInfo = userInfo;
      app.globalData.token = token;
    }
    
    this.setData({
      userInfo: app.globalData.userInfo,
    });
  },
  goLogin() {
    if (!app.globalData.hasLogin) {
      wx.navigateTo({
        url: "/pages/auth/login/index"
      });
    }
  },
  goOrder: function() {
    wx.navigateTo({
      url: '/pages/my/order/index'
    });
  },
  goFootprint: function() {
    wx.navigateTo({
      url: '/pages/my/footprint/index'
    });
  },
  goAddress: function() {
    wx.navigateTo({
      url: '/pages/my/address/index'
    });
  },
  goCollect: function() {
    wx.navigateTo({
      url: '/pages/my/collect/index'
    });
  },
  aboutUs: function() {
    wx.navigateTo({
      url: '/pages/about/index'
    });
  }
})