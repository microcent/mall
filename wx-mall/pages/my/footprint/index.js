const util = require('../../../utils/util.js')
const api = require('../../../config/api.js')
//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    footprintList: []
  },
  onLoad: function() {
    var that = this;
    util.request(api.BrowseLogUrl).then(function (res) {
      let f1 = that.data.footprintList;
      let f2 = res.data;
      for (let i = 0; i < f2.length; i++) {
        let last = f1.length - 1;
        if (last >= 0 && f1[last][0].createTime === f2[i].createTime) {
          f1[last].push(f2[i]);
        }
        else {
          let tmp = [];
          tmp.push(f2[i])
          f1.push(tmp);
        }
      }
      that.setData({
        footprintList: f1
      });
    });
  }
})