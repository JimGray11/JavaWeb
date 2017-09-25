<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String path=request.getContextPath(); 
 String BasePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 //获取用户登录错误用户信息
   String  errorMgs=(String)request.getAttribute("errorMgs");
   %>

<HTML>
<HEAD>
    <META http-equiv=Content-Type CONTENT="text/html; charset=gbk" />
	<TITLE>人力资源管理系统</TITLE>
	<LINK HREF="style/blue/login.css" type=text/css rel=stylesheet />
</HEAD>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<FORM METHOD="post" NAME="actForm"  ACTION="<%=path%>/LoginControl">
    <DIV ID="CenterAreaBg">
        <DIV ID="CenterArea">
            <DIV ID="LogoImg"><IMG BORDER="0" SRC="style/blue/images/logo.png" /></DIV>
            <DIV ID="LoginInfo">
                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                    <TR>
                        <TD width=45 CLASS="Subject"><IMG BORDER="0" SRC="style/blue/images/login/userId.gif" /></TD>
                        <TD><INPUT SIZE="20" CLASS="TextField" TYPE="text" NAME="loginName" /></TD>
                        <TD ROWSPAN="2" STYLE="padding-left:10px;"><INPUT TYPE="image" SRC="style/blue/images/login/userLogin_button.gif"/></TD>
                    </TR>
                    <TR>
                        <TD CLASS="Subject"><IMG BORDER="0" SRC="style/blue/images/login/password.gif" /></TD>
                        <TD><INPUT SIZE="20" CLASS="TextField" TYPE="password" NAME="password" /></TD>
                    </TR>
                    <TR>
                        <TD></TD>
                        <TD><span class="nameError" style="size: 20"><font size="2" color="red"><%if(errorMgs!=null){
                %><%="*"+errorMgs%><%}%></font></span></TD>
                    </TR>
                </TABLE>
            </DIV>
            <DIV ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2015软件研发小组</A></DIV>
        </DIV>
    </DIV>
</FORM>
</BODY>

</HTML>

