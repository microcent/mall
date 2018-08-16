//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    footprintList: []
  },
  onLoad: function() {
    this.setData({
      footprintList: [
        [{
          id: 1,
          name: '升级款护颈加翼记忆枕',
          brief: '仰睡优质装备',
          retailPrice: 109,
          picUrl: 'http://yanxuan.nosdn.127.net/7644803ab19b3e398456aa5a54229363.png',
          addTime: '2018-08-16 00:00'
        }, {
          id: 2,
          name: '升级款护颈双人记忆枕',
          brief: '共享亲密2人时光',
          retailPrice: 199,
          picUrl: 'http://yanxuan.nosdn.127.net/0118039f7cda342651595d994ed09567.png',
          addTime: '2018-08-16 00:00'
        }, {
          id: 3,
          name: '植物填充护颈夜交藤枕',
          brief: '健康保护枕',
          retailPrice: 99,
          picUrl: 'http://yanxuan.nosdn.127.net/60c3707837c97a21715ecc3986a744ce.png',
          addTime: '2018-08-16 00:00'
        }]
      ]
    });
  }
})