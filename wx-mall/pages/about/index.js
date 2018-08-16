//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    shopInfo: {
      name: 'mall',
      address: 'https://github.com/microcent/mall',
      latitude: 31.201900,
      longitude: 121.587839,
      linkPhone: '18617333732',
      qqNumber: '64432145'
    }
  },
  onLoad: function() {

  },
  showLocation: function(e) {
    var that = this
    wx.openLocation({
      latitude: that.data.shopInfo.latitude,
      longitude: that.data.shopInfo.longitude,
      name: that.data.shopInfo.name,
      address: that.data.shopInfo.address,
    })
  },
  callPhone: function(e) {
    var that = this
    wx.makePhoneCall({
      phoneNumber: that.data.shopInfo.linkPhone,
    })
  }
})