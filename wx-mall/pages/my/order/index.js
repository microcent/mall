//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    orderList: [],
    showType: 0
  },
  onLoad: function() {
    this.setData({
      orderList: [{
        id: 1,
        orderSn: '123456',
        orderStatusText: '状态',
        actualPrice: 100,
        goodsList: [{
          id: 1,
          goodsName: 'goods1',
          number: 1,
          picUrl: ''
        }, {
          id: 2,
          goodsName: 'goods2',
          number: 3,
          picUrl: ''
        }]
      }]
    });
  }
})