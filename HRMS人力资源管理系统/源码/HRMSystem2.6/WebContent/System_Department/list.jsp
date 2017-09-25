<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*"%>
<%@page import="com.hrmsystem.domain.DeparmentsShow"%>
 <% String path=request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>部门列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath} /script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />

	<%
	   //获取从数据库显提取出来的部门信息
	   ArrayList<DeparmentsShow> list=(ArrayList<DeparmentsShow>)request.getAttribute("list");
	   if(list!=null){
		   //特别要注意,从数据库中提取的相关数据是否为空， 如果不进行判断则会出现死循环
		   %>
	
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 部门管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="2" cellpadding="8" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
            	<td width="150px">部门名称</td>
				<td width="150px">上级部门名称</td>
				<td width="200px">职能说明</td>
				<td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
			<% //************************************
			//注意 循环遍历必须要放在<tr>中，否则会出现显示错误
			for(int i=0;i<list.size();i++){
				DeparmentsShow  deparment=list.get(i);
			%>
			<tr class="TableDetail1 template">
			
				<td><%=deparment.getDepName()%>&nbsp;</td>
				<td><%=deparment.getParentName()%>&nbsp;</td>
				<td><%=deparment.getTaskDesc()%>&nbsp;</td>
				<td><a onclick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')" href="ShowDepartmentControl?type=del&delName=<%=deparment.getDepName()%>">删除</a>
					<a href="System_Department/saveUI.jsp">修改</a>
				</td>
			</tr>
			 <%}%>
       
    </table>
    	<% }%>	  
	 
	   
	
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="AddDepartmentControl?type=createDep"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></a>
        </div>
    </div>
</div>

<!--说明-->	
<div id="Description"> 
</div>

</body>
	
</html>
