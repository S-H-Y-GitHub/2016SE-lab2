<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Book</title>
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
<s:form action="Store" >
    <s:textfield name="book.isbn" label="ISBN" />
    <s:textfield name="book.title" label="Title" />
    <s:textfield name="book.price" label="Price" />
    <s:submit />
</s:form>
</body>
</html>