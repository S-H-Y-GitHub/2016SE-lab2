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
  <link rel="stylesheet" href="css/formvalidation.min.css"/>
  <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <![endif]-->
  <sj:head jqueryui="false"/>
  <sb:head/>
  <!-- include formvalidation 0.8.1, cracked by shuaihuaiyi, use it wisely -->
  <script type="text/javascript" charset="utf8" src="js/formvalidation.min.js"></script>
  <script type="text/javascript" charset="utf8" src="js/bootstrap.min.js"></script>
  <script type="text/javascript" charset="utf8">
    $(document).ready(function () {
      $('.form-horizontal').formValidation({
        framework: 'bootstrap',
        icon: {
          valid: 'glyphicon glyphicon-ok',
          invalid: 'glyphicon glyphicon-remove',
          validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
          ISBN: {
            validators: {
              notEmpty: {
                message: 'ISBN不能为空'
              },
              integer: {
                message: 'ISBN必须为纯数字'
              },
              stringLength: {
                min: 13,
                max: 13,
                message: 'ISBN必须为13位'
              }
            }
          },
          title: {
            validators: {
              notEmpty: {
                message: '书名不能为空'
              },
              stringLength: {
                max: 45,
                message: '书名不能超过45个字符'
              }
            }
          },
          publisher: {
            validators: {
              notEmpty: {
                message: '出版社不能为空'
              },
              stringLength: {
                max: 45,
                message: '出版社不能超过45个字符'
              }
            }
          },
          price: {
            validators: {
              notEmpty: {
                message: '价格不能为空'
              },
              regexp: {
                regexp: /^\d+\.?\d+$/,
                message: '价格必须为正数'
              }
            }
          },
          dateStr: {
            validators: {
              notEmpty: {
                message: '出版日期不能为空'
              },
              date: {
                format: 'YYYY-MM-DD',
                message: '出版日期格式错误'
              }
            }
          }
        }
      });
    });
  </script>
</head>
<body>
<div class="container container-fluid">
  <div class="row">
    <div class="col-md-3">
      <div class="well" style="margin-top: 30px">
        <ul class="nav nav-pills nav-stacked">
          <li style="padding: 10px 10px; font-size: 20px">图书管理</li>
          <li><a href="listBook.action">书籍列表</a></li>
          <li class="active"><a href="getAuthorsName.action">新增图书</a></li>
          <li style="padding: 10px 10px; font-size: 20px">作者管理</li>
          <li><a href="listAuthor.action">作者列表</a></li>
          <li><a href="search.jsp">搜索作品</a></li>
          <li><a href="addAuthor.jsp">新增作者</a></li>
        </ul>
      </div>
    </div>
    <div class="col-md-9">
      <div class="page-header">
        <h3>新增图书</h3>
      </div>
      <s:form action="addBook" enctype="multipart/form-data" theme="simple" cssClass="form-horizontal">
        <div class="form-group">
          <div class="col-md-2">
            <label for="isbn" class="control-label">ISBN</label>
          </div>
          <div class="col-md-10">
            <s:textfield
                cssClass="form-control"
                id="isbn"
                name="ISBN"
                placeholder="请输入图书的ISBN，必须为13位数字"/>
          </div>
        </div>
        <div class="form-group">
          <div class="col-md-2">
            <label for="title" class="control-label">书名</label>
          </div>
          <div class="col-md-10">
            <s:textfield
                cssClass="form-control"
                id="title"
                name="title"
                placeholder="请输入书名，不能超过45个字符，不能为空"/>
          </div>
        </div>
        <div class="form-group">
          <div class="col-md-2">
            <label for="publisher" class="control-label">出版社</label>
          </div>
          <div class="col-md-10">
            <s:textfield
                cssClass="form-control"
                id="publisher"
                name="publisher"
                placeholder="请输入书籍的出版社，不能超过45个字符，不能为空"/>
          </div>
        </div>
        <div class="form-group">
          <div class="col-md-2">
            <label for="publishdate" class="control-label">出版日期</label>
          </div>
          <div class="col-md-10">
            <s:textfield
                cssClass="form-control"
                id="publishdate"
                name="dateStr"
                placeholder="请输入书籍的出版日期，格式为yyyy-MM-dd,不能为空"/>
          </div>
        </div>
        <div class="form-group">
          <div class="col-md-2">
            <label for="price" class="control-label">价格</label>
          </div>
          <div class="col-md-10">
            <s:textfield
                cssClass="form-control"
                id="price"
                name="price"
                value="%{null}"
                placeholder="请输入书籍价格，不能为空"/>
          </div>
        </div>
        <div class="form-group">
          <div class="col-md-2">
            <label for="authorid" class="control-label">作者</label>
          </div>
          <div class="col-md-10">
            <s:select
                cssClass="form-control"
                id="authorid"
                name="authorID"
                list="authors"
                listKey="authorID"
                listValue="name"
                required="true"
            />
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
<script language="JavaScript">$(function () {
  $("[data-toggle='tooltip']").tooltip();
});</script>
</body>
</html>
