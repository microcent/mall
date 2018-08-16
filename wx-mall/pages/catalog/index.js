//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    categoryList: [],
    currentCategory: {},
    currentSubCategoryList: {},
    goodsCount: 0,
  },
  onLoad: function() {
    var that = this;
    that.getCategoryList();
  },
  onPullDownRefresh() {
    wx.showNavigationBarLoading() //在标题栏中显示加载
    this.getCategoryList();
    wx.hideNavigationBarLoading() //完成停止加载
    wx.stopPullDownRefresh() //停止下拉刷新
  },
  getCategoryList: function() {
    wx.showLoading({
      title: '加载中...',
    });
    this.setData({
      categoryList: [{
        id: 1,
        name: '居家'
      }, {
        id: 2,
        name: '餐厨'
      }, {
        id: 3,
        name: '饮食'
      }, {
        id: 4,
        name: '配件'
      }],
      currentCategory: {
        id: 1,
        name: '居家',
        frontName: '回家，放松身心',
        picUrl: 'http://yanxuan.nosdn.127.net/e8bf0cf08cf7eda21606ab191762e35c.png'
      },
      currentSubCategoryList: [{
        id: 1,
        name: '布艺软装',
        picUrl: 'http://yanxuan.nosdn.127.net/2e2fb4f2856a021bbcd1b4c8400f2b06.png'
      }, {
        id: 2,
        name: '被枕',
        picUrl: 'http://yanxuan.nosdn.127.net/2e2fb4f2856a021bbcd1b4c8400f2b06.png'
      }, {
        id: 3,
        name: '床品件套',
        picUrl: 'http://yanxuan.nosdn.127.net/81f671bd36bce05d5f57827e5c88dd1b.png'
      }, {
        id: 4,
        name: '灯具',
        picUrl: 'http://yanxuan.nosdn.127.net/f702dc399d14d4e1509d5ed6e57acd19.png'
      }, {
        id: 5,
        name: '地垫',
        picUrl: 'http://yanxuan.nosdn.127.net/1611ef6458e244d1909218becfe87c4d.png'
      }],
      goodsCount: 100
    });

    wx.hideLoading();
  },
  getCategory: function(id) {
    this.setData({
      currentCategory: {
        id: id,
        name: '居家',
        frontName: '回家，放松身心',
        picUrl: 'http://yanxuan.nosdn.127.net/e8bf0cf08cf7eda21606ab191762e35c.png'
      },
      currentSubCategoryList: [{
        id: 1,
        name: '布艺软装',
        picUrl: 'http://yanxuan.nosdn.127.net/2e2fb4f2856a021bbcd1b4c8400f2b06.png'
      }, {
        id: 2,
        name: '被枕',
        picUrl: 'http://yanxuan.nosdn.127.net/2e2fb4f2856a021bbcd1b4c8400f2b06.png'
      }]
    });
  },
  switchCate: function(event) {
    var that = this;
    var currentTarget = event.currentTarget;
    if (this.data.currentCategory.id == event.currentTarget.dataset.id) {
      return false;
    }

    that.getCategory(event.currentTarget.dataset.id);
  }
})