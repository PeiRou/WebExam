<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/ext-5.1.1/packages/ext-theme-classic/build/resources/ext-theme-classic-all.css" />
<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<!-- Icon -->
<link rel="apple-touch-icon" href="<%=request.getContextPath()%>/images/logo.png">
<link rel="icon" href="<%=request.getContextPath()%>/images/logo.png">

<style type="text/css">
</style>
<!-- JS -->
<script type="text/javascript" src="<%=request.getContextPath()%>/app/controller/jsIndex.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/ext-5.1.1/ext-all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/HelloWindow.js"></script>
<script type="text/javascript">
Ext.onReady(
		function(){
			var panel = load('<%= request.getContextPath() %>');
			panel.render('widowDiv');
		});
</script>
</head>
<body>
	<h1>Row Editing Grid Example</h1>
	<a id="page1" href="page1.jsp"><h2>自己試玩page1</h2></a>
	<a id="gameSpace" href="<%=request.getContextPath()%>/app/view/gameSpace.jsp"><h2>玩一把</h2></a>
	<a href="test1.jsp"><h2>test1</h2></a>
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-4"></div>
				<div class="col-md-4 text-left">					
					<div id="widowDiv"></div>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</div>
</body>
</html>