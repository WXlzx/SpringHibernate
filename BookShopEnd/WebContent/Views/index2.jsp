<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.rj.bookshop.Entity.Book"%>
<%@page import="com.rj.bookshop.Service.BookService"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="<%=basePath %>/bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href="<%=basePath %>/styles/Common.css" rel="stylesheet" />
    <link href="<%=basePath %>/styles/Index2.css" rel="stylesheet" />
</head>
<body>
    <div class="container-fluid">
        <div class="row-fluid">
            <h4>数据列表</h4>
            <div class="w">
                <div class="span12">
                    <table class="table table-condensed table-bordered table-hover tab" align="center">
                        <thead>
                            <tr>
                                <th>书名</th>
                                <th>作者</th>
                                <th>简介</th>
                                <th>类别</th>
                                <th>价格</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <c:forEach var="book" items="${ booklist}">
                        	<tbody id="tbody">
                        		<tr align="center">
                        		<th><img src="<%=basePath %>/../${book.book_img }" alt="${book.book_name }" width="50px" height="90px"/></th>
                        		<th>${book.book_author}</th>
                        		<th>${book.book_describe}</th>
                        		<th>${book.kind.kind_name }</th>
                        		<th>${book.book_price}</th>
                        		<th><a href="<%=basePath %>/../update.do?bookid=${book.book_id }">修改</a>|<a href="<%=basePath %>/../delete.do?bookid=${book.book_id }">删除</a></th>  
                        		<tr>                           
                        	</tbody>
                        </c:forEach>

                    </table>
                    <div id="page" class="tr"></div>
                </div>
            </div>
        </div>
    </div>

    <script src="<%=basePath %>/scripts/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath %>/bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>/layer-v2.3/layer/layer.js"></script>
    <script src="<%=basePath %>/laypage-v1.3/laypage/laypage.js"></script>
    <script src="<%=basePath %>/scripts/Index2.js"></script>
</body>
</html>