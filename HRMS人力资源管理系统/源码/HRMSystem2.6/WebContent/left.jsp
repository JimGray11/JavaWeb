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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>HRMS人力资源管理系统</title>
	
	<link href="style/blue/style.css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="jquery/treeview/jquery.treeview.css" />
	<script src="jquery/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="jquery/treeview/jquery.treeview.js" type="text/javascript"></script>
	<script language="JavaScript" src="script/menu.js"></script>
  <link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
	<script type="text/javascript">
	$(document).ready(function(){
		$("#browser").treeview();
	});
	</script>
	</head>
	<body>
	<div id="Menu">
	<ul id="browser" class="filetree">
		<li class="folder"><span class="folder">HRMS人力资源管理系统</span>
			<ul>
			<li class="closed">
					<span class="folder">系统管理</span>
					<ul>
						<li><span class="file"><a target="right" href="ShowPositionControl"> 岗位管理</a></span></li>
						<li><span class="file"><a target="right" href="ShowDepartmentControl"> 部门管理</a></span></li>
						<li><span class="file"><a target="right" href="ShowUserInfoControl?pageNow=1"> 用户管理</a></span></li>
					</ul>
				</li>
				<li class="closed"><span class="folder">人员档案</span>
					<ul>
						<li><span class="file"><a href="troubleTicket/index.html" target="right">基本信息</a></span></li>
						<li><span class="file"><a href="troubleTicket/approving.html" target="right">员工档案</a></span></li>
						<li><span class="file"><a href="troubleTicket/approved.html" target="right">员工履历</a></span></li>
						<li><span class="file"><a href="troubleTicket/archive.html" target="right">奖惩管理</a></span></li>
					</ul>
				</li>
				<li class="closed"><span class="folder">人事调配</span>
					<ul>
						<li><span class="file">人事调配管理</span></li>
					</ul>
				</li>
				<li class="closed">
					<span class="folder">教育培训</span>
					<ul>
						<li><span class="file"><a href="/HRMSystem2.6/queryServlet?actionCode=category" target="right">培训类别维护</a></span></li>
						<li><span class="file"><a href="/HRMSystem2.6/queryServlet?actionCode=record" target="right">培训记录</a></span></li>
						<li><span class="file"><a href="/HRMSystem2.6/queryServlet?actionCode=score" target="right">培训成绩管理</a></span></li>
						<li><span class="file"><a href="Edu/Search.jsp" target="right" >教育培训情况</a></span></li>
					</ul>
				</li>	
								
				<li class="closed">
					<span class="folder">个人设置</span>
					<ul>
						<li><span class="file"><a href="UserInfoControl" target="right">个人信息</a></span></li>
						<li><span class="file"><a href="Person_Config/editPasswordUI.jsp" target="right">修改密码</a></span></li>
					</ul>
				</li>	
				
				<li class="closed">
					<span class="folder">通知管理</span>
					<ul>
						<li><span class="file"><a href="announcement/index.html" target="workareaFrame">公告管理</a></span></li>
					</ul>
				</li>	
			</ul>
		</li>
	</ul>
 </div>
</body></html>