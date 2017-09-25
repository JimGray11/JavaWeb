<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
function fun1() {
	var id = document.getElementById("id");
	
	if(id.value=="")
	{
		alert("编号不能为空！");
		id.focus();
	}
</script>


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
<div style=" margin-top:100px" >
	<form action="/HRMSystem2.6/addServlet?actionCode=addrecord" method="post">
    	<table  align="center" style=" text-align:center; border-collapse:sparate; border-spacing: 10px">
				<tr style="text-align:right">
					<td width="100">编号:</td>
					<td width="100"><input type="text" name="id" onblur="fun1()" id="id" /> </td>
				</tr>
				<tr style="text-align:right">
					<td width="100">类别:</td>
					<td width="100"><input type="text" name="rcategory" /></td>
				</tr>
				<tr style="text-align:right">
					<td width="100">开始时间:</td>
					<td width="100"><input type="text" name="rbtime" /> </td>
				</tr>
				<tr style="text-align:right">
					<td width="100">结束时间:</td>
					<td width="100"><input type="text" name="rotime" /></td>
				</tr>
				<tr style="text-align:right">
					<td width="100">惨加人:</td>
					<td width="100"><input type="text" name="rjname" /></td>
				</tr>
				<tr style="text-align:right">
					<td width="100">费用:</td>
					<td width="100"><input type="text" name="rcost" /></td>
				</tr>
				<tr style="text-align:right">
					<td width="100">主办方:</td>
					<td width="100"><input type="text" name="rhoster" /></td>
				</tr>
				<tr style="text-align:right">
					<td width="100">负责人:</td>
					<td width="100"><input type="text" name="rpname" /></td>
				</tr>
				<tr style="text-align:right">
					<td width="100">举办方式:</td>
					<td width="100"><input type="text" name="rmethod" /></td>
				</tr>
				<tr style="text-align:right">
					<td width="100">举办地址:</td>
					<td width="100"><input type="text" name="raddress" /></td>
				</tr>
				  
			   <tr style="text-align:right">
			  <td colspan="10"><input type="submit" class="button"  value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;
			  <a class='button' href="/HRMSystem2.6/queryServlet?actionCode=record">取消</a>
			  </td>
			  
			  </tr>
  		</table>
  	</form>	
 </div> 	
</body>
</html>