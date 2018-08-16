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
          goodsName: '澳洲纯羊毛盖毯 加厚款',
          number: 1,
          picUrl: 'http://yanxuan.nosdn.127.net/3bec70b85337c3eec182e54380ef7370.png'
        }, {
          id: 2,
          goodsName: '澳洲纯羊毛盖毯 舒适款',
          number: 3,
          picUrl: 'http://yanxuan.nosdn.127.net/a8b0a5def7d64e411dd98bdfb1fc989b.png'
        }]
      }]
    });
  }
})