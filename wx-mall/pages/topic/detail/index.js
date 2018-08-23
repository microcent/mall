const util = require('../../../utils/util.js')
const api = require('../../../config/api.js')
var WxParse = require('../../../lib/wxParse/wxParse.js')
//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    id: 0,
    topic: {},
    topicList: [],
    commentCount: 0,
    commentList: []
  },
  onLoad: function(options) {
    // 页面初始化 options为页面跳转所带来的参数
    var that = this;
    that.setData({
      id: options.id
    });

    util.request(api.TopicDetailUrl + '/' + that.data.id).then(function(res) {
      that.setData({
        topic: res.data,
      });
      WxParse.wxParse('topicDetail', 'html', res.data.content, that);
    });

    util.request(api.TopicRelatedUrl + '/' + that.data.id).then(function(res) {
      that.setData({
        topicList: res.data
      });
    });
    that.getCommentList();
  },
  getCommentList() {
    let that = this;
    util.request(api.TopicCommentUrl+'/'+that.data.id).then(function(res) {
        that.setData({
          commentList: res.data,
          commentCount: res.data.length
        });
    });
  },
  postComment() {
    // if (!app.globalData.hasLogin) {
    //   wx.navigateTo({
    //     url: "/pages/auth/login/login"
    //   });
    // } else {
    wx.navigateTo({
      url: '/pages/topic/comment/index?valueId=' + this.data.id + '&type=1',
    })
    // }
  }
})