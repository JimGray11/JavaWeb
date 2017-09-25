<%@page import="com.hrmsystem.domain.UsersLogin"%>
<%@page import="com.hrmsystem.domain.Positions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.hrmsystem.domain.Departments"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <% ArrayList<Departments> list=(ArrayList<Departments>)request.getAttribute("listDep");
    ArrayList<Positions> listPost=(ArrayList<Positions>)request.getAttribute("listPost");
    ArrayList<UsersLogin> listLoginName=(ArrayList<UsersLogin>)request.getAttribute("listLoginName");
    
%>
 <html>
 <% String path=request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<head>
    <base href="<%=basePath%>">
	<title>用户信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
     $(function(){
        //将相关的错误提示信息隐藏
         $("#errorMgs").hide();
         //为保存添加点击事件
         $(":image").click(function(){
			  //获取用户名输入框中的值
			   var loginName=$(":text[name='loginName']").val();
			  //对该用户名进行判断
			   <%
			     if(listLoginName!=null){
			    	 for(int k=0;k<listLoginName.size();k++){
			    		 UsersLogin str=listLoginName.get(k);
			    		 %>
			    		 if((loginName=='')||(<%=str.getUser_name()%>.equals(loginName))){
					    		 $("#errorMgs").show();
					    		 $(":text[name='loginName']").val("");
					    		 return false;
					    		 }
					    		 return true;
					    		 <% }
					     }
					  %>
			return false;
		});
    	
	});
    
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 用户信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="<%=path%>/AddUserControl" method="post">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 用户信息 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">所属部门</td>
                        <td><select name="departmentId" class="SelectStyle">
                                <option value="0" selected="selected">请选择部门</option>
                        <%if(list!=null){%>
                        <% for(int i=0;i<list.size();i++){
                        	Departments department=list.get(i);
                        	%>
                                <option value="<%=department.getId()%>">┠<% if(department.getId()==department.getParentId()){%><%=department.getDepName()%><%}else{%></option>
                               
                                <option value="<%=department.getId()%>">　 ┠<%=department.getDepName()%> <%} %></option>
                                  <% }
                                }
                        		%>
                            </select> 
                        </td>
                    </tr>
                    <tr><td>登录名</td>
                        <td><input type="text" name="loginName" class="InputStyle"/> *
							<span id="errorMgs"><font size="2" color="red">该用户名已经存在，请从新输入..</font></span>
						</td>
                    </tr>
                    <tr><td>姓名</td>
                        <td><input type="text" name="subname" class="InputStyle"/> *</td>
                    </tr>
					<tr><td>性别</td>
                        <td><input type="RADIO" name="gender" value="1" id="male"/><label for="male">男</label>
							<input type="RADIO" name="gender" value="2" id="female"/><label for="female">女</label>
						</td>
                    </tr>
					<tr><td>联系电话</td>
                        <td><input type="text" name="tell_phone" class="InputStyle"/></td>
                    </tr>
                    <tr><td>E-mail</td>
                        <td><input type="text" name="e_mail" class="InputStyle"/></td>
                    </tr>
                    <tr><td>备注</td>
                        <td><textarea name="remarks" class="TextareaStyle"></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
		<div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 岗位设置 </div> 
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
						<td width="100">岗位</td>
                        <td><select name="positionId" multiple="true" size="10" class="SelectStyle">
                               <%if(listPost!=null){%>
                        <% for(int j=0;j<listPost.size();j++){
                        	Positions position=listPost.get(j);
                        	%>
                                <option value="<%=position.getId()%>"><%=position.getName()%></option>
                                  <% }
                                }
                        		%>
                            </select>
             
                        </td>
                    </tr>
                </table>
            </div>
        </div>		
		
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="ShowUserInfoControl?pageNow=1"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
</div>

</body>
</html>
