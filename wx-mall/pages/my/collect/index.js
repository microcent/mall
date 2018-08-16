//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    collectList: []
  },
  onLoad: function() {
    this.setData({
      collectList: [{
        id: 1,
        name: '色织精梳AB纱格纹空调被',
        brief: '加大加厚，双色精彩',
        retailPrice: 199,
        picUrl: 'http://yanxuan.nosdn.127.net/0984c9388a2c3fd2335779da904be393.png'
      }, {
        id: 2,
        name: '典雅美式全棉刺绣抱枕',
        brief: '典雅毛线绣，精致工艺',
        retailPrice: 59,
        picUrl: 'http://yanxuan.nosdn.127.net/a2045004de8a6225289376ad54317fc8.png'
      }, {
        id: 3,
        name: '升级款护颈波浪记忆枕',
        brief: '享受自在侧睡',
        retailPrice: 99,
        picUrl: 'http://yanxuan.nosdn.127.net/77c09feb378814be712741b273d16656.png'
      }]
    });
  }
})