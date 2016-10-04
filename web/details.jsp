<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>图书详情</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <h3>书籍信息</h3>
  <table class="table table-bordered table-striped">
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
  <table class="table table-bordered table-striped">
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
<script src="js/jquery-3.1.1.min.js" type="javascript"></script>
<script src="js/bootstrap.min.js" type="javascript"></script>
</body>
</html>
