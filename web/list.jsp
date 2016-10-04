<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="utf-8" >
  <title>Book List</title>
  <style type="text/css">
    table {
      border: 1px solid black;
      border-collapse: collapse;
    }
    
    table thead tr th {
      border: 1px solid black;
      padding: 3px;
      background-color: #cccccc;
    }
    
    table tbody tr td {
      border: 1px solid black;
      padding: 3px;
    }
  </style>
</head>
<body>
<h2>Book List</h2>
<table cellspacing="0">
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
        <a href='#'>
          Edit
        </a>
        &nbsp;
        <a href='<s:url action="remove"><s:param name="isbn" value="ISBN" /></s:url>'>
          Delete
        </a>
      </td>
    </tr>
  </s:iterator>
  </tbody>
</table>
<a href="Edit.jsp">Add Book</a>
</body>
</html>