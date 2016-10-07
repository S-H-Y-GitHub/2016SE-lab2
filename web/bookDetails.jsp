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
  <meta name="author" content="率怀一">
  <title>图书管理系统</title>
  <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
  <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->
  <sj:head jqueryui="false"/>
  <sb:head/>
</head>
<body>
<div class="container container-fluid">
  <div class="row">
    <div class="col-md-3">
      <div class="well" style="margin-top: 30px">
        <ul class="nav nav-pills nav-stacked">
          <li style="padding: 10px 10px; font-size: 20px">图书管理</li>
          <li class="active"><a href="listBook.action">书籍列表</a></li>
          <li><a href="getAuthorsName.action">新增图书</a></li>
          <li style="padding: 10px 10px; font-size: 20px">作者管理</li>
          <li><a href="listAuthor.action">作者列表</a></li>
          <li><a href="search.jsp">搜索作品</a></li>
          <li><a href="addAuthor.jsp">新增作者</a></li>
        </ul>
      </div>
    </div>
    <div class="col-md-9">
      <div class="page-header">
        <h3>书籍信息</h3>
      </div>
      <table class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
          <th width="25%">属性</th>
          <th>值</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>ISBN</td>
          <td><s:property value="book.ISBN"/></td>
        </tr>
        <tr>
          <td>书名</td>
          <td><s:property value="book.Title"/></td>
        </tr>
        <tr>
          <td>作者ID</td>
          <td><s:property value="book.AuthorID"/></td>
        </tr>
        <tr>
          <td>出版社</td>
          <td><s:property value="book.Publisher"/></td>
        </tr>
        <tr>
          <td>出版日期</td>
          <td><s:property value="dateStr"/></td>
        </tr>
        <tr>
          <td>价格</td>
          <td><s:property value="book.Price"/></td>
        </tr>
        </tbody>
      </table>
      <div class="page-header">
        <h3>作者信息</h3>
      </div>
      <table class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
          <th width="25%">属性</th>
          <th>值</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>ID</td>
          <td><s:property value="author.AuthorID"/></td>
        </tr>
        <tr>
          <td>姓名</td>
          <td><s:property value="author.Name"/></td>
        </tr>
        <tr>
          <td>年龄</td>
          <td><s:property value="author.Age"/></td>
        </tr>
        <tr>
          <td>国家</td>
          <td><s:property value="author.Country"/></td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
<footer
    style="padding-top: 40px;padding-bottom: 40px;margin-top: 100px;color: #777;text-align: center;border-top: 1px solid #e5e5e5;">
  Copyright &copy; 2016 <a href="https://s-h-y-github.github.io/">率怀一</a> ❤ Made with Love <br>
  Theme by <a href="http://getbootstrap.com/">Bootstrap</a> ♪ Powered by <a href="http://struts.apache.org/">Struts</a>
</footer>
</body>
</html>