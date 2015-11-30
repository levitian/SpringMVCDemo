<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>日报列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.dataTables.css">
	<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
  </head>
  
  <body>
	<table id="example" class="display" cellspacing="0" width="100%">
	     <thead>
	         <tr>
	             <th style="display: none">ID</th>
	             <th>姓名</th>
	             <th>工作内容（任务）</th>
	             <th>牵头人</th>
	             <th>工作进展</th>
	             <th>是否测试</th>
	             <th>工作进展</th>
	             <th>是否提交SVN</th>
	             <th>遇到的困难/问题</th>
	             <th>备注</th>
	         </tr>
	     </thead>
	     <tbody>
			
	     </tbody>
	 </table>
	 <script type="text/javascript">

	 </script>
  </body>
</html>
