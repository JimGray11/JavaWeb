<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.hrmsystem.domain.*" %>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		function chooseAll() {
			var all = document.getElementById("all");
			var ch = document.getElementsByName("ch");
			for(var i=0;i<ch.length;i++) {
				ch[i].checked = all.checked;
			}
		}
</script>


</head>
<style>

#TableTitle {
	height: 25px;
	}
	
	#TableTitle td {
	height: 25px;
	border-left: 1px solid #d2d2d2;
	border-right: 1px solid #ffffff;
	border-top: 1px solid #d2d2d2;
	filter: progid:DXImageTransform.Microsoft.gradient(startcolorstr=#e6e6e6,endcolorstr=#ffffff,gradientType=0);
	}
	
	#TableTitle td.tdEnd {
	height: 25px;
	border-left: 1px solid #d2d2d2;
	border-right: 1px solid #d2d2d2;
	border-top: 1px solid #d2d2d2;
	filter: progid:DXImageTransform.Microsoft.gradient(startcolorstr=#e6e6e6,endcolorstr=#ffffff,gradientType=0);
	}
	
	#TableData td {
	height: 24px;
	vertical-align: middle;
	border-top: 1px solid #d2d2d2;
	padding-left: 8px;
	}
	
	#TableData tr.TableDetail1 {
	background-color: #ffffff;
	vertical-align: bottom;
	height: 22px;
	}
	
	#TableData tr.TableDetail2 {
	background-color: #ffffff;
	height: 22px;
	}
	
	#TableData tr.selectLine {
	background-color: #deecf7;
	height: 22px;
	}
	
	.TableStyle {
	font-size: 12px;
	color: #004779;
	width: 100%;
	border: none;
	}


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
	<form action="/HRMSystem2.6/deleteServlet?actionCode=scoreDelete" method="post">
		<table align="center" style=" text-align:center" class="TableStyle" >	
			<tr id="TableTitle" valign="middle">
				<td width="30"></td>
				<td width="100">编号</td>
				<td width="100">姓名</td>
				<td width="100">部门名称</td>
				<td width="100">培训名称</td>
				<td width="100">成绩</td>
				<td width="100">是否合格</td>
				<td width="100" colspan="2">操作</td>
			</tr>
			
			<% List<Score> list = (List<Score>)request.getAttribute("Score");
			
				for(int index = 0 ; index < list.size();index++)
				{
					Score score =list.get(index);
				
				%>
			
			<tbody id="TableData" class="dataContainer" datakey="formList">	
			<tr>
				<td style="text-align:left"><input type="checkbox" name="ch" value=<%=score.getSid() %> /></td>
				<td><%=score.getSid() %></td>
				<td><%=score.getSpname() %></td>
				<td><%=score.getSdname() %></td>
				<td><%=score.getEduname() %></td>
				<td><%=score.getScore() %></td>
				<td><%=score.getPass() %></td>
				<td>
					<a class='button' href="/HRMSystem2.6/updateServlet?actionCode=scoreEdit&id=<%= score.getSid() %>"  target="right" >编辑</a>	
				</td>
				<td>
					<a class='button' href="/HRMSystem2.6/updateServlet?actionCode=scoreDelete&id=<%= score.getSid() %>" >删除</a>
				</td>
			</tr>
			<% } %>
			<tr style="text-align:left">
				<td colspan="13" >
				  	<input type="checkbox" id="all" onclick="chooseAll()" />&nbsp;&nbsp;全选&nbsp;&nbsp;
				  	<a href="Edu/addScore.jsp" class='button' >增加</a>&nbsp;&nbsp;&nbsp;&nbsp;
				  	<input class="button" type="submit" value="删除" />
				  <!--  	<a class='button' href="/HRMSystem1.4/updateServlet?actionCode=scoreDelete&id" >删除</a> -->
		  		</td>
		  	</tr>
		  	</tbody>
		  	<!-- 分页 -->
		  	<tr>
			   				<td colspan="9" align="center">
			   					共有${page.recordcount}条记录&nbsp;
			   					每页显示<input type="text" id="pagesize" value="${page.pagesize }" size="2" onblur="forward1()"/>条记录&nbsp;
			   					共有${page.pagecount }页
			   					<c:choose>
			   						<c:when test="${page.pagenum==1}">
			   							首页
			   							上一页
			   						</c:when>
			   						<c:otherwise>
			   							<a href="docBaseInfoServlet?item=view&pagenum=1&pagesize=15" id="pageFirst">首页</a>
			   							<a href="docBaseInfoServlet?item=view&pagenum=${page.pagenum-1}&pagesize=${page.pagesize}">上一页</a>
			   						</c:otherwise>
			   					</c:choose>
			   					<c:choose>
			   						<c:when test="${page.pagenum==page.pagecount}">
			   							下一页
			   							尾页
			   						</c:when>
			   						<c:otherwise>
			   							<a href="docBaseInfoServlet?item=view&pagenum=${page.pagenum+1}&pagesize=${page.pagesize}">下一页</a>
			   							<a href="docBaseInfoServlet?item=view&pagenum=${page.pagecount}&pagesize=${page.pagesize}">尾页</a>
			   						</c:otherwise>
			   					</c:choose>
			   					
			   					跳转到第<input type="text" value="${page.pagenum }" size="2" id="pagenum" onblur="forward2()"/>页
			   				</td>
			   			</tr>
		  	
		  	
		  	
		</table>
		
		
		 <input type="hidden" value="${page.recordcount}" id="recordcount" /> 
 		 <input type="hidden" value="${page.pagecount}" id="pagecount" />
	</form>
</body>
</html>