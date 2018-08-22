const util = require('../../utils/util.js')
const api = require('../../config/api.js')
//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    navList: [],
    goodsList: [],
    id: 0,
    currentCategory: {},
    scrollLeft: 0,
    scrollTop: 0,
    scrollHeight: 0
  },
  onLoad: function(options) {
    var that = this;
    if (options.id) {
      that.setData({
        id: parseInt(options.id)
      });
    }

    wx.getSystemInfo({
      success: function(res) {
        that.setData({
          scrollHeight: res.windowHeight
        });
      }
    });
    that.getCategory();
  },
  getCategory: function() {
    var that = this;
    util.request(api.CategoryUrl + '/' + that.data.id).then(function(res) {
      that.setData({
        navList: res.data.brotherCategory,
        currentCategory: res.data.currentCategory,
        id: res.data.currentCategory.id
      });
      //nav位置
      let currentIndex = 0;
      let navListCount = that.data.navList.length;
      for (let i = 0; i < navListCount; i++) {
        currentIndex += 1;
        if (that.data.navList[i].id == that.data.id) {
          break;
        }
      }
      if (currentIndex > navListCount / 2 && navListCount > 5) {
        that.setData({
          scrollLeft: currentIndex * 60
        });
      }
      that.getProductList();
    });
  },
  getProductList: function() {
    var that = this;
    util.request(api.ProductUrl + '/' + that.data.id).then(function(res) {
      that.setData({
        goodsList: res.data
      });
    });
  },
  switchCate: function(event) {
    if (this.data.id == event.currentTarget.dataset.id) {
      return false;
    }
    var that = this;
    var clientX = event.detail.x;
    var currentTarget = event.currentTarget;
    if (clientX < 60) {
      that.setData({
        scrollLeft: currentTarget.offsetLeft - 60
      });
    } else if (clientX > 330) {
      that.setData({
        scrollLeft: currentTarget.offsetLeft
      });
    }
    that.setData({
      id: event.currentTarget.dataset.id
    });

    that.getCategory();
  }
})