const util = require('../../utils/util.js');
const api = require('../../config/api.js');
//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    hasLogin: false,
    carts: [],
    cartTotal: {
      "productCount": 0,
      "productAmount": 0.00,
      "checkedProductCount": 0,
      "checkedProductAmount": 0.00
    },
    isEditCart: false,
    checkedAllStatus: true,
    editCartList: []
  },
  onLoad: function() {

  },
  onPullDownRefresh: function() {
    wx.showNavigationBarLoading()
    wx.hideNavigationBarLoading()
    wx.stopPullDownRefresh()
  },
  onShow: function() {
    var that = this;
    util.request(api.CartUrl).then(function(res) {
      that.setData({
        hasLogin: true,
        carts: res.data.carts,
        cartTotal: res.data.cartTotal
      });
    });
  },
  isCheckedAll: function() {
    //判断购物车商品已全选
    return this.data.carts.every(function(element, index, array) {
      if (element.checked == true) {
        return true;
      } else {
        return false;
      }
    });
  },
  doCheckedAll: function() {
    let checkedAll = this.isCheckedAll()
    this.setData({
      checkedAllStatus: this.isCheckedAll()
    });
  },
  checkedItem: function(event) {
    let itemIndex = event.target.dataset.itemIndex;
    let that = this;

    let productIds = [];
    productIds.push(that.data.carts[itemIndex].productId);
    if (!this.data.isEditCart) {
      util.request(api.CartCheckedUrl, {
        productIds: productIds,
        isChecked: that.data.carts[itemIndex].isChecked ? 0 : 1
      }, 'POST').then(function(res) {
        if (res.code === 0) {
          that.setData({
            carts: res.data.carts,
            cartTotal: res.data.cartTotal
          });
        }

        that.setData({
          checkedAllStatus: that.isCheckedAll()
        });
      });
    } else {
      //编辑状态
      let tmpCartData = this.data.carts.map(function(element, index, array) {
        if (index == itemIndex) {
          element.checked = !element.checked;
        }

        return element;
      });

      that.setData({
        carts: tmpCartData,
        checkedAllStatus: that.isCheckedAll(),
        'cartTotal.checkedProductCount': that.getCheckedProductCount()
      });
    }
  },
  getCheckedProductCount: function() {
    let checkedProductCount = 0;
    this.data.carts.forEach(function(v) {
      if (v.checked === true) {
        checkedProductCount += v.number;
      }
    });
    return checkedProductCount;
  },
  checkedAll: function() {
    let that = this;

    if (!this.data.isEditCart) {
      var productIds = this.data.carts.map(function(v) {
        return v.productId;
      });
      that.setData({
        checkedAllStatus: that.isCheckedAll()
      });
    } else {
      //编辑状态
      let checkedAllStatus = that.isCheckedAll();
      let tmpCartData = this.data.carts.map(function(v) {
        v.checked = !checkedAllStatus;
        return v;
      });

      that.setData({
        carts: tmpCartData,
        checkedAllStatus: that.isCheckedAll(),
        'cartTotal.checkedProductCount': that.getCheckedProductCount()
      });
    }
  },
  editCart: function() {
    var that = this;
    if (this.data.isEditCart) {
      this.setData({
        isEditCart: !this.data.isEditCart
      });
    } else {
      //编辑状态
      let tmpCartList = this.data.carts.map(function(v) {
        v.checked = false;
        return v;
      });
      this.setData({
        editCartList: this.data.carts,
        carts: tmpCartList,
        isEditCart: !this.data.isEditCart,
        checkedAllStatus: that.isCheckedAll(),
        'cartTotal.checkedProductCount': that.getCheckedProductCount()
      });
    }
  }
})