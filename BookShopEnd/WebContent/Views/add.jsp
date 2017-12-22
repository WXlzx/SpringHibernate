<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link href="<%=basePath %>/styles/Index.css" rel="stylesheet" />
</head>
<body>
    <div class="header">

        <img class="logo" src="<%=basePath %>/images/logo.png" />
        <label class="logo-title">BookShop网站后台</label>
        <ul class="inline">
            <li>
                <img src="<%=basePath %>/images/32/client.png" />&nbsp;&nbsp;欢迎您,${admin.name }
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle mymsg" data-toggle="dropdown" href="#"><img src="<%=basePath %>/images/32/166.png" />&nbsp;&nbsp;修改个人信息<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="<%=basePath %>/../adminupdate.do">修改密码</a></li>
                </ul>

            </li>
            <li>
                <img src="<%=basePath %>/images/32/200.png" />&nbsp;&nbsp;<a class="loginout" href="<%=basePath %>/../outadmin.do">退出</a>
            </li>

        </ul>


    </div>


    <div class="nav">

        <ul class="breadcrumb">
            <li>
                <img src="<%=basePath %>/images/32/5025_networking.png" />
            </li>
            <li><a href="<%=basePath %>/Views/index.jsp">首页</a> <span class="divider">>></span></li>
            <li class="active"></li>
        </ul>
    </div>



    <div class="container-fluid content">
        <div class="row-fluid">
            <div class="span2 content-left">
                <div class="accordion">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                                <img class="left-icon" src="<%=basePath %>/images/32/5026_settings.png" /><span class="left-title">系统设置</span>
                            </a>
                        </div>
                        <div id="collapseOne" class="accordion-body collapse in">
                            <div class="accordion-inner">
                           	 	<a href="<%=basePath %>/../selectorder.do">
                                <img class="left-icon-child" src="<%=basePath %>/images/32/4962_sitemap.png" /><span class="left-body"> 订单详情</span>
                                </a>
                            </div>
                            <div class="accordion-inner">
                                <a href="<%=basePath %>/../selectuser.do">
                                <img class="left-icon-child" src="<%=basePath %>/images/32/4992_user.png" /><span class="left-body"> 用户管理</span>
								</a>
                            </div>
                            
                            <div class="accordion-inner">
                                <a href="<%=basePath %>/Views/add.jsp">
                                <img class="left-icon-child" src="<%=basePath %>/images/32/8.png" /><span class="left-body"> 添加图书 </span>
                                </a>
                            </div>
                            
                            <div class="accordion-inner">
                            	<a href="<%=basePath %>/../selectkind.do">
                                <img class="left-icon-child" src="<%=basePath %>/images/32/612.png" /><span class="left-body"> 类别管理</span>
                                </a>
                            </div>
                      
                        </div>
                    </div>
                </div>

            </div>

            <div class="span10 content-right">
                <iframe src="<%=basePath %>/Views/add2.jsp" class="iframe"></iframe>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="foot"></div>
    <script src="<%=basePath %>/scripts/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath %>/bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>/scripts/Index.js"></script>
	<div style="text-align:center;">
</div>

</body>
</html>