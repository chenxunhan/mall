/**
 
 @Name: 家居商城模板
 @Author: star1029
 @Copyright: layui.com
 */


layui.define(['element', 'carousel', 'table', 'util'], function(exports){
  var $ = layui.$
  ,element = layui.element
  ,form = layui.form
  ,carousel = layui.carousel
  ,laypage = layui.laypage
  ,util = layui.util
  ,table = layui.table;

  //初始化
  var houseNav = $(".house-header").find(".layui-nav");
  
  $(function(){
    //详情页——选中
    var ddDetail = $(".house-detail").find(".shopChoose").find("dl").children("dd");
    ddDetail.each(function(){
      if($(this).hasClass("active")){
        $(this).append('<i class="layui-icon layui-icon-ok active"></i>');
      };
    });
    //详情页——数量
    $(".house-detail").find(".shopChoose").find(".btn-input").children("input").val("1");
  });
  
  //轮播
  var elemBanner = $('#house-carousel'), ins1 = carousel.render({
    elem: elemBanner
    ,width: '100%'
    ,height: elemBanner.height() + 'px'
    ,arrow: 'none' 
    ,interval: 5000
  });
  $(window).on('resize', function(){
    var width = $(this).prop('innerWidth');
    ins1.reload({
      height: (width > 768 ? 500 : 150) + 'px'
    });
  });
  
  //首页——搜索
  $(".house-header").find("#search").on('click', function(){
    layer.open({
      type: 1
      ,title: false
      ,shadeClose: true
      ,area: '300px'
      ,content: '<div id="house-search" class="layui-form"><input type="text" placeholder="搜索好物" class="layui-input"></div>'
      ,success: function(layero, index){
        $("#house-search").find("input").on('keydown', function(e){
          if(e.keyCode === 13){
            e.preventDefault();       
            layer.close(index);
          };
        });
      }
    });
  });
  
  //首页——点击切换
  $(".house-header").find("#switch").on('click', function(){
    if(houseNav.hasClass("close")){
      $(".house-header").children(".layui-container")[0].style.height = 60 + houseNav[0].offsetHeight + 'px';
      houseNav.removeClass("close");
    }else{
      $(".house-header").children(".layui-container")[0].style.height = 50 + 'px';
      houseNav.addClass("close");
    }
  });
  
  //登入页——弹框
  $("#house-login").find(".getCode").children("button").on('click', function(){

    var phone = $("#phone").val();
    if(phone==""){
      layer.msg('验证码不能为空');
      return false;
    }

    //发送验证码
    $.post("/mall/sendVerifyCode.do?phone=19876850907",{phone:phone},function (response) {
      console.log(response);
      if(response.Code==="OK"){
        layer.msg('验证码发送成功');
      }
    })


  });
  form.on('submit(user-login)', function(data){
    ///mall/login.do?phone=13221321321&verifyCode=4887

    var phone = $("#phone").val();
    var verifyCode = $("#verifyCode").val();
    $.post("/mall/login.do",{phone:phone,verifyCode:verifyCode},function (response) {
      console.log(response);

      if(response.code ==200){
        //将当前手机号写入到浏览器的cookie中
        setCookie("phone",phone,3);
        //并且跳转到首页
      }else{
        //弹出错误提示消息，验证码错误
        layer.msg(response.msg);
      }
    })





  });

  
  exports('house', {}); 
})

/**
 * 设置数据到cookie
 * @param cname 名称
 * @param cvalue 值
 * @param exdays 过期时间 天
 */
function setCookie(cname,cvalue,exdays)
{
  var d = new Date();
  d.setTime(d.getTime()+(exdays*24*60*60*1000));
  var expires = "expires="+d.toGMTString();
  document.cookie = cname + "=" + cvalue + "; " + expires;
}