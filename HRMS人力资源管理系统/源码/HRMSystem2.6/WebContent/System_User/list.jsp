<%@page import="com.hrmsystem.domain.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String path=request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
 <% 
    List<Users> userList=(List<Users>)request.getAttribute("userList");
    //获取数据库中存储用户信息的总的记录条数
    int pageCount=Integer.parseInt(request.getAttribute("pageCount").toString());
    //获取当前页面
    int pageNow=Integer.parseInt(request.getAttribute("pageNow").toString()) ;
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>用户列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
    <script type="text/javascript">
    //对输入跳转页面的判断
       function goToPage(){
    	    var pageNow=doucument.getElementById('pageNow');
    	    if(pageNow.value!=''){
    	    	window.open('ShowUserInfoControl?pageNow='+pageNow.value+'');
    	    }
       }
    </script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head"> 
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="4" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center valign=middle id=TableTitle>
                <td width="100">登录名</td>
                <td width="100">姓名</td>
                <td width="100">所属部门</td>
                <td width="200">岗位</td>
                <td>备注</td>
                <td>相关操作</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <% //************************************
			//注意 循环遍历必须要放在<tr>中，否则会出现显示错误
			if(userList!=null){
		
			for(int i=0;i<userList.size();i++){
				 Users  user=userList.get(i);
			%>
            <tr class="TableDetail1 template">
                <td><%=user.getUser_name()%>&nbsp;</td>
                <td><%=user.getName()%>&nbsp;</td>
                <td><%=user.getDepartmentName()%>&nbsp;</td>
                <td><%=user.getPositionName()%>&nbsp;</td>
                <td>&nbsp;</td>
                <td><a onClick="return window.confirm('您确定要删除:<%=user.getUser_name()%>用户吗？')" href="ShowUserInfoControl?type=delUserInfo&delUser=<%=user.getUser_name()%>& pageNow=<%=pageNow%>">删除</a>
                    <a href="System_Role/saveUI.html">修改</a>
                </td>
            </tr>
     <%}
     }%>
     <tr>
     <td colspan="6" align="right">
      <!-- 在此添加分页显示信息 -->
     <% if(pageNow>1){ %> 
          <a href="ShowUserInfoControl?pageNow=<%=(pageNow-1)%>">上一页</a>
      <%}
        for(int i=1;i<=pageCount;i++){
        %>
        <a href="ShowUserInfoControl?pageNow=<%=i%>" color="red"><%=i%>&nbsp;</a>

         <%}
        if(pageNow<pageCount){%>
        	   <a href="ShowUserInfoControl?pageNow=<%=(pageNow+1)%>">下一页</a>
        <% }
      %>
      <span>当前页<%=pageNow %>/<%=pageCount%>总页数</span>
                跳转到 <input type="text" width="10px" id="pageNow">
            <input type="button" value="goto" onclick="goToPage()">
         </td>
     </tr>
    </table>
   
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="AddUserControl?type=createUser"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></a>
        </div>
    </div>
</div>

</body>
</html>
