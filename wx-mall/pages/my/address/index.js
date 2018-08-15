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
        name: '张三',
        mobile: '13510627353',
        detailedAddress: '广东省深圳市龙岗区布吉街道龙珠花园'
      }, {
        id: 2,
        name: '李四',
        mobile: '13510627353',
        detailedAddress: '广东省深圳市龙岗区布吉街道龙珠花园'
      }]
    });
  }
})