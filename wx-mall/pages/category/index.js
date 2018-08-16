//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    navList: [],
    goodsList: [],
    id: 0,
    currentCategory: {}
  },
  onLoad: function() {
    this.setData({
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
      }],
      currentCategory: {
        id: 1,
        name: '居家'
      }
    });
  }
})