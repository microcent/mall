//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    newGoods: [],
    hotGoods: [],
    topics: [],
    brands: [],
    groupons: [],
    floorGoods: [],
    banner: [],
    channel: []
  },
  onLoad: function() {
    this.setData({
      brands: [{
        id: 1,
        name: 'brand1',
        floorPrice: 10,
        picUrl: ''
      }],
      newGoods: [{
        id: 1,
        name: 'goods1',
        retailPrice: 100,
        picUrl: ''
      }, {
        id: 2,
        name: 'goods2',
        retailPrice: 100,
        picUrl: ''
      }, {
        id: 3,
        name: 'goods3',
        retailPrice: 100,
        picUrl: ''
      }],
      hotGoods: [{
        id: 1,
        name: 'goods1',
        brief: 'goods1',
        retailPrice: 100,
        picUrl: ''
      }, {
        id: 2,
        name: 'goods2',
        brief: 'goods2',
        retailPrice: 100,
        picUrl: ''
      }, {
        id: 3,
        name: 'goods3',
        brief: 'goods3',
        retailPrice: 100,
        picUrl: ''
      }],
      topics: [{
        id: 1,
        title: 'goods1',
        subtitle: 'goods1',
        price: 100,
        picUrl: ''
      }, {
        id: 2,
        title: 'goods2',
        subtitle: 'goods2',
        price: 100,
        picUrl: ''
      }, {
        id: 3,
        title: 'goods3',
        subtitle: 'goods3',
        price: 100,
        picUrl: ''
      }],
      floorGoods: [{
        id: 1,
        name: 'floor1',
        goodsList: [{
          id: 1,
          name: 'goods1',
          retailPrice: 100,
          picUrl: ''
        }, {
          id: 2,
          name: 'goods2',
          retailPrice: 100,
          picUrl: ''
        }, {
          id: 3,
          name: 'goods3',
          retailPrice: 100,
          picUrl: ''
        }]
      }]
    });
  }
})