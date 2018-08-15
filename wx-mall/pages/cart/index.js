//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    hasLogin: false,
    cartGoods: [],
    cartTotal: {
      "goodsCount": 0,
      "goodsAmount": 0.00,
      "checkedGoodsCount": 0,
      "checkedGoodsAmount": 0.00
    }
  },
  onLoad: function() {
    this.setData({
      hasLogin: true,
      cartGoods: [{
        goodsName: 'goodsName1',
        number: 1,
        price: 100,
        picUrl: '',
        checked: true
      }, {
        goodsName: 'goodsName2',
        number: 1,
        price: 200,
        picUrl: '',
        checked: true
      }]
    });
  }
})