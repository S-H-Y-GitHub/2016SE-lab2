<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html lang="zh_CN">
<head>
  <title>实验二——图书管理系统</title>
  <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->
  
  <sb:head/>
</head>
<body>

<div class="container">
  <a href="List.action"><h1 class="text-center">hello world!!</h1></a>
  <s:form action="searchAuthor" method="POST" theme="simple" cssClass="well form-group">
    <s:textfield
        cssClass="form-control"
        label="根据作者姓名搜索"
        placeholder="Search"
        name="name"
        tooltip="输入作者的姓名（区分大小写）"/>
    <br>
    <s:submit value="搜索" cssClass="btn btn-primary btn-lg btn-block"/>
  </s:form>
</div>

</body>
</html>
