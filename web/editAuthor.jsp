<%@ page import="com.oracle.webservices.internal.api.message.PropertySet" %>
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
          <li><a href="listBook.action">书籍列表</a></li>
          <li><a href="getAuthorsName.action">新增图书</a></li>
          <li style="padding: 10px 10px; font-size: 20px">作者管理</li>
          <li class="active"><a href="listAuthor.action">作者列表</a></li>
          <li><a href="search.jsp">搜索作品</a></li>
          <li><a href="addAuthor.jsp">新增作者</a></li>
        </ul>
      </div>
    </div>
    <div class="col-md-9">
      <div class="page-header">
        <h3>编辑作者信息</h3>
      </div>
      <s:form action="editAuthor" enctype="multipart/form-data" theme="simple" cssClass="form-horizontal">
        <div class="form-group">
          <div class="col-md-1">
            <label for="AuthorID" class="control-label">ID</label>
          </div>
          <div class="col-md-11">
            <s:textfield
                readonly="true"
                cssClass="form-control"
                id="AuthorID"
                name="authorID"
                value="%{author.AuthorID}"
                placeholder="请输入作者的ID，必须为小于11位的数字，不能为空"/>
          </div>
        </div>
        <div class="form-group">
          <div class="col-md-1">
            <label for="name" class="control-label">姓名</label>
          </div>
          <div class="col-md-11">
            <s:textfield
                cssClass="form-control"
                id="name"
                name="name"
                value="%{author.Name}"
                placeholder="请输入作者的姓名，不能超过45个字符，不能为空"/>
          </div>
        </div>
        <div class="form-group">
          <div class="col-md-1">
            <label for="age" class="control-label">年龄</label>
          </div>
          <div class="col-md-11">
            <s:textfield
                cssClass="form-control"
                id="age"
                name="age"
                value="%{author.Age}"
                placeholder="请输入作者的年龄，必须为小于150的数字，不能为空"/>
          </div>
        </div>
        <div class="form-group">
          <div class="col-md-1">
            <label for="country" class="control-label">国家</label>
          </div>
          <div class="col-md-11">
            <s:textfield
                cssClass="form-control"
                id="country"
                name="country"
                value="%{author.Country}"
                placeholder="请输入作者的国家，不能超过45个字符，不能为空"/>
          </div>
        </div>
        <s:submit value="提交" cssClass="btn btn-primary btn-lg btn-block"/>
      </s:form>
    </div>
  </div>
</div>
<footer
    style="padding-top: 40px;padding-bottom: 40px;margin-top: 100px;color: #777;text-align: center;border-top: 1px solid #e5e5e5;">
  Copyright &copy; 2016 <a href="https://s-h-y-github.github.io/">率怀一</a> ❤ Made with Love <br>
  Theme by <a href="http://getbootstrap.com/">Bootstrap</a> ♪ Powered by <a
    href="http://struts.apache.org/">Struts</a>
</footer>
</body>
</html>
