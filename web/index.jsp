<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
  <title>实验二——图书管理系统</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- 引入 Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
  <nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
          class="icon-bar"></span><span class="icon-bar"></span></button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong
            class="caret"></strong></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>
  <a href="List.action">
  <h1 class="text-center">hello world!!</h1></a>
  <table class="table table-hover table-bordered">
    <thead>
    <tr>
      <th>编号</th>
      <th>产品</th>
      <th>交付时间</th>
      <th>状态</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>1</td>
      <td>TB - Monthly</td>
      <td>01/04/2012</td>
      <td>Default</td>
    </tr>
    <tr class="success">
      <td>1</td>
      <td>TB - Monthly</td>
      <td>01/04/2012</td>
      <td>Approved</td>
    </tr>
    <tr class="error">
      <td>2</td>
      <td>TB - Monthly</td>
      <td>02/04/2012</td>
      <td>Declined</td>
    </tr>
    <tr class="warning">
      <td>3</td>
      <td>TB - Monthly</td>
      <td>03/04/2012</td>
      <td>Pending</td>
    </tr>
    <tr class="info">
      <td>4</td>
      <td>TB - Monthly</td>
      <td>04/04/2012</td>
      <td>Call in to confirm</td>
    </tr>
    </tbody>
  </table>
</div>

<!-- jQuery -->
<script src="js/jquery-3.1.1.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
