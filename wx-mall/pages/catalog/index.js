//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    categoryList: [],
    currentCategory: {},
    currentSubCategoryList: {},
    goodsCount: 0
  },
  onLoad: function() {
    this.getList();
  },
  getList: function() {
    this.setData({
      categoryList: [{
        id: 1,
        name: '电子'
      }, {
        id: 2,
        name: '计算机'
      }, {
        id: 3,
        name: '电子'
      }, {
        id: 4,
        name: '计算机'
      }],
      currentCategory: {
        id: 1,
        name: '电子'
      },
      currentSubCategoryList: {
        id: 1,
        name: '电子',
        picUrl: ''
      }
    });
  },
  switchCate: function(event) {
    var that = this;
    var currentTarget = event.currentTarget;
    if (this.data.currentCategory.id == event.currentTarget.dataset.id) {
      return false;
    }

    this.setData({
      currentCategory: {
        id: event.currentTarget.dataset.id,
        name: '计算机'
      },
      currentSubCategoryList: {
        id: 1,
        name: '电子',
        picUrl: ''
      }
    });
  }
})