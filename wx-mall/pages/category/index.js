//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    navList: [],
    goodsList: [],
    id: 0,
    currentCategory: {}
  },
  onLoad: function() {
    this.setData({
      navList: [{
        id: 1,
        name: 'nav1'
      }, {
        id: 2,
        name: 'nav2'
      }, {
        id: 3,
        name: 'nav3'
      }],
      goodsList: [{
        id: 1,
        name: 'goods1',
        picUrl: '',
        retailPrice: 100
      }, {
        id: 2,
        name: 'goods2',
        picUrl: '',
        retailPrice: 200
      }, {
        id: 3,
        name: 'goods3',
        picUrl: '',
        retailPrice: 300
      }],
      currentCategory: {
        id: 1,
        name: '电子'
      }
    });
  }
})