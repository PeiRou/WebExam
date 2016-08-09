<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page1</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ext-5.1.1/packages/ext-theme-classic/build/resources/ext-theme-classic-all.css" />
<!-- Bootstrap Core CSS -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<!-- For this -->

<!-- Icon -->
	<link rel="apple-touch-icon"
	href="<%=request.getContextPath()%>/images/logo.png">
<link rel="icon" href="<%=request.getContextPath()%>/images/logo.png">
<!-- JS -->
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/ext-5.1.1/ext-all.js"></script>

<!-- CSS -->

<style type="text/css"></style>
<script type="text/javascript">
Ext.Loader.require('ui.LoginForm');

Ext.onReady(function (){
	var form = Ext.createWidget('ui.LoginForm',{
		width:250,
		frame:true,
		renderTarget:'loginFormDiv',
		fieldWidth:220
		//url:Ext.fly('loginUrl'),getAttribute('href')
	});
	//要求描繪出來
	form.renderForm();
})
</script>
</head>
<body>
	<div id="loginFormDiv"></div>
</body>
</html>