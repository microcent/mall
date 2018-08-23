const util = require('../../../utils/util.js')
const api = require('../../../config/api.js')
//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    valueId: 0,
    topic: {},
    content: '',
    stars: [0, 1, 2, 3, 4],
    star: 5,
    starText: '十分满意',
    hasPicture: false,
    picUrls: [],
    files: []
  },
  onLoad: function(options) {
    
  }
})