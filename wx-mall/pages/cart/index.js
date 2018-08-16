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
        goodsName: '日式和风懒人沙发',
        number: 1,
        price: 599,
        picUrl: 'http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png',
        checked: true
      }, {
        goodsName: '皇室御用超柔毛巾80s',
        number: 1,
        price: 79,
        picUrl: 'http://yanxuan.nosdn.127.net/71cfd849335c498dee3c54d1eb823c17.png',
        checked: false
      }]
    });
  }
})