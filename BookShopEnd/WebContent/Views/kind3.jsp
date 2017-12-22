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
              		<form action="<%=basePath %>/../addkind.do">
                    <table class="table table-condensed table-bordered table-hover tab" >
                        <thead>
                            <tr>
                                <th>类别</th>
                                <th>操作</th>
                            </tr>

                        </thead>
                        <tbody id="tbody">
                            <tr align="center">
                        		<th> <input type="text" name="kind_name"></th>
                        		<th> <input type="submit" value="添加类别"></th>
                       		<tr> 
                        </tbody>
                        
                    </table>
               
                    </form>
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