<%@ page language="java" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="jquery/jquery.blockUI.js"></script>
	</HEAD>
	<script type="text/javascript">
	
	  //二级联动使用 ajax处理
	  $(function(){
		  $(document).ajaxStart(function(){
			  $.blockUI({
				  message: $('#loading'), 
		            css: { 
		                top:  ($(window).height() - 400) /2 + 'px', 
		                left: ($(window).width() - 400) /2 + 'px', 
		                width: '400px' ,

		                border:'none'
		            } ,
				  
			  overlayCSS: { backgroundColor: '#BEBEBE' } 

			  }) 
		  
		  
		  }).ajaxStop($.unblockUI);
		  
		  
		  
		  $("#category").change(function(){
			  //需要将二级菜单栏全部清空
			  $("#categorySecond option:not(:first)").remove();
			  var categoryVal=$(this).val();
			  //如果选中的值不为空则 发送ajax请求
			  if(categoryVal !=""){
				  var url="manageGoods_getTwoGoodsType.action";
				  var  args={"oid":categoryVal,"date":new Date()};
				  $.getJSON(url,args,function(data){
					 //取出JSON 中的字符串
					 for(var i=0;i<data.length;i++){
						 var tid=data[i].tid;
						 var name=data[i].name;
						 //将两个和拼接为<option></option>
						 var aNote="<option value='"+tid+"'>"+name+"</option>";
						 //将该节点添加id为categorySecond的节点下
						 $("#categorySecond").append(aNote);
				 
					 }
					  
					  
				  });
				  
			  }
			  
			  
		  });
		  
		  
	  });
	  
	  function  callBackList(){
		  window.location.href="manageGoods_showList?page=1";
	  }
	</script>
	
	<body>
	    <img alt="" src="${pageContext.request.contextPath}/images/loading.gif" id="loading" style="display: none;"/>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/manageGoods_save.action" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellspacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr style="height: 80px; width: 100%;">
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>添加商品</STRONG>
						</strong>
					</td>
				</tr>
                
				<tr style="height: 60px; width: 100%;">
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="goods.name" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="goods.is_hot">
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</td>
				</tr>
				<tr style="height: 40px; width: 100%;">
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						市场价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="goods.marketPrice" value="" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商城价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="goods.price" value="" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				
				<tr style="height: 40px; width: 100%;">
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属的一级分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<select id="category">
						<option value="">--请选择--</option>
						<c:forEach items="${oneList}" var="o">
								<option value="${o.oid }">${o.name}</option>
							</c:forEach>
						</select>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属的二级分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" >
						<select name="goods.twoGoodsType.tid" id="categorySecond">
						  <option value="">--请选择--</option>
						</select>
					</td>
				</tr>
				<tr style="height: 80px; width: 100%;">
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" name="up" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						商品描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="goods.description" rows="5" cols="30"></textarea>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="callBackList()" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>