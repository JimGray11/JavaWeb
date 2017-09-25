<%@page import="com.hrmsystem.domain.Departments"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<Departments> list=(ArrayList<Departments>)request.getAttribute("depList");
%>
 <%-- 
 <jsp:useBean id="department" class="com.hrmsystem.domain.Departments" scope="page"></jsp:useBean>
 //设置department的所有属性值，属性值从request 中自动获取 。*表示所有属性 
 <jsp:setProperty  name="department" property="*"/>
 
 <%request.setAttribute("department",department); 
   out.println(department.getDepName()+department.getTaskDesc());
 %>
 <jsp:forward page="/HRMSystem1.6/DepartmentControl"></jsp:forward>
 --%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>部门设置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/pageCommon.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
     $(function(){
        //将相关的错误提示信息隐藏
         $("#parentError").hide();
         $("#depError").hide();
         //为保存添加点击事件
          $(":image").click(function(){
        	  var parentId=$(":input[name='parentId']").val();
              var depName=$(":input[name='depName']").val();
              //判断用户是否输入为空
              if(parentId==0){
            	  $("#parentError").show(); 
            	  return  false;
              }else if(depName==""){
            	  $("#depError").show(); 
            	  return  false; 
              }else
                 return  true;
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 部门信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <form action="${pageContext.request.contextPath}/AddDepartmentControl" method="post">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr><td width="100">上级部门</td>
                        <td><select name="parentId" class="SelectStyle">
                         <option value="0" selected="selected">--请选择部门--</option>
                         <%if(list!=null){%>
                        <% for(int i=0;i<list.size();i++){
                        	Departments department=list.get(i);
                        	%>
                                <option value="<%=department.getId()%>">┠<% if(department.getId()==department.getParentId()){%><%=department.getDepName()%><%}else{%></option>
                               
                                <option value="<%=department.getId()%>">　 ┠<%=department.getDepName()%> <%} %></option>
                                  <% }
                                }
                        		%>
                            </select>&nbsp;*
							<span id="parentError"><font size="2" color="red">请选择上级部门</font></span>
                        </td>
                        
                    </tr>
                    <tr><td>部门名称</td>
                        <td><input type="text" name="depName" class="InputStyle"/> *<span id="depError"><font size="2" color="red">请填写部门名称</font></span></td>
                        
                    </tr>
                    <tr><td>职能说明</td>
                        <td><textarea name="taskDesc" class="TextareaStyle"></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image"  src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="ShowDepartmentControl"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </form>
</div>

<div class="Description">
</div>

</body>
</html>
