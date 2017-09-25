<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="totalCounter" class="com.hrmsystem.domain.Counter" scope="application"></jsp:useBean>

<html>
<head>
    <title>Bottom</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="style/blue/statusbar.css" />
</head>
<body style="margin:0"> 

<div id="StatusBar">
    <div id="Online">
    	在线人员：共 <span class="OnlineUser" id="onlineUserNum"><jsp:getProperty name="totalCounter" property="count"></jsp:getProperty></span> 人
        <span class="OnlineView"><a href="javascript:void(0)">[查看在线名单]</a></span>
    </div>
    <div id="Info">
    	<a href="#" title = "人才市场首页" target="_blank">人才市场首页</a> |
        <a href="http://www.51job.com/" title = "51job前程无忧网" target="_blank">51job前程无忧网</a> 
    </div>
    <div id="DesktopText">
        <a href="javascript:void(0)"><img border="0" src="style/images/top/text.gif"/>便笺</a>
        <span id=TryoutInfo></span>
        <span id="Version">
            <a href="javascript:void(0)">
            	<img border="0" width="11" height="11" src="style/images/top/help.gif" /> 
                <img border="0" width="40" height="11" src="style/blue/images/top/version.gif" />
            </a>
        </span>
    </div>
</div>

</body>
</html>
