//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    userInfo: {
      nickName: '点击登录',
      avatarUrl: 'http://yanxuan.nosdn.127.net/8945ae63d940cc42406c3f67019c5cb6.png'
    }
  },
  onLoad: function() {

  },
  onShow: function() {
    var that = this;
    //获取用户的登录信息
    if (app.globalData.hasLogin) {
      wx.getUserInfo({
        success: res => {
          // 可以将 res 发送给后台解码出 unionId
          that.setData({
            userInfo: res.userInfo
          });
        }
      })
      // let userInfo = wx.getStorageSync('userInfo');
      // this.setData({
      //   userInfo: userInfo,
      // });
    }
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