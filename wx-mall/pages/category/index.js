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

    console.log('id:'+that.data.id);

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
    that.setData({
      navList: [{
        id: 1,
        name: '布艺软装'
      }, {
        id: 2,
        name: '被枕'
      }, {
        id: 3,
        name: '床品件套'
      }, {
        id: 4,
        name: '灯具'
      }, {
        id: 5,
        name: '地垫'
      }],
      currentCategory: {
        id: 1,
        name: '居家'
      }
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
    that.getGoods();
  },
  getGoods: function() {
    var that = this;
    that.setData({
      goodsList: [{
        id: 1,
        name: '全棉进口埃及长绒棉浴巾',
        picUrl: 'http://yanxuan.nosdn.127.net/fd5a8622ee1a7dfd4b57b938ebf25b24.png',
        retailPrice: 99
      }, {
        id: 2,
        name: '澳洲羊羔毛AB面盖毯',
        picUrl: 'http://yanxuan.nosdn.127.net/654b02045fde802b51d5bbf09a8b75f2.png',
        retailPrice: 299
      }, {
        id: 3,
        name: '色织水洗棉纯色四件套',
        picUrl: 'http://yanxuan.nosdn.127.net/25d734cc0b2eae8f63f9deb1e4ad5f64.png',
        retailPrice: 299
      }]
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