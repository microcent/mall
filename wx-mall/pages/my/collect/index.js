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
        name: '收藏1',
        brief: 'Brief1',
        retailPrice: 100,
        picUrl: ''
      }, {
        id: 2,
        name: '收藏2',
        brief: 'Brief2',
        retailPrice: 100,
        picUrl: ''
      }]
    });
  }
})