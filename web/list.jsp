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
  <title>图书列表</title>
  
  <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->
  <sj:head jqueryui="false"/>
  <sb:head/>
</head>
<body>
<div class="container">
  <table class="table table-bordered table-striped table-hover">
    <thead>
    <tr>
      <th>ISBN</th>
      <th>Title</th>
      <th>Price</th>
      <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="books">
      <tr>
        <td><s:property value="ISBN"/></td>
        <td>
          <a href='<s:url action="showDetails"><s:param name="isbn" value="ISBN" /></s:url>'>
            <s:property value="title"/>
          </a>
        </td>
        <td>$<s:property value="price"/></td>
        <td>
          <a href='#'>Edit</a>&nbsp;
          <a href='<s:url action="remove"><s:param name="isbn" value="ISBN" /></s:url>'>Delete</a>
        </td>
      </tr>
    </s:iterator>
    </tbody>
  </table>
</div>

</body>
</html>