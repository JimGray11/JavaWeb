<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.hrmsystem.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	    .button{
      line-height:30px;
      height:30px;
      width:70px;
      color:#ffffff;
      background-color:#a4bee9;
      font-size:16px;
      font-weight:normal;
      font-family:Arial;
      border:0px solid #dcdcdc;
      -webkit-border-top-left-radius:3px;
      -moz-border-radius-topleft:3px;
      border-top-left-radius:3px;
      -webkit-border-top-right-radius:3px;
      -moz-border-radius-topright:3px;
      border-top-right-radius:3px;
      -webkit-border-bottom-left-radius:3px;
      -moz-border-radius-bottomleft:3px;
      border-bottom-left-radius:3px;
      -webkit-border-bottom-right-radius:3px;
      -moz-border-radius-bottomright:3px;
      border-bottom-right-radius:3px;
      -moz-box-shadow: inset 0px 0px 0px 0px #ffffff;
      -webkit-box-shadow: inset 0px 0px 0px 0px #ffffff;
      box-shadow: inset 0px 0px 0px 0px #ffffff;
      text-align:center;
      display:inline-block;
      text-decoration:none;
    }
    .button:hover{
      background-color:#de5871;
    }


</style>


<body>
	<form action="/HRMSystem2.6/sureServlet?actionCode=score" method="post">
		<table align="center" style=" text-align:center" >	
			<tr style="text-align:center">
				<td width="100">编号</td>
				<td width="100">姓名</td>
				<td width="100">部门名称</td>
				<td width="100">培训名称</td>
				<td width="100">成绩</td>
				<td width="100">是否合格</td>
			</tr>
			
			<% Score score = (Score)request.getAttribute("Score");
				%>
			
			
			<tr>
				<td><input type="text" name="sid" value="<%=score.getSid() %>" readonly="readonly" /></td>
				<td><input type="text" name="spname" value="<%=score.getSpname() %>" /> </td>
				<td><input type="text" name="sdname" value="<%=score.getSdname() %>" /></td>
				<td><input type="text" name="eduname" value="<%=score.getEduname() %>" /></td>
				<td><input type="text" name="score" value="<%=score.getScore() %>" /></td>
				<td><input type="text" name="pass" value="<%=score.getPass() %>" /></td>
			
			</tr>
		
			<tr style="border:opx; text-align:center">
			    <td colspan="6">
				    <input type="submit" class='button' value="确定">&nbsp;&nbsp;&nbsp;&nbsp;
				    <a class='button' href="/HRMSystem2.6/queryServlet?actionCode=score" >取消</a>
			    </td>
      		</tr>
		</table>
	</form>
</body>
</html>