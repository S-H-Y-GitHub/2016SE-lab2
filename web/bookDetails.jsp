<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>图书详情</title>
  
  <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->
  <sj:head jqueryui="false"/>
  <sb:head/>
</head>
<body>
<div class="container">
  <h3>书籍信息</h3>
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
      <td>Title</td>
      <td><s:property value="book.Title"/></td>
    </tr>
    <tr>
      <td>AuthorID</td>
      <td><s:property value="book.AuthorID"/></td>
    </tr>
    <tr>
      <td>Publisher</td>
      <td><s:property value="book.Publisher"/></td>
    </tr>
    <tr>
      <td>PublishDate</td>
      <td><s:property value="book.PublishDate"/></td>
    </tr>
    <tr>
      <td>Price</td>
      <td><s:property value="book.Price"/></td>
    </tr>
    </tbody>
  </table>
  <h3>作者信息</h3>
  <table class="table table-bordered table-striped table-hover">
    <thead>
    <tr>
      <th width="25%">属性</th>
      <th>值</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>AuthorID</td>
      <td><s:property value="author.AuthorID"/></td>
    </tr>
    <tr>
      <td>Name</td>
      <td><s:property value="author.Name"/></td>
    </tr>
    <tr>
      <td>Age</td>
      <td><s:property value="author.Age"/></td>
    </tr>
    <tr>
      <td>Country</td>
      <td><s:property value="author.Country"/></td>
    </tr>
    </tbody>
  </table>
</div>
</body>
</html>
