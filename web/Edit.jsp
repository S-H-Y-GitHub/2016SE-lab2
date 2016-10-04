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
  <title>Book</title>
  
  <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->
  <sj:head jqueryui="false"/>
  <sb:head/>
</head>
<body>
<h2>
  <s:if test="null == book">
    Add Book
  </s:if>
  <s:else>
    Edit Book
  </s:else>
</h2>
<s:form action="Store">
  <s:textfield name="book.isbn" label="ISBN"/>
  <s:textfield name="book.title" label="Title"/>
  <s:textfield name="book.price" label="Price"/>
  <s:submit/>
</s:form>
</body>
</html>