//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    id: 0,
    goods: {},
    groupon: [], //该商品支持的团购规格
    grouponLink: {}, //参与的团购
    attribute: [],
    issueList: [],
    comment: [],
    brand: {},
    specificationList: [],
    productList: [],
    relatedGoods: [],
    cartGoodsCount: 0,
    userHasCollect: 0,
    number: 1,
    checkedSpecText: '规格数量选择',
    tmpSpecText: '请选择规格数量',
    checkedSpecPrice: 0,
    openAttr: false,
    noCollectImage: '/static/images/icon_collect.png',
    hasCollectImage: '/static/images/icon_collect_checked.png',
    collectImage: '/static/images/icon_collect.png',
    shareImage: '',
    isGroupon: false, //标识是否是一个参团购买
    soldout: false
  },
  onLoad: function() {
    this.setData({
      goods: {
        id: 1,
        name: '埃及进口长绒棉毛巾',
        goodsBrief: '厚实舒适',
        counterPrice: 39,
        picUrl: 'http://yanxuan.nosdn.127.net/7191f2599c7fe44ed4cff7a76e853154.png',
        gallery: ["http://yanxuan.nosdn.127.net/96c20e15c503ff5e358a150148f2f352.jpg", "http://yanxuan.nosdn.127.net/96c20e15c503ff5e358a150148f2f352.jpg", "http://yanxuan.nosdn.127.net/96c20e15c503ff5e358a150148f2f352.jpg", "http://yanxuan.nosdn.127.net/96c20e15c503ff5e358a150148f2f352.jpg", "http://yanxuan.nosdn.127.net/96c20e15c503ff5e358a150148f2f352.jpg"]
      },
      attribute: [{
        attribute: '材质',
        value: '100%棉'
      }, {
        attribute: '适用床尺寸',
        value: '1.5米+1.8米通用'
      }],
      issueList: [{
        question: '购买运费如何收取？',
        answer: '单笔订单金额（不含运费）满88元免邮费；不满88元，每单收取10元运费。(港澳台地区需满'
      }, {
        question: '使用什么快递发货？',
        answer: '严选默认使用顺丰快递发货（个别商品使用其他快递），配送范围覆盖全国大部分地区（港澳台地区除'
      }, {
        question: '如何申请退货？',
        answer: '1.自收到商品之日起30日内，顾客可申请无忧退货，退款将原路返还，不同的银行处理时间不同，'
      }]
    });
  }
})