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
  <title>书籍列表 - 图书管理系统</title>
  <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"/>
  <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
  <!--[if lt IE 9]>
  <script type="text/javascript" charset="utf8" src="js/html5shiv.js"></script>
  <![endif]-->
  <sj:head jqueryui="false"/>
  <sb:head/>
  <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.min.css">
  <script type="text/javascript" charset="utf8" src="js/jquery.dataTables.min.js"></script>
  <script type="text/javascript" charset="utf8" src="js/dataTables.bootstrap.min.js"></script>
  
  <!-- initiate datatable -->
  <script type="text/javascript" charset="utf-8">
    $(document).ready(function () {
      $('.table').dataTable({
        language: {
          "sProcessing": "处理中...",
          "sLengthMenu": "每页显示 _MENU_ 项结果",
          "sZeroRecords": "没有匹配结果",
          "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
          "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
          "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
          "sInfoPostFix": "",
          "sSearch": "表格内搜索:",
          "sUrl": "",
          "sEmptyTable": "表中数据为空",
          "sLoadingRecords": "载入中...",
          "sInfoThousands": ",",
          "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页"
          },
          "oAria": {
            "sSortAscending": ": 以升序排列此列",
            "sSortDescending": ": 以降序排列此列"
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
          <li class="active"><a href="listBook.action">书籍列表</a></li>
          <li><a href="getAuthorsName.action">新增图书</a></li>
          <li style="padding: 10px 10px; font-size: 20px">作者管理</li>
          <li><a href="listAuthor.action">作者列表</a></li>
          <li><a href="search.jsp">搜索作品</a></li>
          <li><a href="addAuthor.jsp">新增作者</a></li>
        </ul>
      </div>
    </div>
    <div class="col-md-9">
      <div class="page-header">
        <h3>书籍列表</h3>
      </div>
      <s:if test="%{books.isEmpty()}">
        <h4 class="text-center">数据库中没有书籍╮（╯＿╰）╭</h4>
      </s:if>
      <s:else>
        <table id="example" class="table table-bordered table-striped table-hover">
          <thead>
          <tr>
            <th style='vertical-align: middle;'>ISBN</th>
            <th style='vertical-align: middle;'>书名
              <span class="glyphicon glyphicon-question-sign" data-toggle="tooltip" data-placement="top"
                    title="点击书名查看详情"></span>
            </th>
            <th style='vertical-align: middle;'>价格</th>
            <th style='vertical-align: middle;'>出版社</th>
            <th style='vertical-align: middle;'>操作</th>
          </tr>
          </thead>
          <tbody>
          <s:iterator value="books">
            <tr>
              <td style='vertical-align: middle;'><s:property value="ISBN"/></td>
              <td style='vertical-align: middle;'>
                <a href='<s:url action="showBookDetails"><s:param name="ISBN" value="ISBN" /></s:url>'>
                  <s:property value="title"/>
                </a>
              </td>
              <td style='vertical-align: middle;'>$<s:property value="price"/></td>
              <td style='vertical-align: middle;'><s:property value="publisher"/></td>
              <td style='vertical-align: middle;'>
                <a href='<s:url action="preEditBook"><s:param name="ISBN" value="ISBN" /></s:url>'
                   class="btn btn-sm btn-primary"><span class="glyphicon glyphicon-edit"></span>&nbsp;修改</a>&nbsp;
                <a href='<s:url action="removeBook"><s:param name="ISBN" value="ISBN" /></s:url>'
                   class="btn btn-sm  btn-danger"><span class="glyphicon glyphicon-remove"></span>&nbsp;删除</a>
              </td>
            </tr>
          </s:iterator>
          </tbody>
        </table>
      </s:else>
    </div>
  </div>
</div>

<footer
    style="padding-top: 40px;padding-bottom: 40px;margin-top: 100px;color: #777;text-align: center;border-top: 1px solid #e5e5e5;">
  Copyright &copy; 2016 <a href="https://s-h-y-github.github.io/">率怀一</a> ❤ Made with Love <br>
  Theme by <a href="http://getbootstrap.com/">Bootstrap</a> ♪ Powered by <a href="http://struts.apache.org/">Struts</a>
</footer>

<!-- initiate tooltip -->
<script type="text/javascript" charset="utf-8">
  $(function () {
    $("[data-toggle='tooltip']").tooltip();
  });
</script>
</body>
</html>
