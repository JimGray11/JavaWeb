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
	<form action="/HRMSystem2.6/sureServlet?actionCode=record" method="post">
		<table  align="center" style=" text-align:center">
			<tr style="text-align:center">
		    	<td width="50">编&nbsp;&nbsp;&nbsp;&nbsp;号</td>
		    	<td width="60">类&nbsp;&nbsp;&nbsp;&nbsp;别</td>
		    	<td width="100">开始时间</td>
		   		<td width="100">结束时间</td>
		    	<td width="100">参&nbsp;加&nbsp;人</td>
		    	<td width="100">费&nbsp;&nbsp;&nbsp;&nbsp;用</td>
		    	<td width="100">主&nbsp;办&nbsp;方</td>
		    	<td width="100">负&nbsp;责&nbsp;人</td>
		    	<td width="100">举办方式</td>
		    	<td width="120">举办地址</td>
			</tr>
	  			<% Record record =(Record)request.getAttribute("Record"); %>
	  			
			<tr style="text-align:center">
    			<td width="50"><input type="text" name="id" value="<%=record.getRid() %>"   readonly="readonly"/> </td>
			   	<td width="60"><input type="text" name="rcategory" value="<%=record.getRcategory() %>" /></td>
			    <td width="100"><input type="text" name="rbtime" value="<%=record.getRbtime() %>" /> </td>
			    <td width="100"><input type="text" name="rotime" value="<%=record.getRotime() %>" /></td>
			    <td width="100"><input type="text" name="rjname" value="<%=record.getRjname() %>" /></td>
			    <td width="100"><input type="text" name="rcost" value="<%=record.getRcost() %>" /></td>
			    <td width="100"><input type="text" name="rhoster" value="<%=record.getRhoster() %>" /></td>
			    <td width="100"><input type="text" name="rpname" value="<%=record.getRpname() %>" /></td>
			    <td width="100"><input type="text" name="rmethod" value="<%=record.getRmethod() %>" /></td>
			    <td width="120"><input type="text" name="raddress" value="<%=record.getRaddress() %>" /></td>
			</tr>
			<tr style="border:opx; text-align:center">
			    <td colspan="10">
				    <input type="submit" class='button' value="确定">&nbsp;&nbsp;&nbsp;&nbsp;
				    <a class='button' href="/HRMSystem2.6/queryServlet?actionCode=record" >取消</a>
			    </td>
      		</tr>
		</table>
	</form>		
</body>
</html>