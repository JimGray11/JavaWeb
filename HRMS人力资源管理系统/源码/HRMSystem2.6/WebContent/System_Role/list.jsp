<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
 <html>
<%@page import="com.hrmsystem.domain.Positions"%>
 <% String path=request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<head>
    <base href="<%=basePath%>">
    <title>岗位列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
    
	<%
	   //获取从数据库显提取出来的部门信息
	   ArrayList<Positions> list=(ArrayList<Positions>)request.getAttribute("positionList");
	   if(list!=null){
		   //特别要注意,从数据库中提取的相关数据是否为空， 如果不进行判断则会出现死循环
		   %>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="2" cellpadding="8" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <% //************************************
			//注意 循环遍历必须要放在<tr>中，否则会出现显示错误
			for(int i=0;i<list.size();i++){
				Positions position=list.get(i);
			%>
			<tr class="TableDetail1 template">
				<td><%=position.getName()%>&nbsp;</td>
				<td><%=position.getTaskDesc()%>&nbsp;</td>
				<td><a onClick="return window.confirm('您确定要删除:<%=position.getName()%>用户吗？')" href="ShowPositionControl?type=del&postName=<%=position.getName()%>">删除</a>
					<a href="System_Role/setPrivilegeUI.html">设置权限</a>
				</td>
			</tr>
     	 <%}%>
       
    </table>
    	<% }%>	  
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="System_Role/saveUI.jsp"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></a>
        </div>
    </div>
</div>
</body>
</html>
