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
  <title>新增作者 - 图书管理系统</title>
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
    $(document).ready(function() {
      $('.form-horizontal').formValidation({
        framework: 'bootstrap',
        icon: {
          valid: 'glyphicon glyphicon-ok',
          invalid: 'glyphicon glyphicon-remove',
          validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
          authorID: {
            validators: {
              notEmpty: {
                message: 'AuthorID不能为空'
              },
              integer: {
                message: 'AuthorID必须为纯数字'
              },
              stringLength: {
                max: 9,
                message: 'AuthorID不能超过9位'
              }
            }
          },
          name: {
            validators: {
              notEmpty: {
                message: '姓名不能为空'
              },
              stringLength: {
                max: 45,
                message: '姓名不能超过45个字符'
              }
            }
          },
          country: {
            validators: {
              notEmpty: {
                message: '国家不能为空'
              },
              stringLength: {
                max: 45,
                message: '国家不能超过45个字符'
              }
            }
          },
          age: {
            validators: {
              notEmpty: {
                message: '年龄不能为空'
              },
              regexp: {
                regexp: /^\d+$/,
                message: '年龄必须是正整数'
              },
              stringLength: {
                max: 9,
                message: '这位作者竟然出生在人类出现之前吗？'
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
          <li><a href="getAuthorsName.action">新增图书</a></li>
          <li style="padding: 10px 10px; font-size: 20px">作者管理</li>
          <li><a href="listAuthor.action">作者列表</a></li>
          <li><a href="search.jsp">搜索作品</a></li>
          <li class="active"><a href="addAuthor.jsp">新增作者</a></li>
        </ul>
      </div>
    </div>
    <div class="col-md-9">
      <div class="page-header">
        <h3>新增作者</h3>
      </div>
      <s:form action="addAuthor" enctype="multipart/form-data" theme="simple" cssClass="form-horizontal">
        <div class="form-group">
          <div class="col-md-1">
            <label for="AuthorID" class="control-label">ID</label>
          </div>
          <div class="col-md-11">
            <s:textfield
                cssClass="form-control"
                id="AuthorID"
                name="authorID"
                placeholder="请输入作者的ID，必须为小于9位的数字，不能为空"/>
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
                placeholder="请输入作者的年龄，必须为正整数，不能为空"/>
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
