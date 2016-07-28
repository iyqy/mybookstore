<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>确认订单</title>
    <!--阻止浏览器缓存-->
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate">
    <meta http-equiv="expires" content="0">
    <!-- Basic Page Needs
     ================================================== -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="title" content="">
    <meta name="author" content="">
    <meta name="Copyright" content="">
    <!-- <meta name="description" content=""> -->
    <!-- 让IE浏览器用最高级内核渲染页面 还有用 Chrome 框架的页面用webkit 内核
    ================================================== -->
    <meta http-equiv="X-UA-Compatible" content="chrome=1,IE=edge">
    <!-- IOS6全屏 Chrome高版本全屏
    ================================================== -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="mobile-web-app-capable" content="yes">
    <!-- 让360双核浏览器用webkit内核渲染页面
    ================================================== -->
    <meta name="renderer" content="webkit">
    <!-- Mobile Specific Metas
    ================================================== -->
    <!-- !!!注意 minimal-ui 是IOS7.1的新属性，最小化浏览器UI -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- CSS
    ================================================== -->
    <link rel="stylesheet" href="css/main.css">
</head>
<body class="body-back-1">
<div class="tjAllHead">
    <div class="clearfix">
      <div class="title">问卷调查~~~<div>
    </div>
</div>
     <div class="wj" style=" overflow-y:scroll;  height:400px;  ">
<form class="mt-4 registerform" action="/survey/servlet/Serveyservlet" method="post">
1.你更关注食品的口味还是安全？<br>
     <input type="radio"  name="a" value="a1"/>口味
     &nbsp &nbsp
     <input type="radio" name="a" value="a2"/>安全
    <br><br>   




     2.你每次购买食品会查看日期吗？<br>
     <input type="radio"  name="b" value="b1"/>会
     &nbsp &nbsp &nbsp &nbsp
     <input type="radio" name="b" value="b2" />不会
    <br><br>   

     3.对一个新食品，你会有多注意其中的配料？<br>
     <input type="radio"  name="c" value="c1"/>每次都会先看看
     &nbsp
     <input type="radio" name="c" value="c2" />偶尔看看
     &nbsp
     <input type="radio" name="c" value="c3"/>从不看
    <br><br>                   

    4.你对一些 垃圾食品的态度是什么样的？<br>
     <input type="radio"  name="d" value="d1"/>经常吃没事
     &nbsp 
     <input type="radio" name="d" value="d2"/>偶尔吃没事
     &nbsp 
     <input type="radio" name="d" value="d3"/>不应该吃
    <br><br>                         
    
     5.你对速食食品购买的频率是：<br>
     <input type="radio"  name="e" value="e1"/>经常
     &nbsp &nbsp 
     <input type="radio" name="e" value="e2"/>有时
      &nbsp &nbsp 
     <input type="radio" name="e" value="e3"/>从不
    <br><br>   
                    
    6.明知某速食产品含有过多危害添加剂，你还会购买吗？<br>
     <input type="radio"  name="f" value="f1"/>是
     &nbsp &nbsp &nbsp &nbsp 
     <input type="radio" name="f" value="f2" />否
    <br><br>   
                         
    7.你听说过下列添加剂吗？<br>
     <input type="radio"  name="g" value="g1"/>苯甲酸
     &nbsp &nbsp &nbsp &nbsp
     <input type="radio" name="g" value="g2"/>胭脂红
     <br>
     <input type="radio"  name="g" value="g3"/>甜蜜素
     &nbsp &nbsp &nbsp &nbsp
     <input type="radio" name="g" value="g4"/>柠檬酸
    <br><br>  
                        
    8.你是通过哪些渠道了解添加剂的：<br>
     <input type="radio"  name="h" value="h1"/>食品包装
     &nbsp &nbsp 
     <input type="radio" name="h" value="h2"/>媒体报道
     &nbsp &nbsp 
     <input type="radio" name="h" value="h3"/>周边人谈及
     <br>
     <input type="radio" name="h" value="h4"/>其他
     &nbsp &nbsp 
     <input type="radio" name="h" value="h5"/>从不知道
    <br><br>   
                
    9.你了解食品添加剂的作用吗？<br>
     <input type="radio"  name="i" value="i1"/>了解许多
     &nbsp &nbsp 
     <input type="radio" name="i" value="i2"/>了解一点
     &nbsp &nbsp 
     <input type="radio" name="i" value="i3"/>不了解
    <br><br>                                     
    
     10.你认为添加剂对食品安全的影响是什么样的？<br>
     <input type="radio"  name="j" value="j1"/>都有安全问题
     &nbsp &nbsp 
     <input type="radio" name="j" value="j2"/>部分有安全问题
     <br>
    <input type="radio" name="j" value="j3"/>没有安全问题
    <br>                  <br>    
 <input type="submit" id="id_of_field" name="name_of_filed" value="点击提交问卷">

</form>
 </div>
</body>
</html>
