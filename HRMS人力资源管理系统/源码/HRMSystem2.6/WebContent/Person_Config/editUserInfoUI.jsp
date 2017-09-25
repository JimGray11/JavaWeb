<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="com.hrmsystem.domain.Users"%><html>
<% String path=request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
 
<head>
<base href="<%=basePath%>">
	<title>个人信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
     <%
        Users user=(Users)request.getSession().getAttribute("user");
     %>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 个人信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="${pageContext.request.contextPath}/System_User/list.html" enctype="multipart/form-data">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 个人信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm" width="200">
					<tr>
                        <td align="center">ID:</td>
                        <td align="center" width="100">${user.user_name}</td>
						<td rowspan="5" align="right">
							<img src="${pageContext.request.contextPath}/style/images/defaultAvatar.gif"/>
						</td>
                    </tr>
                    <tr>
                        <td align="center">部门:</td>
                        <td align="center" width="100"><%=user.getDepartmentName()%></td>
                    </tr>
					<tr>
                        <td align="center">岗位:</td>
                        <td align="center" width="100"><%=user.getPositionName()%></td>
                    </tr>
					<tr>
                        <td align="center">姓名:</td>
                        <td align="center" width="100"><% if(user.getName()!=null){%><%=user.getName()%><%}%></td>
                    </tr>
					<tr>
                        <td align="center">头像:</td>
                        <td><input type="file" name="resource" class="InputStyle" style="width: 400px;"/></td>
                    </tr>
                </table>
            </div>
        </div>
       
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
	
</div>

</body>
</html>
