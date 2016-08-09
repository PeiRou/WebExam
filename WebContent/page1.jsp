<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page1</title>
	<!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">  
    <!-- Jquery UI CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="apple-touch-icon" href="images/logo.png">
	<link rel="icon" href="images/logo.png">	
	<script type="text/javascript" src="js/script.js"></script>
	<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>	
</head>
	<body>
		<div class="container">
		<div class="row">
			<div class="box">
					<div class="col-md-4"></div>
					<div class="col-md-4 text-center">
						<img src="images/123.jpg">
					</div>
					<div class="col-md-4"></div>
			</div>
		</div>
		<div class="row">
			<div class="box">
					<div class="col-md-5"></div>
					<div class="col-md-2 text-center">
						<a class="btn btn-primary btnclk">開始抽吧</a>
					</div>
					<div class="col-md-5"></div>
			</div>
		</div>
	</div>
	<div class="row">
			<div class="box">
					<div class="col-md-5"></div>
					<div class="col-md-2 text-center">
						目前自己的分數:<a id="myscore">2000</a>
					</div>
					<div class="col-md-5"></div>
			</div>
	</div>
	
	<div class="row">
			<div class="box">
					<div class="col-md-5"></div>
					<div class="col-md-2 text-center">
						累積分數:<a id="score">1000</a>
					</div>
					<div class="col-md-5"></div>
			</div>
	</div>
		
	<div class="row">
			<div class="box">
					<div class="col-md-5"></div>
					<div class="col-md-2 text-center">
						累積手續費:<a id="fee">0</a>
					</div>
					<div class="col-md-5"></div>
			</div>
	</div>
	</body>
	<script type="text/javascript">
		$( ".btnclk" ).on( "click", function( event ) {			
			var mysum = parseInt($("#myscore").html())-20;
			if(mysum<=0){
				alert("拍謝請儲值~")
				return;
			}
			$("#myscore").html(mysum);
			var sum = parseInt($("#score").html())+20;
			$("#score").html(sum);
			
			
			var rdm = getRandomArray(0,100,1);
			console.log("亂數:"+rdm);	
			aa(rdm);			
		});
	
		//localStorage.clear();
		function aa(rdm){
			if(rdm>=98){
				console.log("你中大獎了!");
				var total =  parseInt($("#myscore").html()) + parseInt($("#score").html()) -10;
				$("#myscore").html(total);
				$("#score").html("0");
				
				var fee = parseInt($("#fee").html())+10;
				$("#fee").html(fee);
			}else if(rdm>80){
				console.log("還好中個小獎~");
				
				var mysum = parseInt($("#myscore").html())+40;
				$("#myscore").html(mysum);
				var sum = parseInt($("#score").html())-50;
				$("#score").html(sum);
				var fee = parseInt($("#fee").html())+10;
				$("#fee").html(fee);
			}else{
				console.log("再接再厲~");
			}
		}
		function chkScore(){
			
		}
	</script>
</html>