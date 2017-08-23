<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>入会申请</title>
<meta name="keywords" content="">
<meta name="description" content="">

<style type="text/css">
	
	.page-container{
		
		border:2px solid  #AAAAAA;
		margin-top: 50px;
	}
	#th{
		font-size: 30px;
		border-bottom:1px solid  #AAAAAA;
		
		
	}
	
	.row cl{
		border-bottom:1px solid  red;
	}
	

</style>
</head>
	<body>
	<div id="content" class="page-container">
	
	<sf:form method="post" modelAttribute="userDto" class="form form-horizontal" id="form-member-add">
	<table width="800" cellspacing="0" cellPadding="0" class="table table-border table-bordered" >
		<thead ><tr><td colspan="2" id="th">入会申请</td></tr></thead>
		
		<tr class="row cl">
			<td class="rightTd" width="200px">用户名(必须是英文):</td>
			<td class="leftTd"><sf:input path="username" size="30"/><sf:errors cssClass="errorContainer" path="username"/></td>
		</tr>
		
		<tr>
			<td class="rightTd">用户密码:</td><td><sf:password path="password" size="30"/><sf:errors cssClass="errorContainer" path="password"/></td>
		</tr>
		
		<tr>
			<td class="rightTd">姓名:</td><td><sf:input path="realname" size="30"/><sf:errors cssClass="errorContainer" path="realname"/></td>
		</tr>
		<tr>
			<td class="rightTd">性别:</td>
			<td>
				<sf:select path="sex">
					<sf:option value="0">男性</sf:option>
					<sf:option value="1">女性</sf:option>
				</sf:select>
			</td>
		</tr>
		
		<tr>
			<td class="rightTd">联系电话:</td><td><sf:input path="phone" size="30"/><sf:errors path="phone"/></td>
		</tr>
		
		<tr>
			<td class="rightTd">出生日期:</td><td><sf:input path="bore" size="30"/><sf:errors path="bore"/></td>
		</tr>
		<tr>
			<td class="rightTd">行业分会:</td><td><sf:input path="hyfh" size="30"/><sf:errors path="hyfh"/></td>
		</tr>
		<tr>
			<td class="rightTd">专委会:</td><td><sf:input path="zwh" size="30"/><sf:errors path="zwh"/></td>
		</tr>
		<tr>
			<td class="rightTd">推荐人:</td><td><sf:input path="introducer" size="30"/></td>
		</tr>
		
		<tr>
			<td class="rightTd">家庭住址:</td><td><sf:input path="address" size="30"/></td>
		</tr>
		<tr>
			<td class="rightTd">电子邮件:</td><td><sf:input path="email" size="30"/><sf:errors path="email"/></td>
		</tr>
		
		
		
	
	
		<tr>
			<td colspan="2" class="centerTd"><input class="btn btn-success radius" type="submit" value="申请入会"/><input type="reset" class="btn btn-warning radius"/></td>
			
		</tr>
	</table>
	</sf:form>
</div>
	
	</body>
</html>