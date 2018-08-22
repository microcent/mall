const util = require('../../utils/util.js')
const api = require('../../config/api.js')
//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    categoryList: [],
    currentCategory: {},
    currentSubCategoryList: {},
    productCount: 0
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
    var that = this;
    wx.showLoading({
      title: '加载中...',
    });
    util.request(api.CatalogUrl).then(function(res) {
      that.setData({
        categoryList: res.data.categories,
        currentCategory: res.data.currentCategory,
        currentSubCategoryList: res.data.currentSubCategory
      });
    });
    util.request(api.ProductCountUrl).then(function(res) {
      that.setData({
        productCount: res.data
      });
    });
    wx.hideLoading();
  },
  getCategory: function(id) {
    var that = this;
    util.request(api.CurrentCatalogUrl + '/' + id).then(function(res) {
      that.setData({
        currentCategory: res.data.currentCategory,
        currentSubCategoryList: res.data.currentSubCategory
      });
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