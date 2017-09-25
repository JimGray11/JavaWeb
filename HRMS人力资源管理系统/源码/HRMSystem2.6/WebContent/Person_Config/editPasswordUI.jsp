<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <% String path=request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
 
<head>
<base href="<%=basePath%>">
	<title>修改密码</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath}/script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="style/blue/pageCommon.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
    //对密码框的中是否为空信息的校验
     $(function(){
      //保存添加点击事件
         $("#oldError").hide();
         $("#newError").hide();

         //为文本框  设置焦点
         $(":password[name='oldPassword']").focus();
           $(":image").click(function(){
            //获取输入框中的值
             var $oldPassword=$(":password[name='oldPassword']");
             var $passwrod=$(":password[name='password']");
             var $passwrod2=$(":password[name='password2']");
             
            
             if($oldPassword.val()==''){
            	 $("#oldError").show(); 
            	 //获取焦点
            	 $oldPassword.focus();
            	 return false;
             }
              if($passwrod.val()==''||($passwrod.val()!=$passwrod2.val())){
                 $("#newError").show();
            	  return false;
             }else{
            	return true;
             }
             //取消按钮的自动提交功能
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}style/images/title_arrow.gif"/> 修改密码
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<!--显示表单内容-->
<div id=MainArea>
    <form action="${pageContext.request.contextPath}/UpdatePasswordControl" method="post">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 修改密码 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<tr height="50">
						<td width="150">
							<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							请输入原密码
						</td>
						<td><input type="password" name="oldPassword" class="InputStyle" /> *<span id=oldError><font size="2" color="red">请输入原密码</font></span></td>
					</tr>
					<tr height="25">
						<td width="150">
							<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							请填写新密码
						</td>
						<td><input type="password" name="password" class="InputStyle" /> *</td>
						<td></td>
					</tr>
					<tr height="25">
						<td width="150">
							<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/style/blue/images/item_point.gif" />
							再次输入新密码
						</td>
						<td><input type="password" name="password2" class="InputStyle" />*<span id=newError><font size="2" color="red">两次输入的密码不一致</font></span></td>
						<td></td>
					</tr>
                </table>
            </div>
        </div>
       
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
        </div>
    </form>
</div>

<div class="Description">
</div>

</body>
</html>
