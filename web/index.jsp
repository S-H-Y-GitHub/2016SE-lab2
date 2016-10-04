<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html lang="zh_CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>实验二——图书管理系统</title>
  <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->
  <sj:head jqueryui="false"/>
  <sb:head/>
</head>
<body>

<div class="container">
  
  <a href="List.action"><h1 class="text-center">hello world!!</h1></a>
  <s:form action="searchAuthor" method="POST" theme="bootstrap" cssClass="well form-group">
    <s:textfield
        label="根据作者姓名搜索"
        name="name"
        cssClass="form-control form-group"
        placeholder="Search"
        inputPrependIcon="search"
        tooltip="输入作者的姓名（区分大小写）"/>
    <s:submit value="搜索" cssClass="form-group btn btn-primary btn-lg btn-block"/>
  </s:form>
</div>

</body>
</html>
