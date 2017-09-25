<!DOCTYPE html>
<%@page import="com.hrmsystem.domain.*"%>
<%@page import="com.hrmsystem.dao.impl.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function fun1() {
		var id = document.getElementById("id");
		
		if(id.value=="")
		{
			alert("类别编号不能为空！");
			id.focus();
		}

		
		
	}
	
	function fun2() {
		var name = document.getElementById("name");
		
		if(name.value=="")
		{
			alert("类别名称不能为空！");
			name.focus();
		}
		
	}
	
	function fun3() {
		
		var description = document.getElementById("description");
		
		if(description.value=="")
		{
			alert("分类描述不能为空！");
			description.focus();
		}
		
	}
	
</script>

</head>
<style>
	       .button{
      line-height:35px;
      height:35px;
      width:80px;
      color:#777777;
      background-color:#ededed;
      font-size:16px;
      font-weight:normal;
      font-family:Arial;
      background:-webkit-gradient(linear, left top, left bottom, color-start(0.05, #ededed), color-stop(1, #f5f5f5));
      background:-moz-linear-gradient(top, #ededed 5%, #f5f5f5 100%);
      background:-o-linear-gradient(top, #ededed 5%, #f5f5f5 100%);
      background:-ms-linear-gradient(top, #ededed 5%, #f5f5f5 100%);
      background:linear-gradient(to bottom, #ededed 5%, #f5f5f5 100%);
      background:-webkit-linear-gradient(top, #ededed 5%, #f5f5f5 100%);
      filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ededed', endColorstr='#f5f5f5',GradientType=0);
      border:1px solid #dcdcdc;
      -webkit-border-top-left-radius:6px;
      -moz-border-radius-topleft:6px;
      border-top-left-radius:6px;
      -webkit-border-top-right-radius:6px;
      -moz-border-radius-topright:6px;
      border-top-right-radius:6px;
      -webkit-border-bottom-left-radius:6px;
      -moz-border-radius-bottomleft:6px;
      border-bottom-left-radius:6px;
      -webkit-border-bottom-right-radius:6px;
      -moz-border-radius-bottomright:6px;
      border-bottom-right-radius:6px;
      -moz-box-shadow: inset 0px 0px 0px 0px #ffffff;
      -webkit-box-shadow: inset 0px 0px 0px 0px #ffffff;
      box-shadow: inset 0px 0px 0px 0px #ffffff;
      text-align:center;
      display:inline-block;
      text-decoration:none;
    }
    .button:hover{
      background-color:#f5f5f5;
      background:-webkit-gradient(linear, left top, left bottom, color-start(0.05, #f5f5f5), color-stop(1, #ededed));
      background:-moz-linear-gradient(top, #f5f5f5 5%, #ededed 100%);
      background:-o-linear-gradient(top, #f5f5f5 5%, #ededed 100%);
      background:-ms-linear-gradient(top, #f5f5f5 5%, #ededed 100%);
      background:linear-gradient(to bottom, #f5f5f5 5%, #ededed 100%);
      background:-webkit-linear-gradient(top, #f5f5f5 5%, #ededed 100%);
      filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f5f5f5', endColorstr='#ededed',GradientType=0);
    }
</style>
<body>
	
	<% 
		Category category = (Category)request.getAttribute("Category");
	%>

		<form action="/HRMSystem2.6/sureServlet?actionCode=category" method="post">
    	<table width="589"  align="center">
  <tbody>
    <tr style="border:1px solid #98bf21;  text-align:center">
      <td width="77">编号</td>
      <td width="182">名称</td>
      <td width="203">描述</td>
      <td width="99">备注</td>
    </tr>
    <tr style="border:1px solid #98bf21;  text-align:center">
      <td><input type="text" name="id" id="id" value="<%=category.getId() %>"  onblur="fun1()" readonly="readonly" /></td>
      <td><input type="text" name="name" id="name" value="<%=category.getCategoryname() %>" onblur="fun2()" /></td>
      <td><input type="text" name="description" id="description" value="<%=category.getDescription() %>" onblur="fun3()" /></td>
      <td><input type="text" name="remark" id="d" value="<%=category.getRemark() %>"></td>
    </tr>
    <tr style="border:opx; text-align:center">
      <td colspan="2"><input type="submit" class='button' value="确定"></td>
      <td colspan="2"><a class='button' href="/HRMSystem2.6/queryServlet?actionCode=category" >取消</a></td>
      </tr>
  </tbody>
</table>

  </form>
</body>
</html>