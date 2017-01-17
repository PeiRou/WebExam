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
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Jquery UI CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="apple-touch-icon" href="images/logo.png">
<link rel="icon" href="images/logo.png">

<style type="text/css">
</style>
<!-- JS -->
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/ext-5.1.1/ext-all.js"></script>
<!-- <script type="text/javascript" src="HelloWindow.js"></script> -->
<script type="text/javascript">
// Ext.onReady(function(){
// 	var helloWindow = new HelloWindow({
// 		items:{
// 			html:'<p>helloword</p>'
// 		}
// 	}); 
// 	helloWindow.show('widowDiv');
// });
Ext.onReady(function(){
	Ext.create('Ext.window.Window', {
	    title: 'Hello',
	    height: 200,
	    width: 400,
	    layout: 'fit',
	    items: {  // Let's put an empty grid in just to illustrate fit layout
	        xtype: 'grid',
	        border: false,
	        columns: [{header: 'World'}],                 // One header just for show. There's no data,
	        store: Ext.create('Ext.data.ArrayStore', {}) // A dummy empty data store
	    }
	}).show();
});
</script>
</head>
<body>
	<h1>Row Editing Grid Example</h1>
	<a href="page1.jsp"><h2>page1</h2></a>
	<a href="test1.jsp"><h2>test1</h2></a>
	<div id="widowDiv"></div>
	<div class="container">
		<div class="row">
			<div class="box">
				<div class="col-md-4"></div>
				<div class="col-md-4 text-left">
					<form role="form">
						<div class="form-group">
							<h2>登入</h2>
							<label for="exampleInputEmail1">帳號</label> <input type="email"
								class="form-control" id="exampleInputEmail1" placeholder="輸入帳號">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">密碼</label> <input type="密碼"
								class="form-control" id="exampleInputPassword1"
								placeholder="Password">
						</div>
						<button type="submit" class="btn btn-default">送出</button>
					</form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</div>
</body>
</html>