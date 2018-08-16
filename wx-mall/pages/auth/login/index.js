//index.js
//获取应用实例
const app = getApp()

Page({
  data: {

  },
  onLoad: function() {

  },
  wxLogin: function(e) {
    console.log(e);
    if (e.detail.userInfo == undefined) {
      app.globalData.hasLogin = false;
      util.showErrorToast('微信登录失败');
      return;
    }

    // user.checkLogin().catch(() => {

    //   user.loginByWeixin(e.detail.userInfo).then(res => {
    //     app.globalData.hasLogin = true;

    //     wx.navigateBack({
    //       delta: 1
    //     })
    //   }).catch((err) => {
    //     app.globalData.hasLogin = false;
    //     util.showErrorToast('微信登录失败');
    //   });

    // });
  },
  accountLogin: function() {
    wx.navigateTo({
      url: "/pages/auth/login/account/index"
    });
  }
})