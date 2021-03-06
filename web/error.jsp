<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="zh_CN">
<head>
  <!-- made by shuaihuaiyi -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="author" content="率怀一">
  <title>错误界面 - 图书管理系统</title>
  <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
  <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->
  <style type="text/css">
    body,td,th {
      color: #FFFFFF;
    }
    body {
      background-color: #0099CC;
    }
    .STYLE7 {
      font-size: 24px;
      font-family: "微软雅黑";
    }
    .STYLE9 {font-size: 14px; text-align: right}
    .STYLE12 {
      font-size: 100px;
      font-family: "微软雅黑";
    }
    .center{
      position: absolute;
      top: 20%;
      left: 20%;
    }
  </style>
  <script type="text/javascript">
    var i = 0;
    var intervalid;
    intervalid = setInterval("fun()", 400);
    function fun() {
      if (i >= 100) {
        history.go(-1);
        clearInterval(intervalid);
      }
      document.getElementById("mes").innerHTML = i;
      i=i+5;
    }
  </script>
</head>
<body>
<div class="center">
  <span class="STYLE12">&nbsp;:(</span>
  <div class="STYLE7">&nbsp;&nbsp;&nbsp;&nbsp;你的请求出现问题，需要返回重试。<br>
    &nbsp;&nbsp;&nbsp;&nbsp;我们只收集某些错误信息，然后为您返回前一页。<br>
    &nbsp;&nbsp;&nbsp;&nbsp;(完成<span id="mes">0</span>%)</div>
  <div class="STYLE9"><br>如果你想了解更多信息，则可以稍后在线搜索此错误: <s:property value="errMsg"/></div>
</div>
</body>
</html>
