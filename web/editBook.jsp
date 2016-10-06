<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html lang="zh_CN">
<head>
  <!-- made by shuaihuaiyi -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>图书管理系统</title>
  <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
  <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->
  <sj:head jqueryui="false"/>
  <sb:head/>
</head>
<body>
<div class="container container-fluid" style="margin-top: 30px">
  <div class="row">
    <div class="col-md-3">
      <div class="well">
        <ul class="nav nav-pills nav-stacked">
          <li style="padding: 10px 10px; font-size: 20px">图书管理</li>
          <li class="active"><a href="List.action">书籍列表</a></li>
          <li><a href="#">新增图书</a></li>
          <li><a href="#">搜索图书</a></li>
          <li style="padding: 10px 10px; font-size: 20px">作者管理</li>
          <li><a href="#">作者列表</a></li>
          <li><a href="#">新增作者</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="col-md-9">
  
  </div>
</div>
<footer style="padding-top: 40px;padding-bottom: 40px;margin-top: 100px;color: #777;text-align: center;border-top: 1px solid #e5e5e5;">
  &copy; <a href="https://s-h-y-github.github.io/">率怀一</a> 2016 ♪ Powered by <a href="http://struts.apache.org/">Struts</a>
</footer>
</body>
</html>
