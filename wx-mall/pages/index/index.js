//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    newGoods: [],
    hotGoods: [],
    topics: [],
    brands: [],
    groupons: [],
    floorGoods: [],
    banner: [],
    channel: []
  },
  onLoad: function() {
    this.setData({
      banner: [{
        url: 'http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png'
      }, {
        url: 'http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png'
      }],
      channel: [{
        name: '居家',
        iconUrl: 'http://yanxuan.nosdn.127.net/a45c2c262a476fea0b9fc684fed91ef5.png'
      }, {
        name: '餐厨',
        iconUrl: 'http://yanxuan.nosdn.127.net/ad8b00d084cb7d0958998edb5fee9c0a.png'
      }, {
        name: '饮食',
        iconUrl: 'http://yanxuan.nosdn.127.net/c9280327a3fd2374c000f6bf52dff6eb.png'
      }, {
        name: '配件',
        iconUrl: 'http://yanxuan.nosdn.127.net/11abb11c4cfdee59abfb6d16caca4c6a.png'
      }, {
        name: '服装',
        iconUrl: 'http://yanxuan.nosdn.127.net/28a685c96f91584e7e4876f1397767db.png'
      }],
      groupons: [{
        groupon_price: 59,
        groupon_member: 99,
        goods: {
          id: 1,
          name: '100年传世珐琅锅 全家系列',
          counterPrice: 398,
          picUrl: 'http://yanxuan.nosdn.127.net/c39d54c06a71b4b61b6092a0d31f2335.png'
        }
      }, {
        groupon_price: 99,
        groupon_member: 99,
        goods: {
          id: 1,
          name: '色织华夫格夏凉被',
          counterPrice: 299,
          picUrl: 'http://yanxuan.nosdn.127.net/07376e78bf4fb8a5aa8e6a0b1437c3ad.png'
        }
      }],
      brands: [{
        id: 1,
        name: 'MUJI制造商',
        floorPrice: 12.9,
        picUrl: 'http://yanxuan.nosdn.127.net/1541445967645114dd75f6b0edc4762d.png'
      }, {
        id: 2,
        name: 'Adidas制造商',
        floorPrice: 49,
        picUrl: 'http://yanxuan.nosdn.127.net/335334d0deaff6dc3376334822ab3a2f.png'
      }, {
        id: 3,
        name: '内野制造商',
        floorPrice: 29,
        picUrl: 'http://yanxuan.nosdn.127.net/8ca3ce091504f8aa1fba3fdbb7a6e351.png'
      }],
      newGoods: [{
        id: 1,
        name: '轻奢纯棉刺绣水洗四件套',
        retailPrice: 899,
        picUrl: 'http://yanxuan.nosdn.127.net/8ab2d3287af0cefa2cc539e40600621d.png'
      }, {
        id: 2,
        name: '秋冬保暖加厚澳洲羊毛被',
        retailPrice: 459,
        picUrl: 'http://yanxuan.nosdn.127.net/66425d1ed50b3968fed27c822fdd32e0.png'
      }],
      hotGoods: [{
        id: 1,
        name: '双宫茧桑蚕丝被 空调被',
        brief: '一级桑蚕丝，吸湿透气柔软',
        retailPrice: 699,
        picUrl: 'http://yanxuan.nosdn.127.net/583812520c68ca7995b6fac4c67ae2c7.png'
      }, {
        id: 2,
        name: '双宫茧桑蚕丝被 子母被',
        brief: '双层子母被，四季皆可使用',
        retailPrice: 1399,
        picUrl: 'http://yanxuan.nosdn.127.net/2b537159f0f789034bf8c4b339c43750.png'
      }, {
        id: 3,
        name: '秋冬保暖加厚细羊毛被',
        brief: '细腻绵羊毛，保暖性增加一倍',
        retailPrice: 659,
        picUrl: 'http://yanxuan.nosdn.127.net/8fe022126a2789d970f82853be13a5e6.png'
      }],
      topics: [{
        id: 1,
        title: '设计师们推荐的应季好物',
        subtitle: '原创设计春款系列上新',
        price: 29.9,
        picUrl: 'https://yanxuan.nosdn.127.net/14918201901050274.jpg'
      }, {
        id: 2,
        title: '一条丝巾就能提升时髦度',
        subtitle: '不知道大家对去年G20时，严选与国礼制造商一起推出的《凤凰于飞》等几款丝巾是否还...',
        price: 0,
        picUrl: 'https://yanxuan.nosdn.127.net/14919007135160213.jpg'
      }],
      floorGoods: [{
        id: 1,
        name: '布艺软装',
        goodsList: [{
          id: 1,
          name: '可水洗抗菌防螨丝羽绒枕',
          retailPrice: 99,
          picUrl: 'http://yanxuan.nosdn.127.net/da56fda947d0f430d5f4cf4aba14e679.png'
        }, {
          id: 2,
          name: '白鹅绒秋冬加厚羽绒被',
          retailPrice: 1999,
          picUrl: 'http://yanxuan.nosdn.127.net/9791006f25e26b2d7c81f41f87ce8619.png'
        }, {
          id: 3,
          name: '可水洗舒柔丝羽绒枕',
          retailPrice: 59,
          picUrl: 'http://yanxuan.nosdn.127.net/a196b367f23ccfd8205b6da647c62b84.png'
        }]
      }]
    });
  }
})